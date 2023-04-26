package com.pirqana.bookrental.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "editoriales")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String nombre;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    private Boolean estado;
}
