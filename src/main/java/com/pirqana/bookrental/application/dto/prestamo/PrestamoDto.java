package com.pirqana.bookrental.application.dto.prestamo;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PrestamoDto {
    private Long id;

    private LocalDateTime fechaPrestamo;

    private LocalDateTime fechaDevolucion;

    private Integer estadoPrestamo;

//    private Long idSolicitante;

    private SolicitanteDto solicitante;

    private List<PrestamoDetalleDto> detalles;

    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
