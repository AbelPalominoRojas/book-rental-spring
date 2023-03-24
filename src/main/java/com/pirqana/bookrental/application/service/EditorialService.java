package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;

import java.util.List;
import java.util.Optional;

public interface EditorialService {
    List<EditorialDto> findAll();

    Optional<EditorialDto> findById(Long id);

    EditorialDto create(EditorialSaveDto editorialSaveDto);

    EditorialDto edit(Long id, EditorialSaveDto editorialSaveDto);

    EditorialDto disable(Long id);
}
