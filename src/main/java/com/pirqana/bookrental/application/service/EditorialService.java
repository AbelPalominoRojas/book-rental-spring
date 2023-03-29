package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialFilterDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.domain.entity.Editorial;
import com.pirqana.bookrental.shared.pagination.RequestPagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface EditorialService {
    List<EditorialDto> findAll();

    Optional<EditorialDto> findById(Long id);

    EditorialDto create(EditorialSaveDto editorialSaveDto);

    EditorialDto edit(Long id, EditorialSaveDto editorialSaveDto);

    EditorialDto disable(Long id);

    List<EditorialDto> searchQuery(EditorialFilterDto editorialFilterDto);

    Page<EditorialDto> paginatedSearch(RequestPagination<EditorialFilterDto> requestPagination);

    Page<EditorialDto> paginationFilter(RequestPagination<EditorialFilterDto> requestPagination);
}
