package Peroli.Practica_Final.model;


import lombok.Builder;
import lombok.Data;
import lombok.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Optional;

@Data
public class Pedido {

    @Id
    private Long id;
    private String email;
    private String fullname;
    private String tel;
    private int personas;
    private int arroz;
    private LocalDate fecha;
    private Momento momento;
    private String ciudad;
    private String dir1;
    @Embedded.Nullable
    private BigDecimal precio;
    private Estado estado = Estado.PENDIENTE;

}
