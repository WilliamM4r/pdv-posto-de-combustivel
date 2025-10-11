package com.br.pdvpostocombustivel.util;

import com.br.pdvpostocombustivel.enums.TipoPessoa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.br.pdvpostocombustivel.domain.entity.Pessoa;

import java.time.LocalDate;

@SpringBootApplication
public class PdvpostocombustivelApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PdvpostocombustivelApplication.class, args);
		Pessoa pessoa1 = new Pessoa
				("Vasap","06271056000167",
						123456789L, LocalDate.of(1985, 7, 22), TipoPessoa.FISICA);

		Pessoa pessoa2 = new Pessoa
				("Vasap","06271056000167",
						123456789L, LocalDate.of(1985, 7, 22), TipoPessoa.FISICA);

		Pessoa pessoa3 = new Pessoa
				("jasap","06271056000167",
						123456789L, LocalDate.of(1985, 7, 22), TipoPessoa.FISICA);


		System.out.println("Nome Completo " + pessoa1.getNomeCompleto());
		System.out.println("CPF/CNPJ " + pessoa1.getCpfCnpj());
		System.out.println("Numero CTPS " + pessoa1.getNumeroCtps());
		System.out.println("-----------------------------------------------------");

		System.out.println("Nome Completo " + pessoa2.getNomeCompleto());
		System.out.println("CPF/CNPJ " + pessoa2.getCpfCnpj());
		System.out.println("Numero CTPS " + pessoa2.getNumeroCtps());
		System.out.println("-----------------------------------------------------");

		System.out.println("Nome Completo " + pessoa3.getNomeCompleto());
		System.out.println("CPF/CNPJ " + pessoa3.getCpfCnpj());
		System.out.println("Numero CTPS " + pessoa3.getNumeroCtps());
	}

}