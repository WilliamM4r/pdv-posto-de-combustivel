package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Contato;
import com.br.pdvpostocombustivel.domain.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    private final List<Contato> contatos = new ArrayList<>();
    private final List<Pessoa> pessoas = new ArrayList<>();

    public ContatoDAO() {
        // Pessoas cadastradas previamente
        pessoas.add(new Pessoa("William Marques"));
        pessoas.add(new Pessoa("Ana Souza"));
        pessoas.add(new Pessoa("Carlos Lima"));
    }

    public void adicionar(Contato contato) {
        contatos.add(contato);
    }

    public void atualizar(int index, Contato contato) {
        contatos.set(index, contato);
    }

    public void remover(int index) {
        contatos.remove(index);
    }

    public List<Contato> listar() {
        return contatos;
    }

    public List<Pessoa> listarPessoas() {
        return pessoas;
    }
}
