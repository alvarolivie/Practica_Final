package Peroli.Practica_Final.model;


import lombok.Data;
import lombok.Generated;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import java.time.LocalDate;

import java.util.ArrayList;

@Data
public class Pedido {

    @Id
    private Long id;
    private Email email;
    private String fullname;
    private String tel;
    private int personas;
    private int arroz;
    private LocalDate date;
    private Momento momento;
    private String ciudad;
    private String dir1;
    private String dir2;
    private double precio;
    private Estado estado;

}
