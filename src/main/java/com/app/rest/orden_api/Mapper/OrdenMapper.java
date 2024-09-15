package com.app.rest.orden_api.Mapper;

import java.util.List;
import java.util.stream.Collectors;



import com.app.rest.orden_api.Model.DetalleOrden;
import com.app.rest.orden_api.Model.Orden;
import com.app.rest.orden_api.Model.Producto;
import com.app.rest.orden_api.dto.DetalleOrdenDto;
import com.app.rest.orden_api.dto.OrdenDto;
import com.app.rest.orden_api.dto.ProductoDto;

public class OrdenMapper {

    public static OrdenDto toDto(Orden orden) {  // Cambia a static
        OrdenDto ordenDto = new OrdenDto();
    
        ordenDto.setTotal(orden.getTotal());
        ordenDto.setFechaCreacion(orden.getFechaCreacion());
        ordenDto.setHoraCreacion(orden.getHoraCreacion());
        
        List<DetalleOrdenDto> detallesDto = orden.getDetalleOrden().stream()
            .map(OrdenMapper::toDetalleOrdenDto)
            .collect(Collectors.toList());
    
        ordenDto.setDetalles(detallesDto);
        return ordenDto;
    }
    
    public static DetalleOrdenDto toDetalleOrdenDto(DetalleOrden detalleOrden) {  // Cambia a static
        DetalleOrdenDto detalleOrdenDto = new DetalleOrdenDto();
    
        detalleOrdenDto.setCantidad(detalleOrden.getCantidad());
        detalleOrdenDto.setSubtotal(detalleOrden.getSubtotal());
    
        ProductoDto productoDto = toProductoDto(detalleOrden.getProducto());
        detalleOrdenDto.setProducto(productoDto);
    
        return detalleOrdenDto;
    }
    
    public static ProductoDto toProductoDto(Producto producto) {  // Cambia a static
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(producto.getId());
    
        return productoDto;
    }
    
    public static Orden toEntity(OrdenDto dto)
    {
        Orden orden = new Orden();

        orden.setTotal(dto.getTotal());
        orden.setFechaCreacion(dto.getFechaCreacion());
        orden.setHoraCreacion(dto.getHoraCreacion());
        
         List<DetalleOrden> detalles = dto.getDetalles().stream()
            .map(OrdenMapper::toDetalleOrdenEntity)
            .collect(Collectors.toList());

        orden.setDetalleOrden(detalles);
        return orden;
    }

    public static DetalleOrden toDetalleOrdenEntity(DetalleOrdenDto dto)
    {
        DetalleOrden detalleOrden = new DetalleOrden();

        detalleOrden.setCantidad(dto.getCantidad());
        detalleOrden.setSubtotal(dto.getSubtotal());
        
        Producto producto = toProductoEntity(dto.getProducto());
        detalleOrden.setProducto(producto);

        return detalleOrden;
    }

    public static Producto toProductoEntity(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setId(productoDto.getId());


        return producto;
    }

}
