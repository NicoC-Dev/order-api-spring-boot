package com.app.rest.orden_api.dto;

import lombok.Data;

@Data
public class ProductoDto {
    
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private boolean estaActivo;

}
