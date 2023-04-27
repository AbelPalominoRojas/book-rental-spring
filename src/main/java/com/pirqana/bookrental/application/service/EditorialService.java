package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialFilterDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import com.pirqana.bookrental.shared.pagination.RequestPagination;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EditorialService {
    List<EditorialDto> findAll();

    EditorialDto findById(Long id) throws NotFoundException;

    EditorialDto create(EditorialSaveDto editorialSaveDto);

    EditorialDto edit(Long id, EditorialSaveDto editorialSaveDto) throws NotFoundException;

    EditorialDto disable(Long id) throws NotFoundException;

    List<EditorialDto> searchQuery(EditorialFilterDto editorialFilterDto);

    Page<EditorialDto> paginatedSearch(RequestPagination<EditorialFilterDto> requestPagination);

    Page<EditorialDto> paginationFilter(RequestPagination<EditorialFilterDto> requestPagination);
}
