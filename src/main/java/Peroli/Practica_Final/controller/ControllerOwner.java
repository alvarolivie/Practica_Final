package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.DatosModificalble;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.service.ServicePedidoImpl;
import Peroli.Practica_Final.service.ServicePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController()
public class ControllerOwner {

    @Autowired
    private ServicePedidos servicePedidos; //me he quedado aqui. Falta implementar el repository y validar. check errores de todo

    @GetMapping("owner/viewPedidos")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Pedido> GetPedidos() {
        return servicePedidos.GetPedidos();
    }

    @PutMapping("owner/updatePedido/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpadatePedido(@PathVariable(value = "id") long id, @Valid @RequestBody DatosModificalble datosModificalble) {
        servicePedidos.UpdatePedido(id, datosModificalble);
        return "";
    }

    @DeleteMapping("owner/deletePedido/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeletePedido(@PathVariable(value = "id") long id) {
        servicePedidos.DeletePedido(id);
        return "usuario borrado";
    }

    @PostMapping("owner/newPedido")
    @ResponseStatus(HttpStatus.OK)
    public String AddPedido(@Valid @RequestBody Pedido pedido){
        servicePedidos.AddPedido(pedido);
        return pedido.toString();
    }
}
