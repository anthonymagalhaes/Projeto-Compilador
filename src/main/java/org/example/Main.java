package org.example;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.example.gen.LanguageLexer;
import org.example.gen.LanguageParser;

public class Main {

    private static final String DIRBASE = "src/test/resources/";
    private static final String EXTENSION = "lang";

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
            parser.prog();

        } catch (RuntimeException | IOException e) {
            System.err.println(e.getMessage());

        }
    }
}