package com.pirqana.bookrental.application.dto.solicitante;

import lombok.Data;

@Data
public class SolicitanteSaveDto {
    private String nombreCompleto;

    private String documentoIdentidad;

    private String email;

    private String telefono;
}
