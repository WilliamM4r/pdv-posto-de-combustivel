package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrecoRepository extends JpaRepository<Preco, Long> {
    Optional<Preco> findbyvalor(String datavalor);

    Optional<Preco> findBydataAlteracao(String dataAlteracao);

    Optional<Preco> findBylocalTanque(String localTanque);

    boolean existsBydatavalor(String datavalor);

    boolean existsBydataAlteracao(String dataAlteracao);

    boolean existsByhoraAlteracao(String horaAlteracao);
}
