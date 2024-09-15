package com.app.rest.orden_api.Service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import com.app.rest.orden_api.Mapper.OrdenMapper;
import com.app.rest.orden_api.Model.DetalleOrden;
import com.app.rest.orden_api.Model.Orden;
import com.app.rest.orden_api.Model.Producto;

import com.app.rest.orden_api.Repository.OrdenRepository;
import com.app.rest.orden_api.Repository.ProductoRepository;

import com.app.rest.orden_api.dto.OrdenDto;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class OrdenService implements IOrdenService {

    
    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<OrdenDto> Listar() {
        
        List<Orden> ordenes = ordenRepository.findAll();
        
        return ordenes.stream().map(OrdenMapper::toDto).collect(Collectors.toList()); 
    }

    @Override
    public OrdenDto guardar(OrdenDto dto){
        
        Orden orden = OrdenMapper.toEntity(dto);
        for (DetalleOrden detalle : orden.getDetalleOrden()) {
            Producto producto = productoRepository.findById(detalle.getProducto().getId())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            detalle.setOrden(orden);
            detalle.setProducto(producto);
            detalle.setSubtotal(producto.getPrecioUnitario() * detalle.getCantidad());



            
        }
        orden.setFechaCreacion(LocalDate.now());
        orden.setHoraCreacion(LocalTime.now());
        orden.setTotal(orden.getDetalleOrden().stream()
        .mapToDouble(DetalleOrden::getSubtotal).sum());

        Orden ordenNueva = ordenRepository.save(orden);

        return OrdenMapper.toDto(ordenNueva);
    }

    
    




}
