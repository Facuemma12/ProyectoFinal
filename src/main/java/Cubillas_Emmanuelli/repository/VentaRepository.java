package Cubillas_Emmanuelli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cubillas_Emmanuelli.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long>{

}
