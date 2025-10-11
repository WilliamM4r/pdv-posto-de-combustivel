package com.br.pdvpostocombustivel.domain.entity;

import java.time.LocalDate;

public class Custo {
    private double imposto;
    private double custoVariavel;
    private double custoFixo;
    private double margemLucro;
    private LocalDate dataProcessamento;

    public Custo(Double imposto, Double custoVariavel, Double custoFisico, Double margemLucro, LocalDate dataProcessamento) {
        this.imposto = imposto;
        this.custoVariavel = custoVariavel;
        this.custoFixo = custoFisico;
        this.margemLucro = margemLucro;
        this.dataProcessamento = dataProcessamento;
    }

    public double getImposto(){
        return imposto;
    }
    public double getCustoVariavel(){
        return custoVariavel;
    }
    public double getCustoFisico(){ return custoFixo;}
    public double getMargemLucro(){
        return margemLucro;
    }
    public LocalDate getDataProcessamento(){return dataProcessamento;}

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }
    public void setCustoVariavel(Double custoVariavel) {
        this.custoVariavel = custoVariavel;
    }
    public void setCustoFixo(Double custoFixo) {
        this.custoFixo = custoFixo;
    }
    public void setMargemLucro(Double margemLucro) {
        this.margemLucro = margemLucro;
    }
    public void setDataProcessamento(LocalDate dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }
}
