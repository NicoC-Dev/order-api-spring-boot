package com.app.rest.orden_api.dto;


import lombok.Data;

@Data
public class DetalleOrdenDto {
    private OrdenDto orden;
    private ProductoDto producto;
    private Integer cantidad;
    private Double subtotal;
}
