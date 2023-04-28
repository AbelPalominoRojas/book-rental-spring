package com.pirqana.bookrental.infrastructure.repository;

import com.pirqana.bookrental.domain.entity.Prestamo;
import org.springframework.data.repository.CrudRepository;

public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {
}
