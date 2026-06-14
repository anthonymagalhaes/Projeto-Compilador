package org.example;

import org.example.enums.TipodeDado;
import org.example.gen.LanguageBaseVisitor;
import org.example.gen.LanguageParser;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Object>
{

    private TabelaSimbolos escopoAtual;
    private int deslocamentoGlobal = 0;

    public LanguageCustomVisitor()
    {
        this.escopoAtual = new TabelaSimbolos(null);
    }

    @Override
    public Object visitProg(LanguageParser.ProgContext ctx)
    {
        System.out.println("--- Iniciando Análise Semântica ---");

        Object resultado = super.visitProg(ctx);

        System.out.println("--- Análise Semântica Concluída sem Erros Extremos ---");
        return resultado;
    }
    @Override
    public Object visitCmdIfCasado(LanguageParser.CmdIfCasadoContext ctx)
    {
        if (ctx.IF() != null || ctx.WHILE() != null)
        {
            TipodeDado tipoCondicao = (TipodeDado) visit(ctx.expr());
            if (tipoCondicao != TipodeDado.BOOLEAN)
            {
                throw new RuntimeException("Erro Semântico: A condição do " +
                        (ctx.IF() != null ? "IF" : "WHILE") + " deve ser BOOLEAN.");
            }
        }
        return super.visitCmdIfCasado(ctx);
    }

    @Override
    public Object visitCmdIfNaoCasado(LanguageParser.CmdIfNaoCasadoContext ctx)
    {
        if (ctx.IF() != null || ctx.WHILE() != null)
        {
            TipodeDado tipoCondicao = (TipodeDado) visit(ctx.expr());
            if (tipoCondicao != TipodeDado.BOOLEAN)
            {
                throw new RuntimeException("Erro Semântico: A condição do " +
                        (ctx.IF() != null ? "IF" : "WHILE") + " deve ser BOOLEAN.");
            }
        }
        return super.visitCmdIfNaoCasado(ctx);
    }

    @Override
    public Object visitCmdRead(LanguageParser.CmdReadContext ctx)
    {
        LanguageParser.ListIdContext lista = ctx.listId();

        while (lista != null)
        {
            String nomeVar = lista.IDENTIFIER().getText();
            Simbolo simbolo = escopoAtual.buscar(nomeVar);

            if (simbolo == null)
            {
                throw new RuntimeException("Erro Semântico: Tentativa de leitura na variável '" +
                        nomeVar + "', mas ela não foi declarada.");
            }

            lista = lista.listId();
        }
        return super.visitCmdRead(ctx);
    }

    @Override
    public Object visitCmdComp(LanguageParser.CmdCompContext ctx)
    {
        TabelaSimbolos escopoFilho = new TabelaSimbolos(escopoAtual);
        escopoAtual = escopoFilho;
        Object resultado = super.visitCmdComp(ctx);
        escopoAtual = escopoAtual.getEscopoPai();

        return resultado;
    }

    @Override
    public Object visitDeclTip(LanguageParser.DeclTipContext ctx)
    {
        String textoTipo = ctx.tip().getText().toUpperCase();
        TipodeDado tipoDaLinha;
        int tamanhoEmBytes = 0;

        switch (textoTipo)
        {
            case "INTEGER":
                tipoDaLinha = TipodeDado.INTEGER;
                tamanhoEmBytes = 2;
                break;
            case "BOOLEAN":
                tipoDaLinha = TipodeDado.BOOLEAN;
                tamanhoEmBytes = 1;
                break;
            case "STRING":
                tipoDaLinha = TipodeDado.STRING;
                tamanhoEmBytes = 300;
                break;
            default:
                throw new RuntimeException("Erro Semântico: Tipo de dado desconhecido.");
        }

        LanguageParser.ListIdContext lista = ctx.listId();

        while (lista != null)
        {
            String nomeVar = lista.IDENTIFIER().getText();
            escopoAtual.inserir(nomeVar, tipoDaLinha, deslocamentoGlobal);

            System.out.println("[Tabela de Símbolos] Variável '" + nomeVar + "' (" + tipoDaLinha + ") alocada. Deslocamento: " + deslocamentoGlobal);
            deslocamentoGlobal += tamanhoEmBytes;
            lista = lista.listId();
        }
        return super.visitDeclTip(ctx);
    }

    @Override
    public Object visitCmdAtrib(LanguageParser.CmdAtribContext ctx)
    {
        String nomeVar = ctx.IDENTIFIER().getText();
        Simbolo simbolo = escopoAtual.buscar(nomeVar);

        if (simbolo == null)
        {
            throw new RuntimeException("Erro Semântico: A variável '" + nomeVar + "' não foi declarada antes do uso.");
        }

        TipodeDado tipoExpressao = (TipodeDado) visit(ctx.expr());

        if (simbolo.getTipo() != tipoExpressao)
        {
            throw new RuntimeException("Erro Semântico: Incompatibilidade de tipos na atribuição. " +
                    "A variável '" + nomeVar + "' é " + simbolo.getTipo() + ", mas recebeu um valor " + tipoExpressao + ".");
        }
        return super.visitCmdAtrib(ctx);
    }

    @Override
    public Object visitTermo(LanguageParser.TermoContext ctx)
    {
        if (ctx.CTE() != null)
        {
            return TipodeDado.INTEGER;
        }
        else if(ctx.CADEIA() != null)
        {
            return TipodeDado.STRING;
        }
        else if (ctx.TRUE() != null || ctx.FALSE() != null)
        {
            return TipodeDado.BOOLEAN;
        }
        else if (ctx.IDENTIFIER() != null)
        {
            String nomeVar = ctx.IDENTIFIER().getText();
            Simbolo simbolo = escopoAtual.buscar(nomeVar);
            if (simbolo == null)
            {
                throw new RuntimeException("Erro Semântico: Variável '" + nomeVar + "' não declarada.");
            }
            return simbolo.getTipo();

        }

        else if (ctx.ABPAR() != null)
        {
            return visit(ctx.expr());
        }

        else if (ctx.OPNEG() != null)
        {
            TipodeDado tipoInterno = (TipodeDado) visit(ctx.termo());
            if (tipoInterno != TipodeDado.BOOLEAN)
            {
                throw new RuntimeException("Erro Semântico: O operador de negação '~' só aceita operandos BOOLEAN.");

            }
            return TipodeDado.BOOLEAN;
        }

        else if (ctx.OPAD() != null)
        {
            TipodeDado tipoInterno = (TipodeDado) visit(ctx.termo());
            if (tipoInterno != TipodeDado.INTEGER)
            {
                throw new RuntimeException("Erro Semântico: Operadores de sinal (+ ou -) só aceitam operandos INTEGER.");
            }
            return TipodeDado.INTEGER;
        }
        return null;
    }

    @Override
    public Object visitExprMult(LanguageParser.ExprMultContext ctx)
    {
        if (ctx.OPMULT() == null)
        {
            return visit(ctx.termo());
        }

        TipodeDado tipoEsq = (TipodeDado) visit(ctx.exprMult());
        TipodeDado tipoDir = (TipodeDado) visit(ctx.termo());

        if (tipoEsq != TipodeDado.INTEGER || tipoDir != TipodeDado.INTEGER)
        {
            throw new RuntimeException("Erro Semântico: Operações matemáticas (*, /) exigem operandos do tipo INTEGER.");
        }
        return TipodeDado.INTEGER;
    }

    @Override
    public Object visitExprSimple(LanguageParser.ExprSimpleContext ctx)
    {
        if (ctx.OPAD() == null)
        {
            return visit(ctx.exprMult());
        }

        TipodeDado tipoEsq = (TipodeDado) visit(ctx.exprSimple());
        TipodeDado tipoDir = (TipodeDado) visit(ctx.exprMult());

        if (tipoEsq != TipodeDado.INTEGER || tipoDir != TipodeDado.INTEGER)
        {
            throw new RuntimeException("Erro Semântico: Operações matemáticas (+, -) exigem operandos do tipo INTEGER.");
        }
        return TipodeDado.INTEGER;
    }

    @Override
    public Object visitExprRel(LanguageParser.ExprRelContext ctx)
    {
        if (ctx.OPREL() == null)
        {
            return visit(ctx.exprSimple());
        }

        TipodeDado tipoEsq = (TipodeDado) visit(ctx.exprRel());
        TipodeDado tipoDir = (TipodeDado) visit(ctx.exprSimple());

        if (tipoEsq != tipoDir)
        {
            throw new RuntimeException("Erro Semântico: O operador relacional '" + ctx.OPREL().getText() + "' exige operandos do mesmo tipo.");
        }

        return TipodeDado.BOOLEAN;
    }

    @Override
    public Object visitExpr(LanguageParser.ExprContext ctx)
    {
        if (ctx.OPLOG() == null)
        {
            return visit(ctx.exprRel());
        }

        TipodeDado tipoEsq = (TipodeDado) visit(ctx.expr());
        TipodeDado tipoDir = (TipodeDado) visit(ctx.exprRel());

        if (tipoEsq != TipodeDado.BOOLEAN || tipoDir != TipodeDado.BOOLEAN)
        {
            throw new RuntimeException("Erro Semântico: Operadores lógicos (AND, OR) exigem operandos do tipo BOOLEAN.");
        }
        return TipodeDado.BOOLEAN;
    }
    public TabelaSimbolos getEscopoAtual()
    {
        return escopoAtual;
    }
}