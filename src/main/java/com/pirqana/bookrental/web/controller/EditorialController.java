package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.application.service.EditorialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    private EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping
    public List<EditorialDto> getAll() {
        return editorialService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EditorialDto> findById(@PathVariable("id") Long id) {
        return editorialService.findById(id);
    }

    @PostMapping
    public EditorialDto create(@RequestBody EditorialSaveDto editorialSaveDto) {
        return editorialService.create(editorialSaveDto);
    }

    @PutMapping("/{id}")
    public EditorialDto edit(@PathVariable("id") Long id, @RequestBody EditorialSaveDto editorialSaveDto) {
        return editorialService.edit(id, editorialSaveDto);
    }

    @DeleteMapping("/{id}")
    public EditorialDto disable(@PathVariable("id") Long id) {
        return editorialService.disable(id);
    }
}
