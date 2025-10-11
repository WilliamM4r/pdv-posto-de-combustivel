package com.br.pdvpostocombustivel.api.pessoa.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record CustoRequest(Double imposto, Double custoVariavel, Double custoFisico, Double margemLucro, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
LocalDate dataProcessamento) {
}
