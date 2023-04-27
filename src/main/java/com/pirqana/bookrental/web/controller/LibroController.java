package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.libro.LibroDto;
import com.pirqana.bookrental.application.service.LibroService;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("libros")
@RestController
public class LibroController {
    private final LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroDto>> findAll(){
        return ResponseEntity.ok(libroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> findById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(libroService.findById(id).get());
    }

}
