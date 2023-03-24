package com.pirqana.bookrental.application.dto.editorial.mapper;


import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.domain.entity.Editorial;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorialMapper {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "codigo",target = "codigo")
    @Mapping(source = "nombre",target = "nombre")
    @Mapping(source = "fechaRegistro",target = "fechaRegistro")
    @Mapping(source = "estado",target = "estado")
    EditorialDto toEditorialDto(Editorial editorial);
    List<EditorialDto> toEditorialDtos(List<Editorial> editoriales);

    @InheritInverseConfiguration
    Editorial toEditorial(EditorialDto editorialDto);
}
