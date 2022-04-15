package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.DatosModificalble;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.repository.RepositoryPeroli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ServicePedidoImpl implements ServicePedidos {
    @Autowired
    private RepositoryPeroli repositoryPeroli;

    @Override
    public boolean AddPedido(Pedido pedido){
        //añade al repository y devuelvo true si ha funcionado
        repositoryPeroli.save(pedido);
        return true;
    }

    @Override
    public boolean DeletePedido(long id){
        //borra del repository y devuelvo true si ha funcionado
        Optional<Pedido> pedido1 = repositoryPeroli.findById(id); //throws exception if not found. Queda implementar
        if (pedido1.isEmpty()){
            return false;
        }

        Pedido pedido = pedido1.get();
        repositoryPeroli.delete(pedido);
        return true;
    }

    @Override
    public boolean UpdatePedido(long id, DatosModificalble datos){
        //actualiza repository y devuelvo true si ha funcionado
        Optional<Pedido> pedido1 = repositoryPeroli.findById(id); //throws exception if not found. Queda implementar
        if (pedido1.isEmpty()){
            return false;
        }

        Pedido pedido = pedido1.get();
        pedido.setPersonas(datos.getPersonas());
        pedido.setArroz(datos.getArroz());
        pedido.setDate(datos.getDate());
        pedido.setMomento(datos.getMomento());
        pedido.setCiudad(datos.getCiudad());
        pedido.setDir1(datos.getDir1());

        pedido.setPrecio(datos.getPrecio());
        pedido.setEstado(datos.getEstado());
        repositoryPeroli.save(pedido);

        return true;
    }

    @Override
    public ArrayList<Pedido> GetPedidos(){
        //busca todos los pedidos en repository y devuelvo la lista
        return (ArrayList<Pedido>) repositoryPeroli.findAll();
    }

}
