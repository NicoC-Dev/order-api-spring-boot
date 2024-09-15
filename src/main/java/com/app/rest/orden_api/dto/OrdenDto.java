package com.app.rest.orden_api.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
public class OrdenDto {
    private LocalDate fechaCreacion;
    private LocalTime horaCreacion;
    private Double total;
    
    private List<DetalleOrdenDto> detalles;
}
