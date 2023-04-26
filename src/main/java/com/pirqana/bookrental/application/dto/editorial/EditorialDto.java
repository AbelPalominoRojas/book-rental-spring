package com.pirqana.bookrental.application.dto.editorial;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EditorialDto {
    private Long id;

    private String codigo;

    private String nombre;

    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
