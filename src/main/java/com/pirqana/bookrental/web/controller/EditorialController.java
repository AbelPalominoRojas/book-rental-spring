package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.application.service.EditorialService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    private EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping
    public ResponseEntity<List<EditorialDto>> getAll() {
        return ResponseEntity.ok(editorialService.findAll());
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<EditorialDto> findById(@PathVariable("id") Long id) {
        return editorialService.findById(id)
                .map(editorialDto -> new ResponseEntity<>(editorialDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiResponse(responseCode = "200")
    public ResponseEntity<EditorialDto> create(@RequestBody EditorialSaveDto editorialSaveDto) {
        return ResponseEntity.ok(editorialService.create(editorialSaveDto));
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<EditorialDto> edit(@PathVariable("id") Long id, @RequestBody EditorialSaveDto editorialSaveDto) {
        return ResponseEntity.ok(editorialService.edit(id, editorialSaveDto));
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<EditorialDto> disable(@PathVariable("id") Long id) {
        return ResponseEntity.ok(editorialService.disable(id));
    }
}
