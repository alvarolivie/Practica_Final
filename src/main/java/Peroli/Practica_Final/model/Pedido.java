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
@Builder
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

    @Future
    private LocalDate fecha;

    private Momento momento;

    private String ciudad;

    @Size(min=5,max=40)
    private String dir1;

    private BigDecimal precio = BigDecimal.valueOf(0);
    private Estado estado = Estado.PENDIENTE;


   /* public Pedido(Long id, String email, String fullname, String tel, int personas, int arroz, LocalDate fecha, Momento momento, String ciudad, String dir1) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.tel = tel;
        this.personas = personas;
        this.arroz = arroz;
        this.fecha = fecha;
        this.momento = momento;
        this.ciudad = ciudad;
        this.dir1 = dir1;
    }

    public Pedido(Long id, String email, String fullname, String tel, int personas, int arroz, LocalDate fecha, Momento momento, String ciudad, String dir1, BigDecimal precio, Estado estado) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.tel = tel;
        this.personas = personas;
        this.arroz = arroz;
        this.fecha = fecha;
        this.momento = momento;
        this.ciudad = ciudad;
        this.dir1 = dir1;
        this.precio = precio;
        this.estado = estado;
    }*/

    public boolean validar() {
        boolean fin=false;
        if(this.getFecha().isAfter(LocalDate.now())){
            if(this.getPersonas()>=5 && this.getPersonas()<=50){
                if(this.getDir1().length()>=5 && this.getDir1().length()<=40){
                    if(this.getFullname().length()>=3 && this.getFullname().length()<=30){
                        if(this.getTel().length()>=9 && this.getDir1().length()<=12){
                            fin=true;
                        }

                    }
                }
            }
        }
       return fin;
    }

}
