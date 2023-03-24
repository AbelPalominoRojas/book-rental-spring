package com.pirqana.bookrental.application.service;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.application.dto.solicitante.SolicitanteSaveDto;

import java.util.List;
import java.util.Optional;

public interface SolicitanteService {
    List<SolicitanteDto> findAll();

    Optional<SolicitanteDto> findById(Long id);

    SolicitanteDto create(SolicitanteSaveDto solicitanteSaveDto);

    SolicitanteDto edit(Long id, SolicitanteSaveDto solicitanteSaveDto);

    SolicitanteDto disable(Long id);
}
