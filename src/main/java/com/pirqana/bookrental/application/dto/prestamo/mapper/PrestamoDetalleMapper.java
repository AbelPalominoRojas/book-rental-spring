package com.pirqana.bookrental.application.dto.prestamo.mapper;

import com.pirqana.bookrental.application.dto.libro.mapper.LibroMapper;
import com.pirqana.bookrental.application.dto.prestamo.PrestamoDetalleDto;
import com.pirqana.bookrental.domain.entity.PrestamoDetalle;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LibroMapper.class})
public interface PrestamoDetalleMapper {
    @Mapping(source = "libro", target = "libro")
    @Mapping(source = "devuelto", target = "devuelto")
    @Mapping(source = "mora", target = "mora")
    @Mapping(source = "fechaRegistro", target = "fechaRegistro")
    @Mapping(source = "estado", target = "estado")
    PrestamoDetalleDto toPrestamoDetalleDto(PrestamoDetalle prestamoDetalle);

    List<PrestamoDetalleDto> toPrestamoDetalleDtos(List<PrestamoDetalle> detalles);

    @InheritInverseConfiguration
    PrestamoDetalle toPrestamoDetalle(PrestamoDetalleDto detalleDto);
}
