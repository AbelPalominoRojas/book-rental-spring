package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialMapper;
import com.pirqana.bookrental.application.service.EditorialService;
import com.pirqana.bookrental.domain.entity.Editorial;
import com.pirqana.bookrental.infrastructure.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    private EditorialMapper editorialMapper;

    @Override
    public List<EditorialDto> findAll() {
        List<Editorial> editoriales = (List<Editorial>) editorialRepository.findAll();
        return editorialMapper.toEditorialDtos(editoriales);
    }

    @Override
    public Optional<EditorialDto> findById(Long id) {
        return editorialRepository.findById(id)
                .map(editorial -> editorialMapper.toEditorialDto(editorial));
    }
}
