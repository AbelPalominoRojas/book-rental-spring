package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.prestamo.PrestamoDto;
import com.pirqana.bookrental.application.dto.prestamo.PrestamoSaveDto;
import com.pirqana.bookrental.application.dto.prestamo.mapper.PrestamoMapper;
import com.pirqana.bookrental.application.dto.prestamo.mapper.PrestamoSaveMapper;
import com.pirqana.bookrental.application.service.PrestamoService;
import com.pirqana.bookrental.domain.entity.Prestamo;
import com.pirqana.bookrental.infrastructure.repository.PrestamoRepository;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final PrestamoMapper prestamoMapper;
    private final PrestamoSaveMapper prestamoSaveMapper;

    @Override
    public List<PrestamoDto> findAll() {
        List<Prestamo> prestamos = (List<Prestamo>) prestamoRepository.findAll();

        return prestamoMapper.toPrestamoDtos(prestamos);
    }

    @Override
    public PrestamoDto findById(Long id) throws NotFoundException {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prestamo no se encontro para el id: " + id));

        return prestamoMapper.toPrestamoDto(prestamo);
    }

    @Override
    @Transactional
    public PrestamoDto create(PrestamoSaveDto prestamoSaveDto) throws NotFoundException {
        Prestamo prestamo = prestamoSaveMapper.toPrestamo(prestamoSaveDto);
        prestamo.setFechaRegistro(LocalDateTime.now());
        prestamo.setEstado(true);

        prestamo.getDetalles().forEach(detalle -> {
             detalle.setPrestamo(prestamo);
             detalle.setFechaRegistro(prestamo.getFechaRegistro());
             detalle.setEstado(prestamo.getEstado());
        });

        return prestamoMapper.toPrestamoDto(prestamoRepository.save(prestamo));
    }

    @Override
    @Transactional
    public PrestamoDto edit(Long id, PrestamoSaveDto prestamoSaveDto) throws NotFoundException {
        Prestamo prestamoDb = prestamoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prestamo no se encontro para el id: " + id));

        Prestamo prestamo = prestamoSaveMapper.toPrestamo(prestamoSaveDto);
        prestamo.setId(prestamoDb.getId());
        prestamo.setFechaRegistro(prestamoDb.getFechaRegistro());
        prestamo.setEstado(prestamoDb.getEstado());

        prestamo.getDetalles().forEach(detalle -> {
            detalle.setPrestamo(prestamo);
            detalle.getId().setIdPrestamo(prestamoDb.getId());
            detalle.setFechaRegistro(prestamo.getFechaRegistro());
            detalle.setEstado(prestamo.getEstado());
        });

        return prestamoMapper.toPrestamoDto(prestamoRepository.save(prestamo));
    }

    @Override
    @Transactional
    public PrestamoDto disable(Long id) throws NotFoundException {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prestamo no se encontro para el id: " + id));

        prestamo.setEstado(false);

        prestamo.getDetalles().forEach(detalle ->{
            detalle.setPrestamo(prestamo);
            detalle.setEstado(false);
        });

        return prestamoMapper.toPrestamoDto(prestamoRepository.save(prestamo));
    }
}
