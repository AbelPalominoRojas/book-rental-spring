package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.prestamo.PrestamoDto;
import com.pirqana.bookrental.application.dto.prestamo.PrestamoSaveDto;
import com.pirqana.bookrental.application.service.PrestamoService;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/prestamos")
@RestController
public class PrestamoController {

    private final PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<PrestamoDto>> findAll(){
        return ResponseEntity.ok(prestamoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDto> findById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(prestamoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PrestamoDto> create(@RequestBody PrestamoSaveDto prestamoSaveDto) throws NotFoundException {
        return ResponseEntity.ok(prestamoService.create(prestamoSaveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestamoDto> edit(@PathVariable("id") Long id, @RequestBody PrestamoSaveDto prestamoSaveDto) throws NotFoundException {
        return ResponseEntity.ok(prestamoService.edit(id, prestamoSaveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PrestamoDto> disable(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(prestamoService.disable(id));
    }

}
