package com.pirqana.bookrental.application.dto.solicitante.mapper;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteSaveDto;
import com.pirqana.bookrental.domain.entity.Solicitante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SolicitanteSaveMapper {

    @Mapping(source = "nombreCompleto", target = "nombreCompleto")
    @Mapping(source = "documentoIdentidad", target = "documentoIdentidad")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "fechaRegistro",target = "fechaRegistro")
    @Mapping(source = "estado",target = "estado")
    SolicitanteSaveDto toSolicitanteSaveDto(Solicitante solicitante);


    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Solicitante toSolicitante(SolicitanteSaveDto solicitanteSaveDto);
}
