package org.example;

import org.example.enums.TipodeDado;

public class Simbolo
{
    private String nome;
    private TipodeDado tipo;
    private int deslocamento;

    public Simbolo(String nome, TipodeDado tipo, int deslocamento)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.deslocamento = deslocamento;
    }
    public String getNome() { return nome; }
    public TipodeDado getTipo() { return tipo; }
    public int getDeslocamento() { return deslocamento; }
}