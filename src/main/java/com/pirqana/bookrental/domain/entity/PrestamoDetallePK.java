package com.pirqana.bookrental.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class PrestamoDetallePK implements Serializable {
    @Column(name = "id_prestamo")
    private Long idPrestamo;

    @Column(name = "id_libro")
    private Long idLibro;
}
