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

import Cubillas_Emmanuelli.model.Empleado;
import Cubillas_Emmanuelli.repository.EmpleadoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleRepo;

    @GetMapping("/empleado/traer")
    public List<Empleado> traerEmpleados() {
        return empleRepo.findAll() ;
    }

    @GetMapping("/empleado/traer/{id}")
    public Optional<Empleado>  traerUnEmpleado(@PathVariable Long id) {
        return empleRepo.findById(id);
    }
    

    @PostMapping("/empleado/crear")
    public void crearEmpleado(@RequestBody Empleado e) {
        empleRepo.save(e);
    }

    @DeleteMapping("/empleado/borrar/{id}")
    public String  borrarUnEmpleado(@PathVariable Long id) {
        empleRepo.deleteById(id);
        return "empleado eliminado correctamente";
    }

    @PutMapping("/empleado/actualizar/{id}")
    public String actualizarUnEmpleado(@PathVariable Long id, @RequestBody Empleado e) {
        
        Empleado empleadoBuscado = empleRepo.findById(id).get();
    
        empleadoBuscado.setNombre(e.getNombre());
        empleadoBuscado.setApellido(e.getApellido());
        empleadoBuscado.setTelefono(e.getTelefono());
        empleadoBuscado.setLegajo(e.getLegajo());
        
        empleRepo.save(empleadoBuscado);
        
        return "Datos del empleado actualizados correctamente";
}   
        
}
