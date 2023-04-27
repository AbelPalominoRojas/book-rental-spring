package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.application.dto.solicitante.SolicitanteSaveDto;
import com.pirqana.bookrental.application.dto.solicitante.mapper.SolicitanteMapper;
import com.pirqana.bookrental.application.dto.solicitante.mapper.SolicitanteSaveMapper;
import com.pirqana.bookrental.application.service.SolicitanteService;
import com.pirqana.bookrental.domain.entity.Solicitante;
import com.pirqana.bookrental.infrastructure.repository.SolicitanteRepository;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SolicitanteServiceImpl implements SolicitanteService {

    private final SolicitanteRepository solicitanteRepository;

    private final SolicitanteMapper solicitanteMapper;

    private final SolicitanteSaveMapper solicitanteSaveMapper;


    @Override
    public List<SolicitanteDto> findAll() {
        List<Solicitante> solicitantes = solicitanteRepository.findByEstadoOrderByIdDesc(true)
                .orElse(new ArrayList<>());

        return solicitanteMapper.toSolicitanteDtos(solicitantes);
    }

    @Override
    public SolicitanteDto findById(Long id) throws NotFoundException {
        Solicitante solicitante = solicitanteRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Editorial no se encontro para el id: " + id));

        return solicitanteMapper.toSolicitanteDto(solicitante);
    }

    @Override
    public SolicitanteDto create(SolicitanteSaveDto solicitanteSaveDto) {
        Solicitante solicitante = solicitanteSaveMapper.toSolicitante(solicitanteSaveDto);
        solicitante.setFechaRegistro(LocalDateTime.now());
        solicitante.setEstado(true);

        return solicitanteMapper.toSolicitanteDto(solicitanteRepository.save(solicitante));
    }

    @Override
    public SolicitanteDto edit(Long id, SolicitanteSaveDto solicitanteSaveDto) throws NotFoundException {
        Solicitante solicitanteDb = solicitanteRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Editorial no se encontro para el id: " + id));;

        Solicitante solicitante = solicitanteSaveMapper.toSolicitante(solicitanteSaveDto);
        solicitante.setId(id);
        solicitante.setFechaRegistro(solicitanteDb.getFechaRegistro());
        solicitante.setEstado(solicitanteDb.getEstado());

        return solicitanteMapper.toSolicitanteDto(solicitanteRepository.save(solicitante));
    }

    @Override
    public SolicitanteDto disable(Long id) throws NotFoundException {
        Solicitante solicitante = solicitanteRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Editorial no se encontro para el id: " + id));
        solicitante.setEstado(false);

        return solicitanteMapper.toSolicitanteDto(solicitante);
    }
}
