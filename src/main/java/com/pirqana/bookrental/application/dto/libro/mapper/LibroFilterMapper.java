package com.pirqana.bookrental.application.dto.libro.mapper;

import com.pirqana.bookrental.application.dto.libro.LibroFilterDto;
import com.pirqana.bookrental.domain.entity.Libro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LibroFilterMapper {
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "titulo", target = "titulo")
    @Mapping(source = "autores", target = "autores")
    @Mapping(source = "edicion", target = "edicion")
    @Mapping(source = "anio", target = "anio")
    @Mapping(source = "idEditorial", target = "idEditorial")
    @Mapping(source = "estado", target = "estado")
    LibroFilterDto toLibroSaveDto(Libro libro);

    @InheritInverseConfiguration
    Libro toLibro(LibroFilterDto libroFilterDto);
}
