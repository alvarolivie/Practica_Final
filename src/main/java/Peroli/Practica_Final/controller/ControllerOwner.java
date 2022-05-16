package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.DatosModificalble;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.model.User;
import Peroli.Practica_Final.service.ServicePedidos;
import Peroli.Practica_Final.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController()
@RequestMapping("elPeroli/v1/owner")
public class ControllerOwner {

    @Autowired
    private ServicePedidos servicePedidos; //me he quedado aqui. Falta implementar el repository y validar. check errores de todo

    @Autowired
    private ServiceUser serviceUser;


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

    @PostMapping("/checkCredentials")
    public ResponseEntity<Boolean> checkCredential(@RequestBody User user){
        Boolean b=serviceUser.checkCredentials(user);
        if (b==true){
            return ResponseEntity.ok().body(b);
        }else{
            return ResponseEntity.badRequest().body(b);
        }
    }

    @GetMapping("/getRoles/{username}")
    public ResponseEntity<ArrayList<Long>> getRoles(@PathVariable(value = "username") String username){
        ArrayList<Long> roles= serviceUser.getRoles(username);
        return ResponseEntity.ok().body(roles);

    }


}
