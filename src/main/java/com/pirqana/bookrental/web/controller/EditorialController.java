package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialFilterDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSimpleDto;
import com.pirqana.bookrental.application.service.EditorialService;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import com.pirqana.bookrental.shared.pagination.RequestPagination;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
    public ResponseEntity<EditorialDto> findById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(editorialService.findById(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "200")
    public ResponseEntity<EditorialDto> create(@Valid @RequestBody EditorialSaveDto editorialSaveDto) {
        return ResponseEntity.ok(editorialService.create(editorialSaveDto));
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<EditorialDto> edit(@PathVariable("id") Long id, @RequestBody EditorialSaveDto editorialSaveDto) throws NotFoundException {
        return ResponseEntity.ok(editorialService.edit(id, editorialSaveDto));
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<EditorialDto> disable(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(editorialService.disable(id));
    }

    @PostMapping(value = "/paginatedSearch")
    public ResponseEntity<Page<EditorialDto>> paginatedSearch(@RequestBody RequestPagination<EditorialFilterDto> requestPagination) {
        return ResponseEntity.ok(editorialService.paginatedSearch(requestPagination));
    }

    @PostMapping(value = "search")
    public ResponseEntity<List<EditorialDto>> searchQuery(@RequestBody EditorialFilterDto editorialFilterDto) {
        return ResponseEntity.ok(editorialService.searchQuery(editorialFilterDto));
    }

    @PostMapping(value = "/paginationFilter")
    public ResponseEntity<Page<EditorialDto>> paginationFilter(@RequestBody RequestPagination<EditorialFilterDto> requestPagination) {
        return ResponseEntity.ok(editorialService.paginationFilter(requestPagination));
    }

    @GetMapping(value = "/select")
    public ResponseEntity<List<EditorialSimpleDto>> findAllSimple(){
        return ResponseEntity.ok(editorialService.findAllSimple());
    }
}
