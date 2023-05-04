package com.pirqana.bookrental.application.dto.prestamo.mapper;

import com.pirqana.bookrental.application.dto.prestamo.PrestamoDetalleSaveDto;
import com.pirqana.bookrental.domain.entity.PrestamoDetalle;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrestamoDetalleSaveMapper {
    @Mapping(source = "id.idLibro", target = "idLibro")
    @Mapping(source = "devuelto", target = "devuelto")
    @Mapping(source = "mora", target = "mora")
    PrestamoDetalleSaveDto toPrestamoDetalleSaveDto(PrestamoDetalle detalle);

    List<PrestamoDetalleSaveDto> toPrestamoDetalleSaveDtos(List<PrestamoDetalle> detalles);

    @Mapping(target = "estado", ignore = true)
	@Mapping(target = "fechaRegistro", ignore = true)
	@Mapping(target = "libro", ignore = true)
	@Mapping(target = "prestamo", ignore = true)
	@InheritInverseConfiguration
    PrestamoDetalle toPrestamoDetalle(PrestamoDetalleSaveDto detalleSaveDto);

}
