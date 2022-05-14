package Peroli.Practica_Final.repository;

import Peroli.Practica_Final.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPedido extends CrudRepository<Pedido, Long> {


}
