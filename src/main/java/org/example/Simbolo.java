package org.example;

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
    // Getters
    public String getNome() { return nome; }
    public TipodeDado getTipo() { return tipo; }
    public int getDeslocamento() { return deslocamento; }
}