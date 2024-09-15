package com.app.rest.orden_api.Mapper;

import com.app.rest.orden_api.Model.Producto;
import com.app.rest.orden_api.dto.CrudProductoDto;


public class ProductoMapper {

    public static CrudProductoDto toDto(Producto producto){
        CrudProductoDto dto = new CrudProductoDto();
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecioUnitario(producto.getPrecioUnitario());
        dto.setEstaActivo(producto.isEstaActivo());
        return dto;
    }

    public static Producto toEntity(CrudProductoDto dto){
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecioUnitario(dto.getPrecioUnitario());
        producto.setEstaActivo(dto.isEstaActivo());
        return producto;
    }
    
}
