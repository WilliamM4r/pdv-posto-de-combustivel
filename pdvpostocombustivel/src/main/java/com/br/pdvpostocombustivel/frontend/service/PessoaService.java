package com.br.pdvfrontend.service;

import com.br.pdvfrontend.model.Pessoa;
import com.br.pdvfrontend.util.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// Bibliotecas de JSON (como Gson ou Jackson) seriam necessárias
// para converter String JSON em objeto Pessoa e vice-versa.

public class PessoaService {
    private HttpClient httpClient;
    private final String ENDPOINT = "/"; // Baseado no BASE_URL do HttpClient

    public PessoaService() {
        this.httpClient = new HttpClient();
    }

    /**
     * Faz a requisição HTTP GET para buscar a lista de pessoas.
     */
    public List<Pessoa> buscarTodas() {
        try {
            String jsonResponse = httpClient.sendGetRequest(ENDPOINT);

            // Lógica de conversão do JSON (jsonResponse) para List<Pessoa>
            System.out.println("DEBUG: Resposta do Servidor: " + jsonResponse);

            // Retorna um mock temporário
            return List.of(new Pessoa(1L, "João", "joao@a.com"),
                    new Pessoa(2L, "Maria", "maria@b.com"));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Lógica de tratamento de erro para a VIEW
            return new ArrayList<>();
        }
    }

    // Métodos para salvar(POST), atualizar(PUT) e deletar(DELETE) seriam adicionados aqui
    // Ex: public Pessoa salvar(Pessoa pessoa) {...}
}