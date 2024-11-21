package Cubillas_Emmanuelli.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Cubillas_Emmanuelli.model.Producto;
import Cubillas_Emmanuelli.repository.ProductoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ProductoController {

    @Autowired
    private ProductoRepository producRepo;

    @GetMapping("/producto/traer")
    public List<Producto> traerProductos() {
        return producRepo.findAll() ;
    }

    @GetMapping("/producto/traer/{id}")
    public Optional<Producto> traerUnProducto(@PathVariable Long id) {
        return producRepo.findById(id);
    }
    

    @PostMapping("/producto/crear")
    public void crearProducto(@RequestBody Producto p) {
        producRepo.save(p);
    }

    @DeleteMapping("/producto/borrar/{id}")
    public String  borrarUnProducto(@PathVariable Long id) {
        producRepo.deleteById(id);
        return "producto eliminado correctamente";
    }

    @PutMapping("/producto/actualizar/{id}")
    public String actualizarUnProducto(@PathVariable Long id, @RequestBody Producto p) {
        
        Producto productoBuscado = producRepo.findById(id).get();
    
        productoBuscado.setNombreproducto(p.getNombreproducto());
        productoBuscado.setTalle(p.getTalle());
        productoBuscado.setColor(p.getColor());
        productoBuscado.setPrecio(p.getPrecio());
        
        producRepo.save(productoBuscado);
        
        return "Datos del producto actualizados correctamente";
}   
        
}

