package org.example;

import org.example.enums.TipodeDado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeradorAssembly
{
    private List<String> assembly = new ArrayList<>();
    private Map<String, String> mapaStrings = new HashMap<>();
    private int contadorStrings = 0;

    public List<String> gerar(List<String> codigo3AC, Map<String, Simbolo> tabelaGlobais)
    {
        for (String linha : codigo3AC) {
            if (linha.startsWith("WRITE ") && linha.substring(6).trim().startsWith("\"")) {
                String texto = linha.substring(6).trim();
                if (!mapaStrings.containsKey(texto)) {
                    mapaStrings.put(texto, "msg_" + (contadorStrings++));
                }
            }
        }
        assembly.add(".model small");
        assembly.add(".stack 100h");
        assembly.add("");
        assembly.add(".data");

        for (Simbolo s : tabelaGlobais.values())
        {
            if (s.getTipo() == TipodeDado.BOOLEAN)
            {
                assembly.add("    " + s.getNome() + " db 0 ");
            }
            else
            {
                assembly.add("    " + s.getNome() + " dw 0 ");
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
                    assembly.add("    " + destino + " dw 0 ");
                    temporariasCriadas.add(destino);
                }
            }
        }

        if (!mapaStrings.isEmpty()) {
            for (Map.Entry<String, String> entry : mapaStrings.entrySet()) {
                String textoOriginal = entry.getKey();
                String label = entry.getValue();
                String textoFormatado = textoOriginal.substring(0, textoOriginal.length() - 1) + "$\"";
                assembly.add("    " + label + " db " + textoFormatado);
            }
        }

        assembly.add("");
        assembly.add(".code");
        assembly.add("main:");
        assembly.add("    mov ax, @data ");
        assembly.add("    mov ds, ax");
        assembly.add("");

        for (String linha : codigo3AC)
        {
            traduzir(linha);
        }

        assembly.add("    mov ah, 4Ch");
        assembly.add("    int 21h");
        assembly.add("");
        injetarFuncoesIOnativas();
        assembly.add("end main");
        return assembly;
    }

    private void traduzir(String linha)
    {
        linha = linha.trim();
        if (linha.endsWith(":"))
        {
            assembly.add(linha);
            return;
        }
        if (linha.startsWith("GOTO "))
        {
            String label = linha.substring(5).trim();
            assembly.add("    jmp " + label);
            return;
        }

        if (linha.startsWith("IF "))
        {
            String[] partes = linha.split(" ");
            String condicaoTemp = partes[1];
            String label = partes[5];

            assembly.add("    mov ax, word ptr [" + condicaoTemp + "]");
            assembly.add("    cmp ax, 0");
            assembly.add("    je " + label);
            return;
        }

        if (linha.startsWith("READ "))
        {
            String var = linha.substring(5).trim();
            assembly.add("    call _read_integer");
            assembly.add("    mov word ptr [" + var + "], ax");
            return;
        }

        if (linha.startsWith("WRITE ")) {
            String argumento = linha.substring(6).trim();

            if (argumento.startsWith("\"")) {
                String label = mapaStrings.get(argumento);
                assembly.add("    lea dx, " + label);
                assembly.add("    mov ah, 09h");
                assembly.add("    int 21h");
            } else { // É um NÚMERO ou VARIÁVEL (x, y)
                assembly.add("    mov ax, word ptr [" + argumento + "]");
                assembly.add("    call _print_integer");
            }
            return;
        }

        if (linha.contains("="))
        {
            String[] partes = linha.split("=");
            String destino = partes[0].trim();
            String expressao = partes[1].trim();
            String[] tokensExp = expressao.split(" ");

            if (tokensExp.length == 1)
            {
                if (tokensExp[0].matches("-?\\d+")) {
                    assembly.add("    mov word ptr [" + destino + "], " + tokensExp[0]);
                } else {
                    assembly.add("    mov ax, word ptr [" + tokensExp[0] + "]");
                    assembly.add("    mov word ptr [" + destino + "], ax");
                }
            }else if (tokensExp.length == 3 && tokensExp[1].equals("<<")) {
                assembly.add("    mov ax, word ptr [" + tokensExp[0] + "]");
                assembly.add("    shl ax, " + tokensExp[2]);
                assembly.add("    mov word ptr [" + destino + "], ax");
            }
            else if (tokensExp.length == 3)
            {
                String opEsq = tokensExp[0];
                String operador = tokensExp[1];
                String opDir = tokensExp[2];

                assembly.add("    mov ax, word ptr [" + opEsq + "]");

                switch (operador) {
                    case "+":
                        assembly.add("    add ax, word ptr [" + opDir + "]");
                        break;
                    case "-":
                        assembly.add("    sub ax, word ptr [" + opDir + "]");
                        break;
                    case "*":
                        assembly.add("    imul word ptr [" + opDir + "]");
                        break;
                }

                assembly.add("    mov word ptr [" + destino + "], ax");
            }
        }
    }
    private void injetarFuncoesIOnativas()
    {
        assembly.add("_print_integer PROC");
        assembly.add("    push ax");
        assembly.add("    push bx");
        assembly.add("    push cx");
        assembly.add("    push dx");
        assembly.add("    mov cx, 0");
        assembly.add("    cmp ax, 0");
        assembly.add("    jge print_loop_1");
        assembly.add("    push ax");
        assembly.add("    mov ah, 02h");
        assembly.add("    mov dl, '-'");
        assembly.add("    int 21h");
        assembly.add("    pop ax");
        assembly.add("    neg ax");
        assembly.add("print_loop_1:");
        assembly.add("    mov dx, 0");
        assembly.add("    mov bx, 10");
        assembly.add("    div bx");
        assembly.add("    push dx");
        assembly.add("    inc cx");
        assembly.add("    cmp ax, 0");
        assembly.add("    jne print_loop_1");
        assembly.add("print_loop_2:");
        assembly.add("    pop dx");
        assembly.add("    add dl, 48");
        assembly.add("    mov ah, 02h");
        assembly.add("    int 21h");
        assembly.add("    loop print_loop_2");
        assembly.add("    pop dx");
        assembly.add("    pop cx");
        assembly.add("    pop bx");
        assembly.add("    pop ax");
        assembly.add("    ret");
        assembly.add("_print_integer ENDP");
        assembly.add("");
        assembly.add("_read_integer PROC");
        assembly.add("    push bx");
        assembly.add("    push cx");
        assembly.add("    push dx");
        assembly.add("    mov bx, 0");
        assembly.add("    mov cx, 1");
        assembly.add("read_loop:");
        assembly.add("    mov ah, 01h");
        assembly.add("    int 21h");
        assembly.add("    cmp al, 13 ");
        assembly.add("    je read_end");
        assembly.add("    cmp al, '-'");
        assembly.add("    jne read_digit");
        assembly.add("    mov cx, -1 ");
        assembly.add("    jmp read_loop");
        assembly.add("read_digit:");
        assembly.add("    sub al, 48 ");
        assembly.add("    mov ah, 0");
        assembly.add("    push ax");
        assembly.add("    mov ax, 10");
        assembly.add("    mul bx");
        assembly.add("    mov bx, ax");
        assembly.add("    pop ax");
        assembly.add("    add bx, ax");
        assembly.add("    jmp read_loop");
        assembly.add("read_end:");
        assembly.add("    mov ax, bx");
        assembly.add("    imul cx");
        assembly.add("    pop dx");
        assembly.add("    pop cx");
        assembly.add("    pop bx");
        assembly.add("    ret");
        assembly.add("_read_integer ENDP");
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