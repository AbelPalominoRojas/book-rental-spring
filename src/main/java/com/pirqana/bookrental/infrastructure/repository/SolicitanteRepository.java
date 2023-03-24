package com.pirqana.bookrental.infrastructure.repository;

import com.pirqana.bookrental.domain.entity.Solicitante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SolicitanteRepository extends CrudRepository<Solicitante, Long> {
    Optional<List<Solicitante>> findByEstadoOrderByIdDesc(boolean estado);
}
