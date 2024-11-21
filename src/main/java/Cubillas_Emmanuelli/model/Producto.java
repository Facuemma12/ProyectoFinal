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
@Table(name = "productos")
@Getter @Setter
@NoArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    @Column(name = "nombre", nullable = false)
    private String nombreproducto;
    private int talle;
    private String color;
    private double precio;

    public Producto(String nombreproducto, int talle, String color, double precio) {
        this.nombreproducto = nombreproducto;
        this.talle = talle;
        this.color = color;
        this.precio = precio;
    } 
  
}

