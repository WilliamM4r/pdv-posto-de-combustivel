package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findbynome(String nome);

    Optional<Produto> findByreferencia(String referencia);

    Optional<Produto> findByfornecedor(String fornecedor);

    Optional<Produto> findbycategoria(String categoria);

    Optional<Produto> findbymarca(String marca);

    boolean existsBynome(String nome);

    boolean existsByreferencia(String referencia);

    boolean existsByfornecedor(String fornecedor);

    boolean existsBycategoria(String categoria);

    boolean existsBymarca(String marca);
}
