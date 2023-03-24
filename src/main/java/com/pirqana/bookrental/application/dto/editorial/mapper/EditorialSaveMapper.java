package com.pirqana.bookrental.application.dto.editorial.mapper;

import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.domain.entity.Editorial;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EditorialSaveMapper {

    @Mapping(source = "codigo",target = "codigo")
    @Mapping(source = "nombre",target = "nombre")
    @Mapping(source = "fechaRegistro",target = "fechaRegistro")
    @Mapping(source = "estado",target = "estado")
    EditorialSaveDto toEditorialSaveDto (Editorial editorial);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Editorial toEditorial (EditorialSaveDto editorialSaveDto);
}
