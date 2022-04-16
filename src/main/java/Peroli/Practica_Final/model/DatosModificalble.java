package Peroli.Practica_Final.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Data
public class DatosModificalble {

    private int personas;
    private int arroz;
    private LocalDate fecha;
    private Momento momento;
    private String ciudad;
    private String dir1;
    private BigDecimal precio;
    private Estado estado;
}
