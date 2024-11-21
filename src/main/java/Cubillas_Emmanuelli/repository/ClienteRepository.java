package Cubillas_Emmanuelli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cubillas_Emmanuelli.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}
