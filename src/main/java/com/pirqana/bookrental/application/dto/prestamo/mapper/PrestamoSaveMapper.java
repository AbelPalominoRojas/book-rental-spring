package com.pirqana.bookrental.application.dto.prestamo.mapper;

import com.pirqana.bookrental.application.dto.prestamo.PrestamoSaveDto;
import com.pirqana.bookrental.domain.entity.Prestamo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PrestamoDetalleSaveMapper.class})
public interface PrestamoSaveMapper {

    @Mapping(source = "fechaPrestamo", target = "fechaPrestamo")
    @Mapping(source = "fechaDevolucion", target = "fechaDevolucion")
    @Mapping(source = "estadoPrestamo", target = "estadoPrestamo")
    @Mapping(source = "idSolicitante", target = "idSolicitante")
    @Mapping(source = "detalles", target = "detalles")
    PrestamoSaveDto toPrestamoSaveDto(Prestamo prestamo);

    List<PrestamoSaveDto> toPrestamoSaveDtoList(List<Prestamo> prestamos);

    @Mapping(target = "estado", ignore = true)
	@Mapping(target = "fechaRegistro", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "solicitante", ignore = true)
	@InheritInverseConfiguration
    Prestamo toPrestamo(PrestamoSaveDto prestamoSaveDto);
}
