package Peroli.Practica_Final.repository;

import Peroli.Practica_Final.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends CrudRepository<User, Long> {
}
