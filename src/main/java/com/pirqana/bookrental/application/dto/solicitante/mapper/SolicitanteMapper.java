package com.pirqana.bookrental.application.dto.solicitante.mapper;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteDto;
import com.pirqana.bookrental.domain.entity.Solicitante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SolicitanteMapper {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "nombreCompleto", target = "nombreCompleto")
    @Mapping(source = "documentoIdentidad", target = "documentoIdentidad")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "fechaRegistro",target = "fechaRegistro")
    @Mapping(source = "estado",target = "estado")
    SolicitanteDto toSolicitanteDto (Solicitante solicitante);
    List<SolicitanteDto>toSolicitanteDtos (List<Solicitante> solicitantes);

    @InheritInverseConfiguration
    Solicitante toSolicitante (SolicitanteDto solicitanteDto);
}
