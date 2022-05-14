package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.DatosModificalble;
import Peroli.Practica_Final.model.Estado;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.repository.RepositoryPeroli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicePedidoImpl implements ServicePedidos {
    @Autowired
    private RepositoryPeroli repositoryPeroli;

    @Override
    public void AddPedido(Pedido pedido){
        //añade al repository y devuelvo true si ha funcionado
        pedido.setEstado(Estado.PENDIENTE);
        repositoryPeroli.save(pedido);
    }

    @Override
    public boolean DeletePedido(Long id){
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
    public boolean UpdatePedido(Long id, DatosModificalble datos){
        //actualiza repository y devuelvo true si ha funcionado
        Optional<Pedido> pedido1 = repositoryPeroli.findById(id); //throws exception if not found. Queda implementar
        if (pedido1.isEmpty()){
            return false;
        }

        Pedido pedido = pedido1.get();
        pedido.setPersonas(datos.getPersonas());
        pedido.setArroz(datos.getArroz());
        pedido.setFecha(datos.getFecha());
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

    @Override
    public Pedido GetPedido(Long id) {
        Optional<Pedido> pedido1 = repositoryPeroli.findById(id); //throws exception if not found. Queda implementar
        Pedido pedido = null;
        if (!pedido1.isEmpty()){
            pedido = pedido1.get();
        }
        return pedido;
        
    }

}
