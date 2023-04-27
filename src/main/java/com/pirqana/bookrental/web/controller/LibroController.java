package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.libro.LibroDto;
import com.pirqana.bookrental.application.dto.libro.LibroFilterDto;
import com.pirqana.bookrental.application.dto.libro.LibroSaveDto;
import com.pirqana.bookrental.application.service.LibroService;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import com.pirqana.bookrental.shared.pagination.RequestPagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("libros")
@RestController
public class LibroController {
    private final LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroDto>> findAll() {
        return ResponseEntity.ok(libroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> findById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(libroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<LibroDto> create(@Valid @RequestBody LibroSaveDto libroSaveDto) throws NotFoundException {
        return ResponseEntity.ok(libroService.create(libroSaveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDto> edit(@PathVariable("id") Long id, @Valid @RequestBody LibroSaveDto libroSaveDto) throws NotFoundException {
        return ResponseEntity.ok(libroService.edit(id, libroSaveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LibroDto> disable(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(libroService.disable(id));
    }

    @PostMapping("/paginatedSearch")
    public ResponseEntity<Page<LibroDto>> paginatedSearch(@RequestBody RequestPagination<LibroFilterDto> requestPagination) {
        return ResponseEntity.ok(libroService.paginatedSearch(requestPagination));
    }
}
