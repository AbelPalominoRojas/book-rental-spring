package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.libro.LibroDto;
import com.pirqana.bookrental.shared.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    List<LibroDto> findAll();
    Optional<LibroDto> findById(Long id) throws NotFoundException;
}
