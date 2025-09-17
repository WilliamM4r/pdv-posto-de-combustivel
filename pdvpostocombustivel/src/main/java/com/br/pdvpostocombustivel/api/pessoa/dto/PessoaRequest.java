package com.br.pdvpostocombustivel.api.pessoa.dto;
import . . .
import org.springframework.format.annotation.DateTimeFormat;

public record PessoaRequest() {
    String nomeCompleto,
    String cpfCnpj,
    Long numeroCtps,
    @dateTimeFormat(iso = DateTimeFormat.ISO.DATE)
}
