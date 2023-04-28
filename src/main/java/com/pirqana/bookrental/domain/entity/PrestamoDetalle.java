package com.pirqana.bookrental.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prestamos_detalles")
public class PrestamoDetalle {
    @EmbeddedId
    private PrestamoDetallePK id;

    private Integer devuelto;

    private BigDecimal mora;

    @ManyToOne
    @MapsId("idPrestamo")
    @JoinColumn(name = "id_prestamo", insertable = false, updatable = false)
    private Prestamo prestamo;

    @ManyToOne
    @JoinColumn(name = "id_libro", insertable = false, updatable = false)
    private Libro libro;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
