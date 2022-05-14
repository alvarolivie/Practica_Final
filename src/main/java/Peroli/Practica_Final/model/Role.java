package Peroli.Practica_Final.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class Role {
    @Id
    private Long roleId;
    private String name;
    private String description;
}
