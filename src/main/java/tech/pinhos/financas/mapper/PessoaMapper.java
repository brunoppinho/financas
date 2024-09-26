package tech.pinhos.financas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.pinhos.financas.dto.PessoaDTO;
import tech.pinhos.financas.model.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO toDto(Pessoa pessoa);

    Pessoa toEntity(PessoaDTO pessoaDTO);
}
