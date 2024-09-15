package com.app.rest.orden_api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rest.orden_api.Mapper.ProductoMapper;
import com.app.rest.orden_api.Model.Producto;
import com.app.rest.orden_api.Service.IProductoService;
import com.app.rest.orden_api.dto.CrudProductoDto;
import com.app.rest.orden_api.dto.ProductoDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;







@RestController
@RequestMapping("/")
public class ProductoController {
    

    @Autowired
    private IProductoService productoService;

    @GetMapping({"productos"})
    public List<CrudProductoDto> getAll()
    {
        
        
        return productoService.Listar();
    }
    
    @GetMapping("producto/{id}")
    public ResponseEntity<CrudProductoDto> getPorId(@PathVariable Integer id) {
        
        //creo el objeto producto con los datos del id que coincida.
        Producto producto = productoService.buscarPorId(id);
        
        //Se fija si el producto por id no existe o si no esta activo
        if( producto == null || !producto.isEstaActivo() ){
            //En caso de cumplise el relacional notifica que no se encuentra.
            return ResponseEntity.notFound().build();
        }
        
        //Si lo encuentra, crea un dto con los datos de producto.
        CrudProductoDto dto = ProductoMapper.toDto(producto);

        //Devuelve un Ok con el dto
        return ResponseEntity.ok(dto); 
    }

    @PostMapping("registrar_producto")
    public CrudProductoDto guarardar(@RequestBody CrudProductoDto dto){
        return productoService.guardar(dto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<CrudProductoDto> actualizar(@PathVariable Integer id, @RequestBody CrudProductoDto dto) {
        Producto producto = productoService.buscarPorId(id);
        
        // Si el producto no existe, devuelve una respuesta 404 (not found)
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
    
        // Asigno los valores del DTO al objeto Producto
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecioUnitario(dto.getPrecioUnitario());
        producto.setEstaActivo(dto.isEstaActivo());
    
        //Guardo el producto actualizado
        Producto productoActualizado = productoService.guardar(producto);
        
        // Convierto el producto actualizado a DTO para devolverlo en la respuesta
        CrudProductoDto productoDtoActualizado = ProductoMapper.toDto(productoActualizado);
        
        return ResponseEntity.ok(productoDtoActualizado);
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Integer id) {
        Producto producto = productoService.buscarPorId(id);
        
        
        if (producto == null || producto.isEstaActivo() == false ) {
            return ResponseEntity.notFound().build();
        }
    
        producto.setEstaActivo(false);
    
        
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    

    
    
    
    

}
