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

import Cubillas_Emmanuelli.model.Venta;
import Cubillas_Emmanuelli.repository.VentaRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class VentaController {

    @Autowired
    private VentaRepository ventaRepo;

    @GetMapping("/venta/traer")
    public List<Venta> traerVentas() {
        return ventaRepo.findAll() ;
    }

    @GetMapping("/venta/traer/{id}")
    public Optional<Venta> traerUnaVenta(@PathVariable Long id) {
        return ventaRepo.findById(id);
    }
    

    @PostMapping("/venta/crear")
    public void crearVenta(@RequestBody Venta v) {
        ventaRepo.save(v);
    }

    @DeleteMapping("/venta/borrar/{id}")
    public String  borrarUnaVenta(@PathVariable Long id) {
        ventaRepo.deleteById(id);
        return "venta eliminada correctamente";
    }

    @PutMapping("/venta/actualizar/{id}")
    public String actualizarUnaVenta(@PathVariable Long id, @RequestBody Venta v) {
        
        Venta ventaBuscada = ventaRepo.findById(id).get();
    
        ventaBuscada.setPrecio(v.getPrecio());
        ventaBuscada.setStock(v.getStock());
        ventaBuscada.setCantidadvendida(v.getCantidadvendida());
        
        ventaRepo.save(ventaBuscada);
        
        return "Datos de las ventas actualizados correctamente";
}   
        
}


