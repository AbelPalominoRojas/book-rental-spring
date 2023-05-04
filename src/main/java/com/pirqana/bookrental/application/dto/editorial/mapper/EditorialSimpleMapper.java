package com.pirqana.bookrental.application.dto.editorial.mapper;

import com.pirqana.bookrental.application.dto.editorial.EditorialSimpleDto;
import com.pirqana.bookrental.domain.entity.Editorial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorialSimpleMapper {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "codigo",target = "codigo")
    @Mapping(source = "nombre",target = "nombre")
    EditorialSimpleDto toEditorialSimpleDto(Editorial editorial);
    List<EditorialSimpleDto> toEditorialSimpleDtos(List<Editorial> editoriales);
}
