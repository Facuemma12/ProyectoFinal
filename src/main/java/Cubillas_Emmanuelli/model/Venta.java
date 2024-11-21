package Cubillas_Emmanuelli.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ventas")
@Getter @Setter
@NoArgsConstructor
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id_venta;
    //private Long id_cliente;
    //private Long id_empleado;
    //private Long id_producto;

    @Column(name = "nombre", nullable = false)
    private int stock;
    private int cantidadvendida;
    private String color;
    private double precio;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Venta(int stock, int cantidadvendida, String color, double precio, Cliente cliente) {
        this.stock = stock;
        this.cantidadvendida = cantidadvendida;
        this.color = color;
        this.precio = precio;
        this.cliente = cliente;
    }

    
    
    }
    

