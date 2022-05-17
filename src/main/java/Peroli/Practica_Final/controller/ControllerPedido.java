package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.service.ServicePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("elPeroli/v1/cliente")
public class ControllerPedido {

    @Autowired
    private ServicePedidos servicePedidos;

    @PostMapping("/newPedido")
    public ResponseEntity<Pedido> addPedido(@Valid @RequestBody Pedido pedido){
        System.err.println("AQUI");
        servicePedidos.AddPedido(pedido);
        return ResponseEntity.ok().body(pedido);
    }
}
