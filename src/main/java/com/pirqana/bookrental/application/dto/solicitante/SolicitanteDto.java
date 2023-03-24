package com.pirqana.bookrental.application.dto.solicitante;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SolicitanteDto {
    private Long id;

    private String nombreCompleto;

    private String documentoIdentidad;

    private String email;

    private String telefono;

    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
