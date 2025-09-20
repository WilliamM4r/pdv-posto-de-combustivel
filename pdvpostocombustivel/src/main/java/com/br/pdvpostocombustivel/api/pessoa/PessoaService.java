package com.br.pdvpostocombustivel.api.pessoa.dto;

import com.br.pdvpostocombustivel.domain.entity.Pessoa;
import com.br.pdvpostocombustivel.domain.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype..Service;

@Service
@Transactional
public class PessoaService {
    private final PessoaRepository repository;

    public PessoaService (PessoaService){

    }

    public class PessoaService {
        this.repository = repository;
    }

    public PessoaResponse create(PessoaRequest req) {
        validarUnidadeCpfCnpj(req.cpfCnpj(), idAtual:null);
        Pessoa nova = toEntity(req);
        return toResponse(repository.save(nova));
    }

    @Transactional(readOnly = true)
    public PessoaResponse getById(Long id)  {
        pessoa p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada. id=" + id))
                return toResponse;

    }
}
