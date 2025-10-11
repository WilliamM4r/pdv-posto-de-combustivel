package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {
    Optional<Acesso> findByUsuario(String Usuario);

    Optional<Acesso> findBySenha(String Senha);

    boolean existsByUsuario(String Usuario);

    boolean existsBySenha(String Senha);
}
