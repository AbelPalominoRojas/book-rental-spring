package com.pirqana.bookrental.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitantes")
@Data
public class Solicitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "documento_identidad")
    private String documentoIdentidad;

    private String email;

    private String telefono;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
