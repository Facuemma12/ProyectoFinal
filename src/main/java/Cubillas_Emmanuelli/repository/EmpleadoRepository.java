package Cubillas_Emmanuelli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cubillas_Emmanuelli.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long>{

}
