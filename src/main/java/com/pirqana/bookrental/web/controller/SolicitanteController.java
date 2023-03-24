package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.application.dto.solicitante.SolicitanteSaveDto;
import com.pirqana.bookrental.application.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitantes")
public class SolicitanteController {

    @Autowired
    private SolicitanteService solicitanteService;

    @GetMapping
    public List<SolicitanteDto> getAll() {
        return solicitanteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SolicitanteDto> findById(@PathVariable("id") Long id) {
        return solicitanteService.findById(id);
    }

    @PostMapping
    public SolicitanteDto create(@RequestBody SolicitanteSaveDto solicitanteSaveDto) {
        return solicitanteService.create(solicitanteSaveDto);
    }

    @PutMapping("/{id}")
    public SolicitanteDto edit(@PathVariable("id") Long id, @RequestBody SolicitanteSaveDto solicitanteSaveDto) {
        return solicitanteService.edit(id, solicitanteSaveDto);
    }

    @DeleteMapping("/{id}")
    public SolicitanteDto disable(@PathVariable("id") Long id) {
        return solicitanteService.disable(id);
    }
}
