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

import Cubillas_Emmanuelli.model.Cliente;
import Cubillas_Emmanuelli.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClienteController {

    @Autowired
    private ClienteRepository clienRepo;

    @GetMapping("/cliente/traer")
    public List<Cliente> traerClientes() {
        return clienRepo.findAll() ;
    }

    @GetMapping("/cliente/traer/{id}")
    public Optional<Cliente>  traerUnCliente(@PathVariable Long id) {
        return clienRepo.findById(id);
    }
    

    @PostMapping("/cliente/crear")
    public void crearCliente(@RequestBody Cliente c) {
        clienRepo.save(c);
    }

    @DeleteMapping("/cliente/borrar/{id}")
    public String  borrarUnCliente(@PathVariable Long id) {
        clienRepo.deleteById(id);
        return "cliente eliminado correctamente";
    }

    @PutMapping("/cliente/actualizar/{id}")
    public String actualizarUnCliente(@PathVariable Long id, @RequestBody Cliente c) {
        
        Cliente clienteBuscado = clienRepo.findById(id).get();
    
        clienteBuscado.setNombre(c.getNombre());
        clienteBuscado.setApellido(c.getApellido());
        clienteBuscado.setTelefono(c.getTelefono());
        clienteBuscado.setEmail(c.getEmail());
        
        clienRepo.save(clienteBuscado);
        
        return "Datos del cliente actualizados correctamente";
}   
        
}
