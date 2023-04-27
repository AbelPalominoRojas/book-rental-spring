package com.pirqana.bookrental.application.dto.libro;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LibroDto {
    private Long id;

    private String isbn;

    private String titulo;

    private String autores;

    private String edicion;

    private Integer anio;

//    private Integer idEditorial;

    private EditorialDto editorial;

    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
