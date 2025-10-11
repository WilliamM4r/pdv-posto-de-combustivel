package com.br.pdvpostocombustivel.api.pessoa.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EstoqueResponse(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataValidade, BigDecimal quantidade, String localTanque, String localEndereco, String loteFabricacao) {
}
