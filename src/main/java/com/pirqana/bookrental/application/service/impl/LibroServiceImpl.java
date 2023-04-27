package com.pirqana.bookrental.application.service.impl;

import com.pirqana.bookrental.application.dto.libro.LibroDto;
import com.pirqana.bookrental.application.dto.libro.LibroSaveDto;
import com.pirqana.bookrental.application.dto.libro.mapper.LibroMapper;
import com.pirqana.bookrental.application.dto.libro.mapper.LibroSaveMapper;
import com.pirqana.bookrental.application.service.LibroService;
import com.pirqana.bookrental.domain.entity.Libro;
import com.pirqana.bookrental.infrastructure.repository.EditorialRepository;
import com.pirqana.bookrental.infrastructure.repository.LibroRepository;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;
    private final LibroSaveMapper libroSaveMapper;
    private final EditorialRepository editorialRepository;

    @Override
    public List<LibroDto> findAll() {
        List<Libro> libros = (List<Libro>) libroRepository.findAll();
        return libroMapper.toLibroDtos(libros);
    }

    @Override
    public LibroDto findById(Long id) throws NotFoundException {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Libro no se encontro para el id: " + id));

        return libroMapper.toLibroDto(libro);
    }

    @Override
    public LibroDto create(LibroSaveDto libroSaveDto) throws NotFoundException {
        editorialRepository.findById(libroSaveDto.getIdEditorial())
                .orElseThrow(()-> new NotFoundException("Editorial no se encontro para el id: " + libroSaveDto.getIdEditorial()));

        Libro libro = libroSaveMapper.toLibro(libroSaveDto);
        libro.setFechaRegistro(LocalDateTime.now());
        libro.setEstado(true);

        return libroMapper.toLibroDto(libroRepository.save(libro));
    }

    @Override
    public LibroDto edit(Long id, LibroSaveDto libroSaveDto) throws NotFoundException {
        Libro libroDb = libroRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Libro no se encontro para el id: " + id));

        editorialRepository.findById(libroSaveDto.getIdEditorial())
                .orElseThrow(()-> new NotFoundException("Editorial no se encontro para el id: " + libroSaveDto.getIdEditorial()));

        Libro libro = libroSaveMapper.toLibro(libroSaveDto);
        libro.setId(id);
        libro.setFechaRegistro(libroDb.getFechaRegistro());
        libro.setEstado(libroDb.getEstado());

        return libroMapper.toLibroDto(libroRepository.save(libro));
    }

    @Override
    public LibroDto disable(Long id) throws NotFoundException {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Libro no se encontro para el id: " + id));

        libro.setEstado(false);

        return libroMapper.toLibroDto(libroRepository.save(libro));
    }
}
