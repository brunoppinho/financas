package tech.pinhos.financas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.pinhos.financas.dto.EnderecoDTO;
import tech.pinhos.financas.model.Endereco;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoDTO toDto(Endereco endereco);

    Endereco toEntity(EnderecoDTO enderecoDTO);
}
