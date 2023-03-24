package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;

import java.util.List;
import java.util.Optional;

public interface EditorialService {
    List<EditorialDto> findAll();
    Optional<EditorialDto> findById(Long id);
}
