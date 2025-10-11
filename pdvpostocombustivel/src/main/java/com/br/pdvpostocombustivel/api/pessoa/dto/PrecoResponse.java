package com.br.pdvpostocombustivel.api.pessoa.dto;

import javax.xml.crypto.Data;
import java.math.BigDecimal;

public record PrecoResponse(BigDecimal valor, Data dataAlteracao, Data horaAlteracao) {
}
