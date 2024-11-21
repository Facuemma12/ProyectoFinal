package Cubillas_Emmanuelli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cubillas_Emmanuelli.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{

}
