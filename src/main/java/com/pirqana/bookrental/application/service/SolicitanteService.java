package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.application.dto.solicitante.SolicitanteFilterDto;
import com.pirqana.bookrental.application.dto.solicitante.SolicitanteSaveDto;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import com.pirqana.bookrental.shared.pagination.RequestPagination;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SolicitanteService {
    List<SolicitanteDto> findAll();

    SolicitanteDto findById(Long id) throws NotFoundException;

    SolicitanteDto create(SolicitanteSaveDto solicitanteSaveDto);

    SolicitanteDto edit(Long id, SolicitanteSaveDto solicitanteSaveDto) throws NotFoundException;

    SolicitanteDto disable(Long id) throws NotFoundException;

    Page<SolicitanteDto> paginatedSearch(RequestPagination<SolicitanteFilterDto> requestPagination);
}
