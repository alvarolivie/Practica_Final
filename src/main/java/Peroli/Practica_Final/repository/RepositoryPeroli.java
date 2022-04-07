package Peroli.Practica_Final.repository;

import Peroli.Practica_Final.model.DatosModificalble;
import Peroli.Practica_Final.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import java.util.ArrayList;

@Repository
public interface RepositoryPeroli extends CrudRepository<Pedido, Long> {


}
