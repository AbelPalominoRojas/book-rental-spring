package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialFilterDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialMapper;
import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialSaveMapper;
import com.pirqana.bookrental.application.service.EditorialService;
import com.pirqana.bookrental.domain.entity.Editorial;
import com.pirqana.bookrental.infrastructure.repository.EditorialRepository;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import com.pirqana.bookrental.shared.pagination.RequestPagination;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EditorialServiceImpl implements EditorialService {

    private EditorialRepository editorialRepository;

    private EditorialMapper editorialMapper;

    private EditorialSaveMapper editorialSaveMapper;

    public EditorialServiceImpl(EditorialRepository editorialRepository, EditorialMapper editorialMapper, EditorialSaveMapper editorialSaveMapper) {
        this.editorialRepository = editorialRepository;
        this.editorialMapper = editorialMapper;
        this.editorialSaveMapper = editorialSaveMapper;
    }

    @Override
    public List<EditorialDto> findAll() {
        List<Editorial> editoriales = editorialRepository.findByEstadoOrderByIdDesc(true).get();
        return editorialMapper.toEditorialDtos(editoriales);
    }

    @Override
    public Optional<EditorialDto> findById(Long id) throws NotFoundException {
        return Optional.ofNullable(editorialRepository.findById(id)
                .map(editorial -> editorialMapper.toEditorialDto(editorial))
                .orElseThrow(() -> new NotFoundException("Editorial no se encontro para el id: " + id)));
    }

    @Override
    public EditorialDto create(EditorialSaveDto editorialSaveDto) {
        Editorial editorial = editorialSaveMapper.toEditorial(editorialSaveDto);
        editorial.setFechaRegistro(LocalDateTime.now());
        editorial.setEstado(true);

        return editorialMapper.toEditorialDto(editorialRepository.save(editorial));
    }

    @Override
    public EditorialDto edit(Long id, EditorialSaveDto editorialSaveDto) throws NotFoundException {
        Editorial editorialDb = editorialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Editorial no se encontro para el id: " + id));

        Editorial editorial = editorialSaveMapper.toEditorial(editorialSaveDto);
        editorial.setId(id);
        editorial.setFechaRegistro(editorialDb.getFechaRegistro());
        editorial.setEstado(editorialDb.getEstado());

        return editorialMapper.toEditorialDto(editorialRepository.save(editorial));
    }

    @Override
    public EditorialDto disable(Long id) throws NotFoundException {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Editorial no se encontro para el id: " + id));
        editorial.setEstado(false);

        return editorialMapper.toEditorialDto(editorialRepository.save(editorial));
    }

    @Override
    public List<EditorialDto> searchQuery(EditorialFilterDto editorialFilterDto) {
        List<Editorial> editoriales = editorialRepository.searchQuery(
                editorialFilterDto.getCodigo(),
                editorialFilterDto.getNombre(),
                editorialFilterDto.getEstado()
        );
        return editorialMapper.toEditorialDtos(editoriales);
    }

    @Override
    public Page<EditorialDto> paginatedSearch(RequestPagination<EditorialFilterDto> requestPagination) {
        Pageable pageable = PageRequest.of(
                requestPagination.getPage(),
                requestPagination.getSize(),
                Sort.by("id").descending()
        );

        EditorialFilterDto filterDto = requestPagination.getFilter();

        Page<Editorial> editorialPage = editorialRepository.findByCodigoContainingAndNombreContainingAndEstado(
                filterDto.getCodigo(),
                filterDto.getNombre(),
                filterDto.getEstado(),
                pageable
        );

        return new PageImpl<>(
                editorialMapper.toEditorialDtos(editorialPage.getContent()),
                editorialPage.getPageable(),
                editorialPage.getTotalElements()
        );
    }

    @Override
    public Page<EditorialDto> paginationFilter(RequestPagination<EditorialFilterDto> requestPagination) {
        Pageable pageable = PageRequest.of(
                requestPagination.getPage(),
                requestPagination.getSize(),
                Sort.by("id").descending()
        );

        EditorialFilterDto filterDto = requestPagination.getFilter();

        Page<Editorial> editorialPage = editorialRepository.paginationFilter(
                filterDto.getCodigo(),
                filterDto.getNombre(),
                filterDto.getEstado(),
                pageable
        );

        return new PageImpl<>(
                editorialMapper.toEditorialDtos(editorialPage.getContent()),
                editorialPage.getPageable(),
                editorialPage.getTotalElements()
        );
    }
}
