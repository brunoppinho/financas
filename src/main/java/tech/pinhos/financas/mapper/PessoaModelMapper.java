package tech.pinhos.financas.mapper;

import org.modelmapper.ModelMapper;
import tech.pinhos.financas.dto.PessoaDTO;
import tech.pinhos.financas.model.Pessoa;

public class PessoaModelMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static PessoaDTO toDto(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public static Pessoa toEntity(PessoaDTO pessoaDTO) {
        return modelMapper.map(pessoaDTO, Pessoa.class);
    }
}
