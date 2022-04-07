package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.DatosModificalble;
import Peroli.Practica_Final.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface ServicePedidos {



    boolean AddPedido(Pedido pedido);

    boolean DeletePedido(long id);

    boolean UpdatePedido(long id, DatosModificalble datos);

    ArrayList<Pedido> GetPedidos();
}
