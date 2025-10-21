package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private final List<Pessoa> pessoas = new ArrayList<>();

    public void adicionar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void atualizar(int index, Pessoa pessoa) {
        pessoas.set(index, pessoa);
    }

    public void remover(int index) {
        pessoas.remove(index);
    }

    public List<Pessoa> listar() {
        return pessoas;
    }
}