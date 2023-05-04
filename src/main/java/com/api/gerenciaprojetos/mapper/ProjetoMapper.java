package com.api.gerenciaprojetos.mapper;

import com.api.gerenciaprojetos.dtos.ProjetoDto;
import com.api.gerenciaprojetos.models.ProjetoModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjetoMapper {

    ProjetoDto toDTO(ProjetoModel projetoModel);

    ProjetoModel toModel(ProjetoDto projetoDto);

}
