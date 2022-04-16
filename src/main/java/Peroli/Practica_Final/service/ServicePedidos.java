package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.DatosModificalble;
import Peroli.Practica_Final.model.Pedido;

import java.util.ArrayList;


public interface ServicePedidos {



    void AddPedido(Pedido pedido);

    boolean DeletePedido(Long id);

    boolean UpdatePedido(Long id, DatosModificalble datos);

    ArrayList<Pedido> GetPedidos();

    Pedido GetPedido(Long id);
}
