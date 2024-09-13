package com.app.rest.orden_api.Mapper;

import com.app.rest.orden_api.Model.Producto;
import com.app.rest.orden_api.dto.ProductoDto;

public class ProductoMapper {

    public static ProductoDto toDto(Producto producto){
        ProductoDto dto = new ProductoDto();
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecioUnitario(producto.getPrecioUnitario());
        dto.setEstaActivo(producto.isEstaActivo());
        return dto;
    }

    public static Producto toEntity(ProductoDto dto){
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecioUnitario(dto.getPrecioUnitario());
        producto.setEstaActivo(dto.isEstaActivo());
        return producto;
    }
    
}
