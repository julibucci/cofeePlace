package modelo;
import Excepciones.OrdenNoEncontradaException;
import Interfaces.GestionPedido;

import Excepciones.OrdenNoEncontradaException;
import Interfaces.GestionPedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pedido implements GestionPedido, Serializable {
    private Map<Integer, ArrayList<Producto>> pedidos;

    public Pedido() {
        this.pedidos = new HashMap<>();
    }

    @Override
    public void crearPedido(int id, ArrayList<Producto> platos) {
        pedidos.put(id, platos);
    }

    @Override
    public void cancelarPedido(int id) throws OrdenNoEncontradaException {
        if (pedidos.containsKey(id)) {
            pedidos.remove(id);
        } else {
            throw new OrdenNoEncontradaException("Orden no encontrada: " + id);
        }
    }

    public void agregarPlato(int id, Producto plato) {
        pedidos.computeIfAbsent(id, k -> new ArrayList<>()).add(plato);
    }

    public void eliminarPlato(int id, Producto plato) {
        if (pedidos.containsKey(id)) {
            pedidos.get(id).remove(plato);
        }
    }

    public double calcularTotal(int id) {
        if (pedidos.containsKey(id)) {
            double total = 0;
            for (Producto plato : pedidos.get(id)) {
                total += plato.getPrecio();
            }
            return total;
        }
        return 0;
    }

    public ArrayList<Producto> getPedido(int id) {
        return pedidos.getOrDefault(id, new ArrayList<>());
    }

    public Map<Integer, ArrayList<Producto>> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "pedidos=" + pedidos +
                '}';
    }
}
