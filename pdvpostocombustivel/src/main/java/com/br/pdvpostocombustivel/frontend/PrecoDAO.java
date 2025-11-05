package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Preco;

import java.util.ArrayList;
import java.util.List;

public class PrecoDAO {
    private final List<Preco> listaPrecos = new ArrayList<>();

    public void adicionar(Preco preco) {
        listaPrecos.add(preco);
    }

    public void atualizar(int index, Preco precoAtualizado) {
        listaPrecos.set(index, precoAtualizado);
    }

    public void remover(int index) {
        listaPrecos.remove(index);
    }

    public List<Preco> listar() {
        return listaPrecos;
    }
}
