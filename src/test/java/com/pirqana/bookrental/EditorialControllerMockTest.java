package com.pirqana.bookrental;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pirqana.bookrental.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookrental.domain.entity.Editorial;
import com.pirqana.bookrental.infrastructure.repository.EditorialRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class EditorialControllerMockTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EditorialRepository editorialRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Editorial> editorialesMock;

    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);

        editorialesMock = List.of(
                new Editorial(1L, "EDI00001", "America", LocalDateTime.now(), true),
                new Editorial(1L, "EDI00002", "El Planeta", LocalDateTime.now(), true),
                new Editorial(1L, "EDI00003", "Alpahuara", LocalDateTime.now(), true)
        );

    }

    @AfterEach
    public void down() throws Exception {
        closeable.close();
    }

    @Test
    public void canFindEditorialById() throws Exception {
        // given
        var editorialMock = editorialesMock.stream().filter(e -> e.getId() == 1L).findFirst().get();
        Mockito.when(editorialRepository.findById(editorialMock.getId()))
                .thenReturn(Optional.of(editorialMock));

        // when
        var uri = MockMvcRequestBuilders.get("/editoriales/{id}", editorialMock.getId());
        ResultActions response = mockMvc.perform(uri);

        // then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.codigo", CoreMatchers.is(editorialMock.getCodigo())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre", CoreMatchers.is(editorialMock.getNombre())))
        ;
    }

    @Test
    public void canFindAllEditoriales() throws Exception {
        // given
        Mockito.when(editorialRepository.findByEstadoOrderByIdDesc(true))
                .thenReturn(Optional.of(editorialesMock));

        // when
        var uri = MockMvcRequestBuilders.get("/editoriales");
        ResultActions response = mockMvc.perform(uri);

        // then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].codigo", CoreMatchers.is(editorialesMock.get(0).getCodigo())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].codigo", CoreMatchers.is(editorialesMock.get(1).getCodigo())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].codigo", CoreMatchers.is(editorialesMock.get(2).getCodigo())))
        ;
    }

    @Test
    public void canCreateEditorial() throws Exception {
        // given
        var editorialMock = editorialesMock.stream().findFirst().get();
        Mockito.when(editorialRepository.save(Mockito.any(Editorial.class)))
                .thenReturn(editorialMock);

        // when
        EditorialSaveDto editorialSaveDto = EditorialSaveDto.builder()
                .codigo(editorialMock.getCodigo())
                .nombre(editorialMock.getNombre())
                .build();

        var uri = MockMvcRequestBuilders.post("/editoriales")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(editorialSaveDto));
        ResultActions response = mockMvc.perform(uri);

        // then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.codigo", CoreMatchers.is(editorialMock.getCodigo())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre", CoreMatchers.is(editorialMock.getNombre())))
        ;
    }

    @Test
    public void canEditEditorial() throws Exception {
        // given
        var editorialMock = editorialesMock.stream().findFirst().get();

        Mockito.when(editorialRepository.findById(editorialMock.getId()))
                .thenReturn(Optional.of(editorialMock));

        var editorialEditedMock = Editorial.builder()
                .id(editorialMock.getId())
                .codigo("EDE00001")
                .nombre("Editado")
                .fechaRegistro(editorialMock.getFechaRegistro())
                .estado(editorialMock.getEstado())
                .build();

        Mockito.when(editorialRepository.save(Mockito.any(Editorial.class)))
                .thenReturn(editorialEditedMock);

        // when
        EditorialSaveDto editorialSaveDto = EditorialSaveDto.builder()
                .codigo(editorialEditedMock.getCodigo())
                .nombre(editorialEditedMock.getNombre())
                .build();

        var uri = MockMvcRequestBuilders.put("/editoriales/{id}", editorialMock.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(editorialSaveDto));
        ResultActions response = mockMvc.perform(uri);

        // then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.codigo", CoreMatchers.is(editorialEditedMock.getCodigo())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre", CoreMatchers.is(editorialEditedMock.getNombre())))
        ;
    }

    @Test
    public void canDisableEditorial() throws Exception {
        // given
        var editorialMock = editorialesMock.stream().findFirst().get();

        Mockito.when(editorialRepository.findById(editorialMock.getId()))
                .thenReturn(Optional.of(editorialMock));

        Mockito.when(editorialRepository.save(Mockito.any(Editorial.class)))
                .thenReturn(editorialMock);

        // when
        var uri = MockMvcRequestBuilders.delete("/editoriales/{id}", editorialMock.getId());
        ResultActions response = mockMvc.perform(uri);

        // then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.estado", CoreMatchers.is(false)))
        ;
    }

}
