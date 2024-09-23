package tech.pinhos.financas.service;

import org.springframework.stereotype.Service;
import tech.pinhos.financas.model.Pessoa;
import tech.pinhos.financas.repository.PessoaRepository;

@Service
public class CriarPessoaService {

    private final PessoaRepository pessoaRepository;

    public CriarPessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa executar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
