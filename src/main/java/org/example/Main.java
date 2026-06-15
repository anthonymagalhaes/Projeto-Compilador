package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.example.gen.LanguageLexer;
import org.example.gen.LanguageParser;

public class Main {

    private static final String DIRBASE = "src/test/resources/";
    private static final String EXTENSION = "lang";
    private static final String TARGETBASE = "src/test/responses/";

    public static void main(String[] args) {
        try {
            String files[] = args.length==0? new String[]{ "teste1." + EXTENSION } : args;
            CharStream in = CharStreams.fromFileName(DIRBASE + files[0]);

            LanguageLexer lexer = new LanguageLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            tokens.fill();
            for (Token token : tokens.getTokens()) {
                if (token.getType() == Token.EOF) continue;
                String atributo = switch (token.getText().toLowerCase()) {
                    case "+" -> "MAIS";
                    case "-" -> "MENOS";
                    case "*" -> "VEZES";
                    case "/" -> "DIV";
                    case "or" -> "OR";
                    case "and" -> "AND";
                    case "~" -> "NEG";
                    case "<" -> "MENOR";
                    case "<=" -> "MENIG";
                    case ">" -> "MAIOR";
                    case ">=" -> "MAIG";
                    case "==" -> "IGUAL";
                    case "<>" -> "DIFER";
                    default -> token.getText();

                };

                System.out.printf("Token: %-16s | Atributo: %-16s | Tipo: %s\n",
                        token.getText(), atributo, LanguageLexer.VOCABULARY.getSymbolicName(token.getType()));

            }

            LanguageParser parser = new LanguageParser(tokens);

            LanguageParser.ProgContext arvore = parser.prog();
            if (parser.getNumberOfSyntaxErrors() > 0) {
                throw new RuntimeException("Compilação abortada: Foram encontrados erros léxicos ou sintáticos.");
            }
            LanguageCustomVisitor visitor = new LanguageCustomVisitor();

            visitor.visit(arvore);

            GeradorCodigo gerador = new GeradorCodigo();
            gerador.visit(arvore);
            gerador.mostrarCodigo();

            Otimizador otimizador = new Otimizador();
            List<String> codigoOtimizado = otimizador.otimizar(gerador.getCodigo());
            otimizador.mostrarOtimizado(codigoOtimizado);

            GeradorAssembly geradorAsm = new GeradorAssembly();
            geradorAsm.gerar(codigoOtimizado, visitor.getEscopoAtual().getTabelaMap());
            geradorAsm.mostrarAssembly();

            String nomeArquivoSaida = TARGETBASE + files[0].replace("." + EXTENSION, ".asm");
            java.io.File diretorioSaida = new java.io.File(TARGETBASE);
            if (!diretorioSaida.exists()) {
                diretorioSaida.mkdirs();
            }

            Files.write(Paths.get(nomeArquivoSaida), geradorAsm.getAssembly());
            System.out.println("-> Arquivo assembly gerado com sucesso em: " + nomeArquivoSaida);

        } catch (RuntimeException | IOException e) {
            System.err.println(e.getMessage());

        }
    }
}