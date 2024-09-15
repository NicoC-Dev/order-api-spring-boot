package com.app.rest.orden_api.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rest.orden_api.Mapper.ProductoMapper;
import com.app.rest.orden_api.Model.Producto;
import com.app.rest.orden_api.Repository.ProductoRepository;
import com.app.rest.orden_api.dto.CrudProductoDto;


@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public List<CrudProductoDto> Listar() {
        List<Producto> productos = productoRepository.findByEstaActivo(true);
        return productos.stream().map(ProductoMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }


    @Override
    public CrudProductoDto guardar(CrudProductoDto dto) {
        Producto producto = ProductoMapper.toEntity(dto);
        return ProductoMapper.toDto(productoRepository.save(producto));
    }


    @Override
    public Producto eliminar(Producto producto) {
        producto.setEstaActivo(false);

        return productoRepository.save(producto);
    }


    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    
}
