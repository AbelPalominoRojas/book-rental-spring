package com.pirqana.bookrental.application.dto.prestamo;

import com.pirqana.bookrental.application.dto.libro.LibroDto;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PrestamoDetalleDto {
//    private Long idPrestamo;

//    private Long idLibro;

    private LibroDto libro;

    private Integer devuelto;

    private BigDecimal mora;

    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
