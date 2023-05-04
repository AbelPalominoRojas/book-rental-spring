package com.pirqana.bookrental.application.dto.libro.mapper;

import com.pirqana.bookrental.application.dto.libro.LibroSaveDto;
import com.pirqana.bookrental.domain.entity.Libro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LibroSaveMapper {

    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "titulo", target = "titulo")
    @Mapping(source = "autores", target = "autores")
    @Mapping(source = "edicion", target = "edicion")
    @Mapping(source = "anio", target = "anio")
    @Mapping(source = "idEditorial", target = "idEditorial")
    LibroSaveDto toLibroSaveDto(Libro libro);

    @Mapping(target = "editorial", ignore = true)
	@Mapping(target = "estado", ignore = true)
	@Mapping(target = "fechaRegistro", ignore = true)
	@Mapping(target = "id", ignore = true)
	@InheritInverseConfiguration
    Libro toLibro(LibroSaveDto libroSaveDto);
}
