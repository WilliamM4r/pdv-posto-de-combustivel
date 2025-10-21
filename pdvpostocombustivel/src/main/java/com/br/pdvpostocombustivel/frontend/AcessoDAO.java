package com.br.pdvpostocombustivel.frontend;

import com.br.pdvpostocombustivel.domain.entity.Acesso;

import java.util.ArrayList;
import java.util.List;

public class AcessoDAO {
    private final List<Acesso> acessos = new ArrayList<>();

    public void adicionar(Acesso p) {
        acessos.add(p);
    }

    public void atualizar(int index, Acesso p) {
        acessos.set(index, p);
    }

    public void remover(int index) {
        acessos.remove(index);
    }

    public List<Acesso> listar() {
        return acessos;
    }

    // Validação de login
    public boolean validarLogin(String usuario, String senha) {
        for (Acesso p : acessos) {
            if (p.getUsuario().equals(usuario) && p.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}