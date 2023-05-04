package com.pirqana.bookrental.application.dto.prestamo.mapper;

import com.pirqana.bookrental.application.dto.prestamo.PrestamoDto;
import com.pirqana.bookrental.application.dto.solicitante.mapper.SolicitanteMapper;
import com.pirqana.bookrental.domain.entity.Prestamo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SolicitanteMapper.class, PrestamoDetalleMapper.class})
public interface PrestamoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fechaPrestamo", target = "fechaPrestamo")
    @Mapping(source = "fechaDevolucion", target = "fechaDevolucion")
    @Mapping(source = "estadoPrestamo", target = "estadoPrestamo")
    @Mapping(source = "solicitante", target = "solicitante")
    @Mapping(source = "detalles", target = "detalles")
    @Mapping(source = "fechaRegistro", target = "fechaRegistro")
    @Mapping(source = "estado", target = "estado")
    PrestamoDto toPrestamoDto(Prestamo prestamo);

    List<PrestamoDto> toPrestamoDtos(List<Prestamo> prestamos);

    @Mapping(target = "idSolicitante", ignore = true)
	@InheritInverseConfiguration
    Prestamo toPrestamo(PrestamoDto prestamoDto);
}
