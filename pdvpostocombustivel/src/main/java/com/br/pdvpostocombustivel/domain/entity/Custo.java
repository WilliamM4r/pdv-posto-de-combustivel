package com.br.pdvpostocombustivel.domain.entity;

public class Custo {
    private double imposto;
    private double custoVariavel;
    private double custoFisico;

    public Custo(Double imposto, Double custoVariavel, Double custoFisico) {
        this.imposto = imposto;
        this.custoVariavel = custoVariavel;
        this.custoFisico = custoFisico;
    }

    public double getImposto(){
        return imposto;
    }
    public double getCustoVariavel(){
        return custoVariavel;
    }
    public double getCustoFisico(){
        return custoFisico;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }
    public void setCustoVariavel(Double custoVariavel) {
        this.custoVariavel = custoVariavel;
    }
    public void setCustoFisico(Double custoFisico) {
        this.custoFisico = custoFisico;
    }
}
