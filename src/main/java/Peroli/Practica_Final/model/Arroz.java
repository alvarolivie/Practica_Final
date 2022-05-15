package Peroli.Practica_Final.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("ARROCES")
public class Arroz {

    @Id
    private Long riceId;
    private String name;
    private String description;
    @Column("INGREDIENTS_PER_PERSON")
    private String ingredients;


}
