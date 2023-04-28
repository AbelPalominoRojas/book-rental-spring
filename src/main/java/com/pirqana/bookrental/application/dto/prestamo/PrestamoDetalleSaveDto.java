package com.pirqana.bookrental.application.dto.prestamo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PrestamoDetalleSaveDto {
    private Long idLibro;

    private Integer devuelto;

    private BigDecimal mora;
}
