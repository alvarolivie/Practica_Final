package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.DatosModificalble;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.service.ServicePedidoImpl;
import Peroli.Practica_Final.service.ServicePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController()
@RequestMapping("elPeroli/v1/owner")
public class ControllerOwner {

    @Autowired
    private ServicePedidos servicePedidos; //me he quedado aqui. Falta implementar el repository y validar. check errores de todo

    @GetMapping("/viewPedidos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ArrayList<Pedido>> GetPedidos() {
        return ResponseEntity.ok().body(servicePedidos.GetPedidos());
    }

    @PutMapping("/updatePedido/{id}")
    public ResponseEntity<Pedido> UpadatePedido(@PathVariable(value = "id") Long id, @Valid @RequestBody DatosModificalble datosModificalble) {
        servicePedidos.UpdatePedido(id, datosModificalble);
        Pedido pedido = servicePedidos.GetPedido(id);
        return ResponseEntity.ok().body(pedido);
    }

    @DeleteMapping("/deletePedido/{id}")
    public ResponseEntity<Long> DeletePedido(@PathVariable(value = "id") Long id) {
        servicePedidos.DeletePedido(id);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping("/newPedido")
    public ResponseEntity<Pedido> AddPedido(@Valid @RequestBody Pedido pedido){
        servicePedidos.AddPedido(pedido);
        return ResponseEntity.ok().body(pedido);
    }
}
