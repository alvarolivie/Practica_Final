package Peroli.Practica_Final.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    @Id
    private String username;
    private String password;

    @MappedCollection(idColumn = "USERNAME")
    private Set<RoleRef> roles = new HashSet<>();

    public void addRoles(Role role) {
        roles.add(new RoleRef(role.getRoleId()));
    }
}
