package com.br.pdvpostocombustivel.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Estoque {

    private LocalDate dataValidade;
    private BigDecimal quantidade;
    private String localTanque;
    private String localEndereco;
    private String loteFabricacao;

    public Estoque(LocalDate dataValidade, BigDecimal quantidade, String localTanque, String localEndereco, String loteFabricacao) {
        this.dataValidade = dataValidade;
        this.quantidade = quantidade;
        this.localTanque = localTanque;
        this.localEndereco = localEndereco;
        this.loteFabricacao = loteFabricacao;
    }

    public LocalDate getDataValidade() {return dataValidade;}
    public BigDecimal getQuantidade() {return  quantidade;}
    public String getLocalTanque() {return localTanque;}
    public String getLocalEndereco() {return  localEndereco;}
    public String getLoteFabricacao() {return  loteFabricacao;}

    public void setDataValidade(LocalDate dataValidade) {this.dataValidade = dataValidade;}
    public void setQuantidade(BigDecimal quantidade) {this.quantidade = quantidade;}
    public void setLocalTanque(String localTanque) {this.localTanque = localTanque;}
    public void setLocalEndereco(String localEndereco) {this.localEndereco = localEndereco;}
    public void setDataValidade(String loteFabricacao) {this.loteFabricacao = loteFabricacao;}
}
