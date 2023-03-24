package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.application.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitantes")
public class SolicitanteController {

    @Autowired
    private SolicitanteService solicitanteService;

    @GetMapping
    public List<SolicitanteDto> getAll(){
        return solicitanteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SolicitanteDto> findById(@PathVariable("id") Long id) {
        return solicitanteService.findById(id);
    }
}
