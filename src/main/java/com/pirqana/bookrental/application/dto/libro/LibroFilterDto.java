package com.pirqana.bookrental.application.dto.libro;

import lombok.Data;

@Data
public class LibroFilterDto {
    private String isbn;

    private String titulo;

    private String autores;

    private String edicion;

    private Integer anio;

    private Long idEditorial;

    private Boolean estado;
}
