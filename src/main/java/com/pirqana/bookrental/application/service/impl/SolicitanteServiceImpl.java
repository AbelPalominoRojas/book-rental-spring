package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.application.dto.solicitante.SolicitanteSaveDto;
import com.pirqana.bookrental.application.dto.solicitante.mapper.SolicitanteMapper;
import com.pirqana.bookrental.application.dto.solicitante.mapper.SolicitanteSaveMapper;
import com.pirqana.bookrental.application.service.SolicitanteService;
import com.pirqana.bookrental.domain.entity.Solicitante;
import com.pirqana.bookrental.infrastructure.repository.SolicitanteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitanteServiceImpl implements SolicitanteService {

    SolicitanteRepository solicitanteRepository;

    SolicitanteMapper solicitanteMapper;

    SolicitanteSaveMapper solicitanteSaveMapper;

    public SolicitanteServiceImpl(SolicitanteRepository solicitanteRepository, SolicitanteMapper solicitanteMapper, SolicitanteSaveMapper solicitanteSaveMapper) {
        this.solicitanteRepository = solicitanteRepository;
        this.solicitanteMapper = solicitanteMapper;
        this.solicitanteSaveMapper = solicitanteSaveMapper;
    }

    @Override
    public List<SolicitanteDto> findAll() {
        List<Solicitante> solicitantes = solicitanteRepository.findByEstadoOrderByIdDesc(true).get();

        return solicitanteMapper.toSolicitanteDtos(solicitantes);
    }

    @Override
    public Optional<SolicitanteDto> findById(Long id) {
        return solicitanteRepository.findById(id)
                .map(solicitante -> solicitanteMapper.toSolicitanteDto(solicitante));
    }

    @Override
    public SolicitanteDto create(SolicitanteSaveDto solicitanteSaveDto) {
        Solicitante solicitante = solicitanteSaveMapper.toSolicitante(solicitanteSaveDto);
        solicitante.setFechaRegistro(LocalDateTime.now());
        solicitante.setEstado(true);

        return solicitanteMapper.toSolicitanteDto(solicitanteRepository.save(solicitante));
    }

    @Override
    public SolicitanteDto edit(Long id, SolicitanteSaveDto solicitanteSaveDto) {
        Solicitante solicitanteDb = solicitanteRepository.findById(id).get();

        Solicitante solicitante = solicitanteSaveMapper.toSolicitante(solicitanteSaveDto);
        solicitante.setId(id);
        solicitante.setFechaRegistro(solicitanteDb.getFechaRegistro());
        solicitante.setEstado(solicitanteDb.getEstado());

        return solicitanteMapper.toSolicitanteDto(solicitanteRepository.save(solicitante));
    }

    @Override
    public SolicitanteDto disable(Long id) {
        Solicitante solicitante = solicitanteRepository.findById(id).get();
        solicitante.setEstado(false);

        return solicitanteMapper.toSolicitanteDto(solicitante);
    }
}
