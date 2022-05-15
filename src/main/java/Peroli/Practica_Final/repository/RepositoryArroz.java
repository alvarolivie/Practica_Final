package Peroli.Practica_Final.repository;

import Peroli.Practica_Final.model.Arroz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryArroz extends CrudRepository<Arroz,Long> {
}
