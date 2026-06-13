package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Otimizador
{
    public List<String> otimizar(List<String> codigoOriginal)
    {
        List<String> codigoOtimizado = new ArrayList<>();
        Map<String, String> constantes = new HashMap<>();

        for (String linha : codigoOriginal)
        {
            if (linha.contains("GOTO") || linha.contains(":") || linha.startsWith("IF") || linha.startsWith("READ") || linha.startsWith("WRITE"))
            {
                codigoOtimizado.add(linha);
                continue;
            }

            String[] partes = linha.split("=");
            if (partes.length == 2)
            {
                String destino = partes[0].trim();
                String expressao = partes[1].trim();

                for (Map.Entry<String, String> entry : constantes.entrySet())
                {
                    expressao = expressao.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }

                String[] tokens = expressao.split(" ");

                if (tokens.length == 3)
                {
                    try
                    {
                        int opEsq = Integer.parseInt(tokens[0]);
                        int opDir = Integer.parseInt(tokens[2]);
                        String operador = tokens[1];
                        int resultado = 0;

                        switch (operador)
                        {
                            case "+": resultado = opEsq + opDir; break;
                            case "-": resultado = opEsq - opDir; break;
                            case "*": resultado = opEsq * opDir; break;
                            case "/": resultado = opEsq / opDir; break;
                        }
                        expressao = String.valueOf(resultado);
                    }
                    catch (NumberFormatException e)
                    {
                        if (tokens[1].equals("*"))
                        {
                            if (tokens[2].equals("4")) expressao = tokens[0] + " << 2";
                            else if (tokens[0].equals("4")) expressao = tokens[2] + " << 2";
                            else if (tokens[2].equals("2")) expressao = tokens[0] + " << 1";
                            else if (tokens[0].equals("2")) expressao = tokens[2] + " << 1";
                        }
                    }
                }

                if (expressao.matches("-?\\d+"))
                {
                    constantes.put(destino, expressao);
                }

                codigoOtimizado.add(destino + " = " + expressao);
            }
            else
            {
                codigoOtimizado.add(linha);
            }
        }
        return removerCodigoDesnecessario(codigoOtimizado);
    }

    private List<String> removerCodigoDesnecessario(List<String> codigo)
    {
        Set<String> variaveisLidas = new HashSet<>();
        for (String linha : codigo)
        {
            if (linha.startsWith("IF"))
            {
                variaveisLidas.add(linha.split(" ")[1]);
            }
            else if (linha.startsWith("WRITE"))
            {
                variaveisLidas.add(linha.split(" ")[1]);
            }
            else if (linha.contains("=") && !linha.startsWith("IF"))
            {
                String expressao = linha.split("=")[1].trim();
                String[] tokens = expressao.split(" ");
                for (String token : tokens)
                {
                    if (token.matches("[a-zA-Z][a-zA-Z0-9]*") && !token.equals("READ"))
                    {
                        variaveisLidas.add(token);
                    }
                }
            }
        }

        List<String> codigoLimpo = new ArrayList<>();
        for (String linha : codigo)
        {
            if (linha.contains("=") && !linha.startsWith("IF"))
            {
                String destino = linha.split("=")[0].trim();
                if (destino.matches("t\\d+") && !variaveisLidas.contains(destino))
                {
                    continue;
                }
            }
            codigoLimpo.add(linha);
        }

        return codigoLimpo;
    }

    public void mostrarOtimizado(List<String> codigoOtimizado)
    {
        System.out.println("-- Código Otimizado --");
        for (String linha : codigoOtimizado)
        {
            System.out.println(linha);
        }
        System.out.println("----------------");
    }
}