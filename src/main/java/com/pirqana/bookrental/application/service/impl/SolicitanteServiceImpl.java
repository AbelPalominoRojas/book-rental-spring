package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialMapper;
import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.application.dto.solicitante.mapper.SolicitanteMapper;
import com.pirqana.bookrental.application.service.SolicitanteService;
import com.pirqana.bookrental.domain.entity.Solicitante;
import com.pirqana.bookrental.infrastructure.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitanteServiceImpl implements SolicitanteService {

    @Autowired
    SolicitanteRepository solicitanteRepository;

    @Autowired
    SolicitanteMapper solicitanteMapper;

    @Override
    public List<SolicitanteDto> findAll() {
        List<Solicitante> solicitantes = (List<Solicitante>) solicitanteRepository.findAll();

        return solicitanteMapper.toSolicitanteDtos(solicitantes);
    }

    @Override
    public Optional<SolicitanteDto> findById(Long id) {
        return solicitanteRepository.findById(id)
                .map(solicitante -> solicitanteMapper.toSolicitanteDto(solicitante));
    }
}