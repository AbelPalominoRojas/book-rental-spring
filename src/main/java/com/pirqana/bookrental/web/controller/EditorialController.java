package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping
    public List<EditorialDto> getAll() {
        return editorialService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EditorialDto> findById(@PathVariable("id") Long id) {
        return editorialService.findById(id);
    }

}
