package org.example;

import org.example.enums.TipodeDado;
import java.util.HashMap;

public class TabelaSimbolos
{
    private HashMap<String, Simbolo> mapaVariaveis;
    private TabelaSimbolos nivelAnterior;

    public TabelaSimbolos(TabelaSimbolos nivelAnterior)
    {
        this.mapaVariaveis = new HashMap<>();
        this.nivelAnterior = nivelAnterior;
    }

    public void inserir(String nomeVar, TipodeDado tipoVar, int offsetMemoria)
    {
        if (mapaVariaveis.containsKey(nomeVar))
            throw new RuntimeException("Erro Semântico: A variável '" + nomeVar + "' já foi declarada antes neste bloco.");

        Simbolo novoSimbolo = new Simbolo(nomeVar, tipoVar, offsetMemoria);
        mapaVariaveis.put(nomeVar, novoSimbolo);
    }

    public Simbolo buscar(String nomeVar)
    {
        Simbolo encontrado = mapaVariaveis.get(nomeVar);

        if (encontrado != null)
            return encontrado;

        if (nivelAnterior != null)
            return nivelAnterior.buscar(nomeVar);

        return null;
    }

    public HashMap<String, Simbolo> getTabelaMap()
    {
        return mapaVariaveis;
    }

    public TabelaSimbolos getEscopoPai()
    {
        return nivelAnterior;
    }
}