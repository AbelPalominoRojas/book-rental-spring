package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialMapper;
import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialSaveMapper;
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

    @Autowired
    private EditorialSaveMapper editorialSaveMapper;

    @Override
    public List<EditorialDto> findAll() {
        // List<Editorial> editoriales = (List<Editorial>) editorialRepository.findAll();
        List<Editorial> editoriales = editorialRepository.findByEstadoOrderByIdDesc(true).get();
        return editorialMapper.toEditorialDtos(editoriales);
    }

    @Override
    public Optional<EditorialDto> findById(Long id) {
        return editorialRepository.findById(id)
                .map(editorial -> editorialMapper.toEditorialDto(editorial));
    }

    @Override
    public EditorialDto create(EditorialSaveDto editorialSaveDto) {
        Editorial editorial = editorialSaveMapper.toEditorial(editorialSaveDto);

        return editorialMapper.toEditorialDto(editorialRepository.save(editorial));
    }

    @Override
    public EditorialDto edit(Long id, EditorialSaveDto editorialSaveDto) {
        Editorial editorial = editorialSaveMapper.toEditorial(editorialSaveDto);
        editorial.setId(id);

        return editorialMapper.toEditorialDto(editorialRepository.save(editorial));
    }

    @Override
    public EditorialDto disable(Long id) {
        Editorial editorial = editorialRepository.findById(id).get();
        editorial.setEstado(false);

        return editorialMapper.toEditorialDto(editorialRepository.save(editorial));
    }
}
