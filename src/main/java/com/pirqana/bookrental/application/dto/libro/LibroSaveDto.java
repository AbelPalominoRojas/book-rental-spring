package com.pirqana.bookrental.application.dto.libro;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class LibroSaveDto {
    @NotEmpty
    private String isbn;

    @NotEmpty
    private String titulo;

    @NotEmpty
    private String autores;

    private String edicion;

    private Integer anio;

    @NotNull
    @Positive
    private Long idEditorial;
}
