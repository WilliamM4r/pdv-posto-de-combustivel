package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Custo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustoRepository extends JpaRepository<Custo, Long> {
    Optional<Custo> findbyimposto(String imposto);

    Optional<Custo> findBycustoVariavel(String custoVariavel);

    Optional<Custo> findBycustoFixo(String custoFixo);

    Optional<Custo> findBymargemLucro(String margemLucro);

    Optional<Custo> findBydataProcessamento(String dataProcessamento);

    boolean existsByimposto(String imposto);

    boolean existsBycustoVariavel(String custoVariavel);

    boolean existsBycustoFixo(String custoFixo);

    boolean existsBymargemLucro(String margemLucro);

    boolean existsBydataProcessamento(String dataProcessamento);
}
