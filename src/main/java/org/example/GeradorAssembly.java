package org.example;

import org.example.enums.TipodeDado;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeradorAssembly
{
    private List<String> assembly = new ArrayList<>();

    public List<String> gerar(List<String> codigo3AC, Map<String, Simbolo> tabelaGlobais)
    {
        assembly.add(".data");
        for (Simbolo s : tabelaGlobais.values())
        {
            if (s.getTipo() == TipodeDado.BOOLEAN)
            {
                assembly.add("    " + s.getNome() + " db 0  ; BOOLEAN (1 byte)");
            }
            else
            {
                assembly.add("    " + s.getNome() + " dw 0  ; INTEGER (2 bytes)");
            }
        }

        List<String> temporariasCriadas = new ArrayList<>();
        for (String linha : codigo3AC)
        {
            if (linha.contains("=") && !linha.startsWith("IF"))
            {
                String destino = linha.split("=")[0].trim();
                if (destino.startsWith("t") && !temporariasCriadas.contains(destino))
                {
                    assembly.add("    " + destino + " dw 0  ; TEMPORÁRIA");
                    temporariasCriadas.add(destino);
                }
            }
        }

        assembly.add("");
        assembly.add(".text");
        assembly.add("main:");

        for (String linha : codigo3AC)
        {
            assembly.add("    ; " + linha);
            traduzir(linha);
        }

        assembly.add("    mov ah, 4Ch");
        assembly.add("    int 21h");

        return assembly;
    }

    private void traduzir(String linha)
    {
        if (linha.matches("[a-zA-Z0-9_]+\\s*=\\s*-?\\d+"))
        {
            String[] partes = linha.split("=");
            assembly.add("    mov word ptr [" + partes[0].trim() + "], " + partes[1].trim());
        }
        else if (linha.matches("[a-zA-Z0-9_]+\\s*=\\s*[a-zA-Z0-9_]+"))
        {
            String[] partes = linha.split("=");
            assembly.add("    mov ax, word ptr [" + partes[1].trim() + "]");
            assembly.add("    mov word ptr [" + partes[0].trim() + "], ax");
        }
        else if (linha.contains("<<"))
        {
            String destino = linha.split("=")[0].trim();
            String expressao = linha.split("=")[1].trim();
            String origem = expressao.split("<<")[0].trim();
            String bits = expressao.split("<<")[1].trim();

            assembly.add("    mov ax, word ptr [" + origem + "]");
            assembly.add("    shl ax, " + bits);
            assembly.add("    mov word ptr [" + destino + "], ax");
        }
        else if (linha.startsWith("READ"))
        {
            String var = linha.split(" ")[1].trim();
            assembly.add("    call _read_integer");
            assembly.add("    mov word ptr [" + var + "], ax");
        }
        else if (linha.startsWith("WRITE"))
        {
            String var = linha.split(" ")[1].trim();
            assembly.add("    push word ptr [" + var + "]");
            assembly.add("    call _print_integer");
        }
    }

    public void mostrarAssembly()
    {
        System.out.println("-- Código Assembly --");
        for (String linha : assembly)
        {
            System.out.println(linha);
        }
        System.out.println("----------------");
    }
}