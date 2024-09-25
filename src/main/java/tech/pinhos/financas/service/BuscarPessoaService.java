package tech.pinhos.financas.service;

import org.springframework.stereotype.Service;
import tech.pinhos.financas.dto.PessoaDTO;
import tech.pinhos.financas.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarPessoaService {

    private final PessoaRepository pessoaRepository;

    public BuscarPessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Optional<PessoaDTO> buscarPessoaPorCpf(String cpf) {
        return pessoaRepository.findPessoaByCpf(cpf).map(PessoaDTO::fromEntity);
    }

    public List<PessoaDTO> buscarTodas() {
        return pessoaRepository
                .findAll()
                .stream()
                .map(PessoaDTO::fromEntity)
                .toList();
    }
}
