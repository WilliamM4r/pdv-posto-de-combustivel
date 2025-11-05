package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Estoque;

import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    private final List<Estoque> lista = new ArrayList<>();

    public void adicionar(Estoque estoque) {
        lista.add(estoque);
    }

    public void atualizar(int index, Estoque estoque) {
        lista.set(index, estoque);
    }

    public void remover(int index) {
        lista.remove(index);
    }

    public List<Estoque> listar() {
        return lista;
    }
}
