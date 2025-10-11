package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Optional<Contato> findbytelefone(String telefone);

    Optional<Contato> findByemail(String email);

    Optional<Contato> findByendereco(String endereco);

    boolean existsBytelefone(String telefone);

    boolean existsByemail(String email);

    boolean existsByendereco(String endereco);
}
