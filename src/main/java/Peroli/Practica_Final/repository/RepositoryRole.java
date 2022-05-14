package Peroli.Practica_Final.repository;

import Peroli.Practica_Final.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRole extends CrudRepository<Role, Long> {
}
