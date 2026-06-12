package org.example;

import java.util.HashMap;

public class TabelaSimbolos
{
    private HashMap<String, Simbolo> tabela;
    private TabelaSimbolos escopoPai;

    public TabelaSimbolos(TabelaSimbolos escopoPai)
    {
        this.tabela = new HashMap<>();
        this.escopoPai = escopoPai;
    }

    public void inserir(String nome, TipodeDado tipo, int deslocamento)
    {
        if (tabela.containsKey(nome))
        {
            throw new RuntimeException("Erro Semântico: A variável '" + nome + "' já foi declarada neste escopo.");
        }
        tabela.put(nome, new Simbolo(nome, tipo, deslocamento));
    }

    public Simbolo buscar(String nome)
    {
        if (tabela.containsKey(nome))
        {
            return tabela.get(nome);
        }
        if (escopoPai != null)
        {
            return escopoPai.buscar(nome);
        }
        return null;
    }

    public TabelaSimbolos getEscopoPai()
    {
        return escopoPai;
    }
}