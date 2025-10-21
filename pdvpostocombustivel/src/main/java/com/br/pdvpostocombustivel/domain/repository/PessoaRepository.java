package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Pessoa;
import com.br.pdvpostocombustivel.enums.TipoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByName(String nome);

    Optional<Pessoa> findByCpfCnpj(String cpfCnpj);

    Optional<Pessoa> findByDataNascimento(LocalDate dataNascimento);

    Optional<Pessoa> findByTipoPessoa(TipoPessoa tipoPessoa);

    boolean existsByCpfCnpj(String cpjCnpj);

    boolean existsByNome(String nome);

    boolean existsByDataNascimento(LocalDate dataNascimento);

    boolean existisByTipoPessoa(TipoPessoa tipoPessoa);
}
