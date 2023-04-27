package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.application.dto.solicitante.SolicitanteSaveDto;
import com.pirqana.bookrental.shared.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface SolicitanteService {
    List<SolicitanteDto> findAll();

    SolicitanteDto findById(Long id) throws NotFoundException;

    SolicitanteDto create(SolicitanteSaveDto solicitanteSaveDto);

    SolicitanteDto edit(Long id, SolicitanteSaveDto solicitanteSaveDto) throws NotFoundException;

    SolicitanteDto disable(Long id) throws NotFoundException;
}
