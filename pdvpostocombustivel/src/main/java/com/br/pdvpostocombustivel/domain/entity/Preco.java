package com.br.pdvpostocombustivel.domain.entity;

import javax.xml.crypto.Data;
import java.math.BigDecimal;

public class Preco {
    private BigDecimal valor;
    private Data dataAlteracao;
    private Data horaAlteracao;

    public Preco(BigDecimal valor, Data dataAlteracao, Data horaAlteracao) {
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
    }

    public BigDecimal getValor() {return valor;}
    public Data getDataAlteracao() {return dataAlteracao;}
    public Data getHoraAlteracao() {return horaAlteracao;}

    public void setValor(BigDecimal valor) {this.valor = valor;}
    public void setDataAlteracao(Data dataAlteracao) {this.dataAlteracao = dataAlteracao;}
    public void setHoraAlteracao(Data horaAlteracao) {this.horaAlteracao = horaAlteracao;}
}
