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
    SolicitanteSaveDto toSolicitanteSaveDto(Solicitante solicitante);


    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Solicitante toSolicitante(SolicitanteSaveDto solicitanteSaveDto);
}
