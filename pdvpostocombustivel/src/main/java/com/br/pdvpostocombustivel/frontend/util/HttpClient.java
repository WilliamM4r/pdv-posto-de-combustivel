package com.br.pdvfrontend.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {
    private static final java.net.http.HttpClient client = java.net.http.HttpClient.newBuilder().build();
    private static final String BASE_URL = "http://localhost:8080/api/pessoas";

    public String sendGetRequest(String path) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}