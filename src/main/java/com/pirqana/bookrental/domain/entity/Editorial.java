package com.pirqana.bookrental.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "editoriales")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private String nombre;

    @Column(name = "fecha_registro")
    @Getter
    @Setter
    private LocalDateTime fechaRegistro;

    @Getter
    @Setter
    private Boolean estado;
}
