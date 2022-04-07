package Peroli.Practica_Final.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DatosModificalble {

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
