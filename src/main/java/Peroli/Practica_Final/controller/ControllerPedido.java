package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.service.ServicePedidoImpl;
import Peroli.Practica_Final.service.ServicePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ControllerPedido {

    @Autowired
    private ServicePedidos servicePedidos;

    @PostMapping("cliente/newPedido")
    @ResponseStatus(HttpStatus.OK)
    public String AddPedido(@Valid @RequestBody Pedido pedido){
        servicePedidos.AddPedido(pedido);
        return pedido.toString();
    }
}
