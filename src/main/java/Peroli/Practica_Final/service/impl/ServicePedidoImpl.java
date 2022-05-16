package Peroli.Practica_Final.service.impl;

import Peroli.Practica_Final.model.DatosModificalble;
import Peroli.Practica_Final.model.Estado;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.repository.RepositoryPedido;
import Peroli.Practica_Final.service.ServicePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicePedidoImpl implements ServicePedidos {
    @Autowired
    private RepositoryPedido repositoryPedido;

    @Override
    public void AddPedido(Pedido pedido){
        //añade al repository y devuelvo true si ha funcionado
        pedido.setEstado(Estado.PENDIENTE);
        repositoryPedido.save(pedido);
    }

    @Override
    public boolean DeletePedido(Long id){
        //borra del repository y devuelvo true si ha funcionado
        Optional<Pedido> pedido1 = repositoryPedido.findById(id); //throws exception if not found. Queda implementar
        if (pedido1.isEmpty()){
            return false;
        }

        Pedido pedido = pedido1.get();
        repositoryPedido.delete(pedido);
        return true;
    }

    @Override
    public boolean UpdatePedido(Long id, DatosModificalble datos){
        //actualiza repository y devuelvo true si ha funcionado
        Optional<Pedido> pedido1 = repositoryPedido.findById(id); //throws exception if not found. Queda implementar
        if (pedido1.isEmpty()){
            return false;
        }

        Pedido pedido = pedido1.get();
        pedido.setPersonas(datos.getPersonas());
        pedido.setPrecio(datos.getPrecio());
        pedido.setEstado(datos.getEstado());
        repositoryPedido.save(pedido);

        return true;
    }

    @Override
    public ArrayList<Pedido> GetPedidos(){
        //busca todos los pedidos en repository y devuelvo la lista
        return (ArrayList<Pedido>) repositoryPedido.findAll();
    }

    @Override
    public Pedido GetPedido(Long id) {
        Optional<Pedido> pedido1 = repositoryPedido.findById(id); //throws exception if not found. Queda implementar
        Pedido pedido = null;
        if (!pedido1.isEmpty()){
            pedido = pedido1.get();
        }
        return pedido;
        
    }

}
