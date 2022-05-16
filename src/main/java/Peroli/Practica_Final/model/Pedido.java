package Peroli.Practica_Final.model;


import lombok.Builder;
import lombok.Data;
import lombok.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Optional;

@Data
public class Pedido {

    @Id
    private Long id;

    @Email
    private String email;

    @Size(min=3,max=30)
    private String fullname;

    @Size(min=9,max=12)
    private String tel;

    @Min(5)
    @Max(50)
    private int personas;


    private int arroz;

    @DateTimeFormat(pattern="mm/dd/yyyy")
    @Future
    private LocalDate fecha;

    private Momento momento;

    private String ciudad;

    @Size(min=5,max=40)
    private String dir1;

    private BigDecimal precio = BigDecimal.valueOf(0);
    private Estado estado = Estado.PENDIENTE;

}
