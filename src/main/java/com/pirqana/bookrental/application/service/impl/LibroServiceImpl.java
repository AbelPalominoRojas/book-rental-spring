package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.libro.LibroDto;
import com.pirqana.bookrental.application.dto.libro.mapper.LibroMapper;
import com.pirqana.bookrental.application.service.LibroService;
import com.pirqana.bookrental.domain.entity.Libro;
import com.pirqana.bookrental.infrastructure.repository.LibroRepository;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;

    @Override
    public List<LibroDto> findAll() {
        List<Libro> libros = (List<Libro>) libroRepository.findAll();
        return libroMapper.toLibroDtos(libros);
    }

    @Override
    public Optional<LibroDto> findById(Long id) throws NotFoundException {
        return Optional.ofNullable(
                libroRepository.findById(id)
                        .map(libroMapper::toLibroDto)
                        .orElseThrow(() -> new NotFoundException("Libro no se encontro para el id: " + id))
        );
    }
}
