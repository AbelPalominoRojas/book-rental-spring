package com.pirqana.bookrental.application.dto.editorial;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class EditorialSaveDto {
    private String codigo;

    private String nombre;

    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
