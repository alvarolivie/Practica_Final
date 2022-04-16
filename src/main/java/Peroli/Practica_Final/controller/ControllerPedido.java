package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.service.ServicePedidoImpl;
import Peroli.Practica_Final.service.ServicePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("elPeroli/v1/cliente")
public class ControllerPedido {

    @Autowired
    private ServicePedidos servicePedidos;

    @PostMapping("/newPedido")
    public ResponseEntity<Pedido> AddPedido(@Valid @RequestBody Pedido pedido){
        servicePedidos.AddPedido(pedido);
        return ResponseEntity.ok().body(pedido);
    }
}
