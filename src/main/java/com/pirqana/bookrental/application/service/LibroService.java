package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.libro.LibroDto;
import com.pirqana.bookrental.application.dto.libro.LibroFilterDto;
import com.pirqana.bookrental.application.dto.libro.LibroSaveDto;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import com.pirqana.bookrental.shared.pagination.RequestPagination;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LibroService {
    List<LibroDto> findAll();
    LibroDto findById(Long id) throws NotFoundException;
    LibroDto create(LibroSaveDto libroSaveDto) throws NotFoundException;
    LibroDto edit(Long id, LibroSaveDto libroSaveDto) throws NotFoundException;
    LibroDto disable(Long id) throws NotFoundException;
    Page<LibroDto> paginatedSearch(RequestPagination<LibroFilterDto> requestPagination);
}
