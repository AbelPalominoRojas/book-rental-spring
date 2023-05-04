package com.pirqana.bookrental.application.dto.libro.mapper;

import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialMapper;
import com.pirqana.bookrental.application.dto.libro.LibroDto;
import com.pirqana.bookrental.domain.entity.Libro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EditorialMapper.class})
public interface LibroMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "titulo", target = "titulo")
    @Mapping(source = "autores", target = "autores")
    @Mapping(source = "edicion", target = "edicion")
    @Mapping(source = "anio", target = "anio")
    @Mapping(source = "editorial", target = "editorial")
    @Mapping(source = "fechaRegistro", target = "fechaRegistro")
    @Mapping(source = "estado", target = "estado")
    LibroDto toLibroDto(Libro libro);

    List<LibroDto> toLibroDtos(List<Libro> libros);

    @Mapping(target = "idEditorial", ignore = true)
	@InheritInverseConfiguration
    Libro toLibro(LibroDto libroDto);
}
