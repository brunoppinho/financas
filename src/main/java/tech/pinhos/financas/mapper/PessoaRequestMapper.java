package tech.pinhos.financas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.pinhos.financas.dto.PessoaRequestDTO;
import tech.pinhos.financas.model.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaRequestMapper {

    PessoaRequestMapper INSTANCE = Mappers.getMapper(PessoaRequestMapper.class);

    PessoaRequestDTO toDto(Pessoa pessoa);

    Pessoa toEntity(PessoaRequestDTO pessoaDTO);
}
