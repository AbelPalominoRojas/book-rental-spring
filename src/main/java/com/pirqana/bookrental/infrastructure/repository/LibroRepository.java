package com.pirqana.bookrental.infrastructure.repository;

import com.pirqana.bookrental.domain.entity.Libro;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LibroRepository extends PagingAndSortingRepository<Libro, Long> {
}
