package com.pirqana.bookrental.application.dto.prestamo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PrestamoSaveDto {
    private LocalDateTime fechaPrestamo;

    private LocalDateTime fechaDevolucion;

    private Integer estadoPrestamo;

    private Long idSolicitante;

    private List<PrestamoDetalleSaveDto> detalles;
}
