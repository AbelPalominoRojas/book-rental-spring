package com.pirqana.bookrental.application.dto.solicitante.mapper;

import com.pirqana.bookrental.application.dto.solicitante.SolicitanteFilterDto;
import com.pirqana.bookrental.domain.entity.Solicitante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SolicitanteFilterMapper {

    @Mapping(source = "nombreCompleto", target = "nombreCompleto")
    @Mapping(source = "documentoIdentidad", target = "documentoIdentidad")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "estado",target = "estado")
    SolicitanteFilterDto toSolicitanteFilterDto (Solicitante solicitante);

    @Mapping(target = "fechaRegistro", ignore = true)
	@Mapping(target = "id", ignore = true)
	@InheritInverseConfiguration
    Solicitante toSolicitante(SolicitanteFilterDto solicitanteFilterDto);
}
