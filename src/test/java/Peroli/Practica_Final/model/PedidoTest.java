package Peroli.Practica_Final.model;


import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoTest {

    @Test
    public void controlFecha(){
        Pedido pedido= new @Valid Pedido(Long.valueOf("4"),"ale@gmail.com","Alejandra","666666666",6,1, LocalDate.of(2019, 1, 1),Momento.CENA,"Madrid","Serrano 14", BigDecimal.valueOf(0.0),Estado.ACEPTADA);
        Assertions.assertEquals(false, pedido.validar());
    }



    @Test
    public void controlTelf(){
        Pedido pedido= new @Valid Pedido(Long.valueOf("4"),"ale@gmail.com","Alejandra","6666676666666",6,1, LocalDate.of(2019, 1, 1),Momento.CENA,"Madrid","Serrano 14", BigDecimal.valueOf(0.0),Estado.ACEPTADA);

        Assertions.assertEquals(false, pedido.validar());
    }

    @Test
    public void controlNombre(){
        Pedido pedido= new @Valid Pedido(Long.valueOf("4"),"ale@gmail.com","Al","666666666",6,1, LocalDate.of(2019, 1, 1),Momento.CENA,"Madrid","Serrano 14", BigDecimal.valueOf(0.0),Estado.ACEPTADA);

        Assertions.assertEquals(false, pedido.validar());
    }

    @Test
    public void controlDir(){
        Pedido pedido= new @Valid Pedido(Long.valueOf("4"),"ale@gmail.com","Alejandra","666666666",6,1, LocalDate.of(2019, 1, 1),Momento.CENA,"Madrid","Syu", BigDecimal.valueOf(0.0),Estado.ACEPTADA);

        Assertions.assertEquals(false, pedido.validar());
    }

    @Test
    public void controlNumPersonas(){
        Pedido pedido= new @Valid Pedido(Long.valueOf("4"),"ale@gmail.com","Alejandra","666666666",2,1, LocalDate.of(2019, 1, 1),Momento.CENA,"Madrid","Serrano 14", BigDecimal.valueOf(0.0),Estado.ACEPTADA);

        Assertions.assertEquals(false, pedido.validar());
    }

    @Test
    public void controlAllOk(){
        Pedido pedido= new @Valid Pedido(Long.valueOf("4"),"ale@gmail.com","Alejandra","626298810",12,1, LocalDate.of(2023, 1, 1),Momento.CENA,"Madrid","Calle Serrano 14", BigDecimal.valueOf(0.0),Estado.ACEPTADA);
        Assertions.assertEquals(true,pedido.validar());
    }
}
