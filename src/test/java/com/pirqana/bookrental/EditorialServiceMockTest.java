package com.pirqana.bookrental;

import com.pirqana.bookrental.application.dto.editorial.EditorialDto;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialMapper;
import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialSaveMapper;
import com.pirqana.bookrental.application.dto.editorial.mapper.EditorialSimpleMapper;
import com.pirqana.bookrental.application.service.EditorialService;
import com.pirqana.bookrental.application.service.impl.EditorialServiceImpl;
import com.pirqana.bookrental.domain.entity.Editorial;
import com.pirqana.bookrental.infrastructure.repository.EditorialRepository;
import com.pirqana.bookrental.shared.exception.NotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EditorialServiceMockTest {

    @Mock
    private EditorialRepository editorialRepository;

    @Autowired
    private EditorialMapper editorialMapper;

    @Autowired
    private EditorialSaveMapper editorialSaveMapper;
    
    @Autowired
    private EditorialSimpleMapper editorialSimpleMapper;

    private EditorialService editorialService;
    private AutoCloseable closeable;


    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        editorialService = new EditorialServiceImpl(editorialRepository, editorialMapper, editorialSaveMapper, editorialSimpleMapper);

        Editorial editorial = Editorial.builder()
                .id(1L)
                .codigo("EDI00001")
                .nombre("America")
                .estado(true)
                .fechaRegistro(LocalDateTime.now())
                .build();

        Mockito.when(editorialRepository.findById(1L))
                .thenReturn(Optional.of(editorial));

        Mockito.when(editorialRepository.findByEstadoOrderByIdDesc(true))
                .thenReturn(Optional.of(List.of(editorial)));

        Mockito.when(editorialRepository.save(Mockito.any(Editorial.class)))
                .thenReturn(editorial);
    }


    @Test
    public void canFindEditoriaByID() throws NotFoundException {
        EditorialDto editorialDto = editorialService.findById(1L);

        Assertions.assertThat(editorialDto.getCodigo()).isEqualTo("EDI00001");
    }

    @Test
    public void canFindAllEditoriales() {
        List<EditorialDto> editorialDtos = editorialService.findAll();

        org.junit.jupiter.api.Assertions.assertNotNull(editorialDtos);
    }

    @Test
    public void canCreateEditorial() {
        EditorialSaveDto editorialSaveDto = EditorialSaveDto.builder()
                .codigo("EDI00001")
                .nombre("America")
                .build();

        EditorialDto editorialDto = editorialService.create(editorialSaveDto);

        Assertions.assertThat(editorialDto.getCodigo()).isEqualTo("EDI00001");
    }

    @Test
    public void canEditEditorial() throws NotFoundException {
        EditorialSaveDto editorialSaveDto = EditorialSaveDto.builder()
                .codigo("EDI00001")
                .nombre("America")
                .build();

        EditorialDto editorialDto = editorialService.edit(1L, editorialSaveDto);

        Assertions.assertThat(editorialDto.getCodigo()).isEqualTo("EDI00001");
    }

    @AfterEach
    public void releaseMocks() throws Exception {
        closeable.close();
    }
}
