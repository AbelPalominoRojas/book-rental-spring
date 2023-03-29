package com.pirqana.bookrental.infrastructure.repository;

import com.pirqana.bookrental.domain.entity.Editorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EditorialRepository extends PagingAndSortingRepository<Editorial, Long> {
    Optional<List<Editorial>> findByEstadoOrderByIdDesc(boolean estado);

    @Query(value = "SELECT e FROM Editorial as e" +
            " WHERE (:codigo is null or e.codigo like %:codigo%)" +
            " AND (:nombre is null or e.nombre like %:nombre%)" +
            " AND (:estado is null or e.estado = :estado)"
    )
    List<Editorial> searchQuery(@Param("codigo") String codigo, @Param("nombre") String nombre, @Param("estado") Boolean estado);

    Page<Editorial> findByCodigoContainingAndNombreContainingAndEstado(String codigo, String nombre, Boolean estado, Pageable pageable);

    @Query(value = "SELECT e FROM Editorial as e" +
            " WHERE (:codigo is null or e.codigo like %:codigo%)" +
            " AND (:nombre is null or e.nombre like %:nombre%)" +
            " AND (:estado is null or e.estado = :estado)"
    )
    Page<Editorial> paginationFilter(@Param("codigo") String codigo, @Param("nombre") String nombre, @Param("estado") Boolean estado, Pageable pageable);
}
