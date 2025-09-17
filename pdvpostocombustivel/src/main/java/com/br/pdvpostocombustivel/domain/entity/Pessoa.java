package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.contraints.past;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

import java.util.Date;

@Entity
@Table (name = "pessoa")
public class Pessoa {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private long id;
@notBlank(name = "nome_completo", nullable = false, length = 200)
    private String nomeCompleto;
    private String cpfCnpj;
    private LocalDate dataNascimento;
    private Long numeroCtps;

    public Pessoa (String nomeCompleto, String cpfCnpj, LocalDate dataNascimento, Long numeroCtps){
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;

    }

    public Pessoa() {

    }

    public String getNomeCompleto(){
        return nomeCompleto;
    }
    public String getCpfCnpj(){
        return cpfCnpj;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public Long getNumeroCtps(){
        return numeroCtps;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setNumeroCtps(Long numeroCtps) {
        this.numeroCtps = numeroCtps;
    }
}
