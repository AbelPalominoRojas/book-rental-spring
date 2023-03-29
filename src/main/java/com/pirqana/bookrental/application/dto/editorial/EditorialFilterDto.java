package com.pirqana.bookrental.application.dto.editorial;

import lombok.Data;

@Data
public class EditorialFilterDto {
    private String codigo;

    private String nombre;

    private Boolean estado;
}
