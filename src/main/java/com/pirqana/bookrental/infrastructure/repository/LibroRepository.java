package com.pirqana.bookrental.infrastructure.repository;

import com.pirqana.bookrental.domain.entity.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends PagingAndSortingRepository<Libro, Long> {
    Optional<List<Libro>> findByEstadoOrderByIdDesc(boolean estado);

    @Query(value = "SELECT l FROM Libro AS l" +
            " WHERE (:#{#libro.isbn} IS NULL OR l.isbn LIKE %:#{#libro.isbn}%)" +
            " AND (:#{#libro.titulo} IS NULL OR l.titulo LIKE %:#{#libro.titulo}%)" +
            " AND (:#{#libro.autores} IS NULL OR l.autores LIKE %:#{#libro.autores}%)" +
            " AND (:#{#libro.edicion} IS NULL OR l.edicion LIKE %:#{#libro.edicion}%)" +
            " AND (:#{#libro.anio} IS NULL OR l.anio = :#{#libro.anio})" +
            " AND (:#{#libro.idEditorial} IS NULL OR l.idEditorial = :#{#libro.idEditorial})" +
            " AND (:#{#libro.estado} IS NULL OR l.estado = :#{#libro.estado})"
    )
    Page<Libro> paginatedSearch(@Param("libro") Libro libro, Pageable pageable);
}
