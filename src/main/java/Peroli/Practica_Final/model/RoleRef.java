package Peroli.Practica_Final.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("USER_ROLE")
@AllArgsConstructor
public class RoleRef {

    private Long roleId;
}
