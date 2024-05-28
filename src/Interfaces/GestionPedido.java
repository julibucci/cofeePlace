package Interfaces;

import Excepciones.OrdenNoEncontradaException;
import modelo.Producto;

import java.util.ArrayList;

public interface GestionPedido {

    // Interfaz para gestionar pedidos
    void crearPedido(int id, ArrayList<Producto> platos);
    void cancelarPedido(int id) throws OrdenNoEncontradaException;
}