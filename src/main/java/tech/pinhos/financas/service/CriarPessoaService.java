package tech.pinhos.financas.service;

import org.springframework.stereotype.Service;
import tech.pinhos.financas.dto.PessoaDTO;
import tech.pinhos.financas.dto.PessoaRequestDTO;
import tech.pinhos.financas.mapper.PessoaMapper;
import tech.pinhos.financas.mapper.PessoaRequestMapper;
import tech.pinhos.financas.repository.PessoaRepository;

@Service
public class CriarPessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;
    private final PessoaRequestMapper pessoaRequestMapper;
    private final CriarEnderecoService criarEnderecoService;

    public CriarPessoaService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper, PessoaRequestMapper pessoaRequestMapper, CriarEnderecoService criarEnderecoService) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
        this.pessoaRequestMapper = pessoaRequestMapper;
        this.criarEnderecoService = criarEnderecoService;
    }

    /**
     * Método para criar uma pessoa, usando o mapstruct
     *
     * @param pessoa
     * @return
     */
    public PessoaDTO executar(PessoaRequestDTO pessoa) {
        var entity = pessoaRequestMapper.toEntity(pessoa);
        entity.setEndereco(criarEnderecoService.executar(pessoa.getEndereco()));
        entity = pessoaRepository.save(entity);
        return pessoaMapper.toDto(entity);
    }

}
