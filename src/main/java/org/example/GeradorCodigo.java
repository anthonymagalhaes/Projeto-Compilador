package org.example;

import org.example.gen.LanguageBaseVisitor;
import org.example.gen.LanguageParser;
import java.util.ArrayList;
import java.util.List;

public class GeradorCodigo extends LanguageBaseVisitor<String>
{

    private List<String> codigo = new ArrayList<>();

    private int tempCounter = 0;
    private int labelCounter = 0;

    private String gerarTemp()
    {
        return "t" + (tempCounter++);
    }

    private String gerarLabel(String prefixo)
    {
        return prefixo + "_" + (labelCounter++);
    }

    private void adicionarInstrucao(String instrucao)
    {
        codigo.add(instrucao);
    }

    public List<String> getCodigo()
    {
        return codigo;
    }

    public void mostrarCodigo()
    {
        System.out.println("-- Código Intermediário Gerado ---");
        for (String linha : codigo)
        {
            System.out.println(linha);
        }
        System.out.println("----------------");
    }

    @Override
    public String visitCmdIf(LanguageParser.CmdIfContext ctx)
    {
        String labelElse = gerarLabel("L_ELSE");
        String labelEnd = gerarLabel("L_END");
        String condicaoTemp = visit(ctx.expr());

        adicionarInstrucao("IF " + condicaoTemp + " == 0 GOTO " + labelElse);

        visit(ctx.cmd(0));
        adicionarInstrucao("GOTO " + labelEnd);

        adicionarInstrucao(labelElse + ":");
        if (ctx.cmd().size() > 1)
        {
            visit(ctx.cmd(1));
        }

        adicionarInstrucao(labelEnd + ":");

        return null;
    }

    @Override
    public String visitCmdWhile(LanguageParser.CmdWhileContext ctx)
    {
        String labelStart = gerarLabel("L_WHILE_START");
        String labelEnd = gerarLabel("L_WHILE_END");

        adicionarInstrucao(labelStart + ":");

        String condicaoTemp = visit(ctx.expr());

        adicionarInstrucao("IF " + condicaoTemp + " == 0 GOTO " + labelEnd);

        visit(ctx.cmd());

        adicionarInstrucao("GOTO " + labelStart);
        adicionarInstrucao(labelEnd + ":");

        return null;
    }

    @Override
    public String visitCmdAtrib(LanguageParser.CmdAtribContext ctx)
    {
        String nomeVar = ctx.IDENTIFIER().getText();
        String resultadoExpr = visit(ctx.expr());
        adicionarInstrucao(nomeVar + " = " + resultadoExpr);
        return null;
    }

    @Override
    public String visitCmdRead(LanguageParser.CmdReadContext ctx)
    {
        LanguageParser.ListIdContext lista = ctx.listId();
        while (lista != null)
        {
            String nomeVar = lista.IDENTIFIER().getText();
            adicionarInstrucao("READ " + nomeVar);
            lista = lista.listId();
        }
        return null;
    }

    @Override
    public String visitElemW(LanguageParser.ElemWContext ctx)
    {
        if (ctx.CADEIA() != null)
        {
            adicionarInstrucao("WRITE " + ctx.CADEIA().getText());
        }
        else
        {
            String temp = visit(ctx.expr());
            adicionarInstrucao("WRITE " + temp);
        }
        return null;
    }

    @Override
    public String visitTermo(LanguageParser.TermoContext ctx)
    {
        if (ctx.CTE() != null)
        {
            return ctx.CTE().getText();
        }
        else if (ctx.IDENTIFIER() != null)
        {
            return ctx.IDENTIFIER().getText();
        }
        else if (ctx.TRUE() != null)
        {
            return "1";
        }
        else if (ctx.FALSE() != null)
        {
            return "0";
        }
        else if (ctx.ABPAR() != null)
        {
            return visit(ctx.expr());
        }
        else if (ctx.OPNEG() != null)
        {
            String tempInterno = visit(ctx.termo());
            String tempNovo = gerarTemp();
            adicionarInstrucao(tempNovo + " = ~" + tempInterno);
            return tempNovo;
        }
        else if (ctx.OPAD() != null)
        {
            String tempInterno = visit(ctx.termo());
            String sinal = ctx.OPAD().getText();
            String tempNovo = gerarTemp();
            adicionarInstrucao(tempNovo + " = " + sinal + tempInterno);
            return tempNovo;
        }
        return null;
    }

    @Override
    public String visitExprMult(LanguageParser.ExprMultContext ctx)
    {
        if (ctx.OPMULT() == null) return visit(ctx.termo());

        String opEsq = visit(ctx.exprMult());
        String opDir = visit(ctx.termo());
        String operador = ctx.OPMULT().getText();

        String temp = gerarTemp();
        adicionarInstrucao(temp + " = " + opEsq + " " + operador + " " + opDir);
        return temp;
    }

    @Override
    public String visitExprSimple(LanguageParser.ExprSimpleContext ctx)
    {
        if (ctx.OPAD() == null) return visit(ctx.exprMult());

        String opEsq = visit(ctx.exprSimple());
        String opDir = visit(ctx.exprMult());
        String operador = ctx.OPAD().getText();

        String temp = gerarTemp();
        adicionarInstrucao(temp + " = " + opEsq + " " + operador + " " + opDir);
        return temp;
    }

    @Override
    public String visitExprRel(LanguageParser.ExprRelContext ctx)
    {
        if (ctx.OPREL() == null) return visit(ctx.exprSimple());

        String opEsq = visit(ctx.exprRel());
        String opDir = visit(ctx.exprSimple());
        String operador = ctx.OPREL().getText();

        String temp = gerarTemp();
        adicionarInstrucao(temp + " = " + opEsq + " " + operador + " " + opDir);
        return temp;
    }

    @Override
    public String visitExpr(LanguageParser.ExprContext ctx)
    {
        if (ctx.OPLOG() == null) return visit(ctx.exprRel());

        String opEsq = visit(ctx.expr());
        String opDir = visit(ctx.exprRel());
        String operador = ctx.OPLOG().getText();

        String temp = gerarTemp();
        adicionarInstrucao(temp + " = " + opEsq + " " + operador + " " + opDir);
        return temp;
    }
}