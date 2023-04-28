package com.pirqana.bookrental.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_prestamo")
    private LocalDateTime fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDateTime fechaDevolucion;

    @Column(name = "estado_prestamo")
    private Integer estadoPrestamo;

    @Column(name = "id_solicitante")
    private Long idSolicitante;

    @ManyToOne
    @JoinColumn(name = "id_solicitante", insertable = false, updatable = false)
    private Solicitante solicitante;

    @OneToMany(mappedBy = "prestamo", cascade = {CascadeType.ALL})
    private List<PrestamoDetalle> detalles;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
