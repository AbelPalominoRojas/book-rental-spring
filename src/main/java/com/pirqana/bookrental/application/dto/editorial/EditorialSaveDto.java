package com.pirqana.bookrental.application.dto.editorial;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class EditorialSaveDto {
    @NotEmpty
    @Size(min = 8, max = 10)
    private String codigo;

    @NotEmpty
    private String nombre;
}
