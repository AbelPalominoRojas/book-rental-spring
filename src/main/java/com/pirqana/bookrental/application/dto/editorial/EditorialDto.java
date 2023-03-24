package com.pirqana.bookrental.application.dto.editorial;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class EditorialDto {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private LocalDateTime fechaRegistro;

    @Getter
    @Setter
    private Boolean estado;
}
