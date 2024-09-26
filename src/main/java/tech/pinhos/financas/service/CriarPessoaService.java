package tech.pinhos.financas.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import tech.pinhos.financas.dto.PessoaDTO;
import tech.pinhos.financas.mapper.PessoaMapper;
import tech.pinhos.financas.mapper.PessoaModelMapper;
import tech.pinhos.financas.repository.PessoaRepository;

@Service
public class CriarPessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public CriarPessoaService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    /**
     * Método para criar uma pessoa, usando o mapstruct
     *
     * @param pessoa
     * @return
     */
    public PessoaDTO executar(PessoaDTO pessoa) {
        var entity = pessoaMapper.toEntity(pessoa);
        entity = pessoaRepository.save(entity);
        return pessoaMapper.toDto(entity);
    }

    /**
     * Método para criar uma pessoa, usando o Model Mapper
     *
     * @param pessoa
     * @return
     */
    public PessoaDTO executar2(PessoaDTO pessoa) {
        var entity = PessoaModelMapper.toEntity(pessoa);
        entity = pessoaRepository.save(entity);
        return PessoaModelMapper.toDto(entity);
    }

    /**
     * Método para criar uma pessoa, metodos no DTO
     *
     * @param pessoa
     * @return
     */
    public PessoaDTO executar3(PessoaDTO pessoa) {
        var entity = pessoa.toEntity();
        entity = pessoaRepository.save(entity);
        return PessoaDTO.fromEntity(entity);
    }
}
