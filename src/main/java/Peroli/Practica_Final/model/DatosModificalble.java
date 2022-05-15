package Peroli.Practica_Final.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Data
public class DatosModificalble {

    private int personas;
    private BigDecimal precio;
    private Estado estado;
}
