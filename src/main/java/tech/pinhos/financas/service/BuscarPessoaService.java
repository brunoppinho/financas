package tech.pinhos.financas.service;

import org.springframework.stereotype.Service;
import tech.pinhos.financas.model.Pessoa;
import tech.pinhos.financas.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarPessoaService {

    private final PessoaRepository pessoaRepository;

    public BuscarPessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Optional<Pessoa> buscarPessoaPorCpf(String cpf) {
        return pessoaRepository.findPessoaByCpf(cpf);
    }

    public List<Pessoa> buscarTodas() {
        return pessoaRepository.findAll();
    }
}
