package com.app.rest.orden_api.Service;

import java.util.List;

import com.app.rest.orden_api.Model.Producto;
import com.app.rest.orden_api.dto.ProductoDto;

public interface IProductoService {
    
    
    public List<ProductoDto> Listar();


    public Producto buscarPorId(Integer id);


    public Producto guardar(Producto producto);


    public ProductoDto guardar(ProductoDto dto);


    public Producto eliminar(Producto producto);    

    
}
