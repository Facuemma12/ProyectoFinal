package Cubillas_Emmanuelli.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@Getter @Setter
@NoArgsConstructor
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    private String apellido;
    private int legajo;
    private String telefono;

    public Empleado(String nombre, String apellido, int legajo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.telefono = telefono;
    } 

}

