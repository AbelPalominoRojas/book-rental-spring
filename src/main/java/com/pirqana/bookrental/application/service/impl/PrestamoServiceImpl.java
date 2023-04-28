package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.prestamo.PrestamoDto;
import com.pirqana.bookrental.application.dto.prestamo.mapper.PrestamoMapper;
import com.pirqana.bookrental.application.service.PrestamoService;
import com.pirqana.bookrental.domain.entity.Prestamo;
import com.pirqana.bookrental.infrastructure.repository.PrestamoRepository;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final PrestamoMapper prestamoMapper;


    @Override
    public List<PrestamoDto> findAll() {
        List<Prestamo> prestamos = (List<Prestamo>) prestamoRepository.findAll();

        return prestamoMapper.toPrestamoDtos(prestamos);
    }

    @Override
    public PrestamoDto findById(Long id) throws NotFoundException {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Prestamo no se encontro para el id: " + id));

        return prestamoMapper.toPrestamoDto(prestamo);
    }
}
