package tech.pinhos.financas.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.pinhos.financas.dto.PessoaDTO;
import tech.pinhos.financas.mapper.PessoaMapper;
import tech.pinhos.financas.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarPessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public BuscarPessoaService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    public Optional<PessoaDTO> buscarPessoaPorCpf(String cpf) {
        return pessoaRepository.findPessoaByCpf(cpf).map(pessoaMapper::toDto);
    }

    public List<PessoaDTO> buscarTodas() {
        return pessoaRepository
                .findAll()
                .stream()
                .map(pessoaMapper::toDto)
                .toList();
    }

    public Page<PessoaDTO> buscarPaginada(Pageable pageable) {
        return pessoaRepository
                .findAll(pageable)
                .map(pessoaMapper::toDto);
    }

    public List<PessoaDTO> buscarPessoasPorUf(String cidade) {
        return pessoaRepository
//                .findByUf(cidade)
                .findByUfNativa(cidade)
                .stream()
                .map(pessoaMapper::toDto)
                .toList();
    }
}
