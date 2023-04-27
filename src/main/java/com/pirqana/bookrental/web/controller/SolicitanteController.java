package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.application.dto.solicitante.SolicitanteSaveDto;
import com.pirqana.bookrental.application.service.SolicitanteService;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/solicitantes")
public class SolicitanteController {

    private final SolicitanteService solicitanteService;

    @GetMapping
    public List<SolicitanteDto> getAll() {
        return solicitanteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitanteDto> findById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(solicitanteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SolicitanteDto> create(@Valid @RequestBody SolicitanteSaveDto solicitanteSaveDto) {
        return ResponseEntity.ok(solicitanteService.create(solicitanteSaveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitanteDto> edit(@PathVariable("id") Long id, @Valid @RequestBody SolicitanteSaveDto solicitanteSaveDto) throws NotFoundException {
        return ResponseEntity.ok(solicitanteService.edit(id, solicitanteSaveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SolicitanteDto> disable(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(solicitanteService.disable(id));
    }
}
