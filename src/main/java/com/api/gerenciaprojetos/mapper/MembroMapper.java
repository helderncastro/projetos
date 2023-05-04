package com.api.gerenciaprojetos.mapper;

import com.api.gerenciaprojetos.dtos.MembroDto;
import com.api.gerenciaprojetos.models.MembroModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MembroMapper {

    MembroDto toDTO(MembroModel membroModel);

    MembroModel toModel(MembroDto membroDto);
}
