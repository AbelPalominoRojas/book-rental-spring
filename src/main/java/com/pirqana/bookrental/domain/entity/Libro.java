package com.pirqana.bookrental.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "libros")
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String titulo;

    private String autores;

    private String edicion;

    private Integer anio;

    @Column(name = "id_editorial")
    private Long idEditorial;

    @ManyToOne
    @JoinColumn(name = "id_editorial", insertable = false, updatable = false)
    private Editorial editorial;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
