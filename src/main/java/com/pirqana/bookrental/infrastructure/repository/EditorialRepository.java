package com.pirqana.bookrental.infrastructure.repository;

import com.pirqana.bookrental.domain.entity.Editorial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EditorialRepository extends CrudRepository<Editorial, Long> {
    Optional<List<Editorial>> findByEstadoOrderByIdDesc (boolean estado);
}
