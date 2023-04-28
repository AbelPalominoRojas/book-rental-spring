package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.prestamo.PrestamoDto;
import com.pirqana.bookrental.shared.exception.NotFoundException;

import java.util.List;

public interface PrestamoService {
    List<PrestamoDto> findAll();
    PrestamoDto findById(Long id) throws NotFoundException;
}
