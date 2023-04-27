package com.pirqana.bookrental.infrastructure.repository;

import com.pirqana.bookrental.domain.entity.Solicitante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SolicitanteRepository extends PagingAndSortingRepository<Solicitante, Long> {
    Optional<List<Solicitante>> findByEstadoOrderByIdDesc(boolean estado);

    @Query(value = "SELECT s FROM Solicitante AS s" +
        " WHERE (:#{#solicitante.nombreCompleto} IS NULL OR s.nombreCompleto LIKE %:#{#solicitante.nombreCompleto}%)" +
        " AND (:#{#solicitante.documentoIdentidad} IS NULL OR s.documentoIdentidad LIKE %:#{#solicitante.documentoIdentidad}%)" +
        " AND (:#{#solicitante.email} IS NULL OR s.email LIKE %:#{#solicitante.email}%)" +
        " AND (:#{#solicitante.telefono} IS NULL OR s.telefono LIKE %:#{#solicitante.telefono}%)"  +
        " AND (:#{#solicitante.estado} IS NULL OR s.estado = :#{#solicitante.estado})"
    )
    Page<Solicitante> paginatedSearch(@Param("solicitante") Solicitante solicitante, Pageable pageable);
}
