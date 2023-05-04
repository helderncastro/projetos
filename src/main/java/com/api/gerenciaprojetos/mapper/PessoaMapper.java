package com.api.gerenciaprojetos.mapper;

import com.api.gerenciaprojetos.dtos.PessoaDto;
import com.api.gerenciaprojetos.models.PessoaModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PessoaMapper {

    PessoaDto toDTO(PessoaModel pessoaModel);

    PessoaModel toModel(PessoaDto pessoaDto);

}
