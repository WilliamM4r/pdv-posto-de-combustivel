package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findbydataValidade(String dataValidade);

    Optional<Estoque> findByquantidade(String quantidade);

    Optional<Estoque> findBylocalTanque(String localTanque);

    Optional<Estoque> findbylocalEndereco(String localEndereco);

    Optional<Estoque> findbyloteFabricacao(String loteFabricacao);

    boolean existsBydataValidade(String dataValidade);

    boolean existsByquantidade(String quantidade);

    boolean existsBylocalTanque(String localTanque);

    boolean existsBylocalEndereco(String localEndereco);

    boolean existsByloteFabricacao(String loteFabricacao);
}
