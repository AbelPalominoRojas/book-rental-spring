package com.pirqana.bookrental.application.dto.solicitante;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SolicitanteSaveDto {
    @NotEmpty
    private String nombreCompleto;

    @NotEmpty
    @Size(min = 8, max = 15)
    private String documentoIdentidad;

    @NotEmpty
    @Email
    private String email;

    private String telefono;
}
