package modelo;

import Interfaces.IInformeVenta;

import java.util.ArrayList;
import java.util.HashMap;

public class ReporteVenta implements IInformeVenta
{
    // METODO OBTENER CANTIDAD DE BEBIDAS QUE FUERON VENDIDAS
    @Override
    public int obtenerCantidadBebidas(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        int totalBebidas = 0;
        for (HashMap.Entry<Integer, ArrayList<Producto>> entry : cantidadProductos.entrySet()) {
            ArrayList<Producto> listaProductos = entry.getValue();
            for (int i = 0; i < listaProductos.size(); i++) {
                Producto producto = listaProductos.get(i);
                if (producto instanceof Bebida) {
                    totalBebidas++;
                }
            }
        }
        return totalBebidas;
    }

    // METODO OBTENER CANTIDAD DE COMIDA QUE FUERON VENDIDAS
    @Override
    public int obtenerCantidadComida(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        int totalComida = 0;
        for (HashMap.Entry<Integer, ArrayList<Producto>> entry : cantidadProductos.entrySet()) {
            ArrayList<Producto> listaProductos = entry.getValue();
            for (int i = 0; i < listaProductos.size(); i++) {
                Producto producto = listaProductos.get(i);
                if (producto instanceof Comida) {
                    totalComida++;
                }
            }
        }
        return totalComida;
    }

    // METODO PARA OBTENER INGRESO TOTAL
    @Override
    public double obtenerIngresoTotal(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        double ingresoTotal = 0;
        for (HashMap.Entry<Integer, ArrayList<Producto>> entry : cantidadProductos.entrySet()) {
            ArrayList<Producto> listaProductos = entry.getValue();
            for (Producto producto : listaProductos) {
                ingresoTotal += producto.getPrecio();
            }
        }
        return ingresoTotal;
    }

    // METODO PARA OBTENER EL PRODUCTO MAS VENDIDO
    public Producto obtenerProductoMasVendido(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        Producto masVendido = null;
        int maxCantidad = 0;
        HashMap<Producto, Integer> contadorProductos = new HashMap<>();

        for (HashMap.Entry<Integer, ArrayList<Producto>> entry : cantidadProductos.entrySet()) {
            ArrayList<Producto> listaProductos = entry.getValue();
            for (int i = 0; i < listaProductos.size(); i++) {
                Producto producto = listaProductos.get(i);
                contadorProductos.put(producto, contadorProductos.getOrDefault(producto, 0) + 1);
            }
        }

        for (HashMap.Entry<Producto, Integer> entry : contadorProductos.entrySet()) {
            if (entry.getValue() > maxCantidad) {
                masVendido = entry.getKey();
                maxCantidad = entry.getValue();
            }
        }

        return masVendido;
    }

    // METODO PARA OBTENER EL PRODUCTO CON MAS VENTAS
    public Producto obtenerProductoConMayorIngreso(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        Producto mayorIngreso = null;
        double maxIngreso = 0;
        HashMap<Producto, Double> ingresosProductos = new HashMap<>();

        for (HashMap.Entry<Integer, ArrayList<Producto>> entry : cantidadProductos.entrySet())
        {
            ArrayList<Producto> listaProductos = entry.getValue();
            for (Producto producto : listaProductos)
            {
                double ingreso = producto.getPrecio();
                ingresosProductos.put(producto, ingresosProductos.getOrDefault(producto, 0.0) + ingreso);
            }
        }

        for (HashMap.Entry<Producto, Double> entry : ingresosProductos.entrySet())
        {
            if (entry.getValue() > maxIngreso)
            {
                mayorIngreso = entry.getKey();
                maxIngreso = entry.getValue();
            }
        }

        return mayorIngreso;
    }

    // METODO PARA LISTAS PRODUCTOS DISPONIBLES
    public ArrayList<Producto> listarProductosDisponibles(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        ArrayList<Producto> productosDisponibles = new ArrayList<>();

        for (HashMap.Entry<Integer, ArrayList<Producto>> entry : cantidadProductos.entrySet()) {
            ArrayList<Producto> listaProductos = entry.getValue();
            for (int i = 0; i < listaProductos.size(); i++) {
                Producto producto = listaProductos.get(i);
                if (producto.isDisponibilidad()) {
                    productosDisponibles.add(producto);
                }
            }
        }
        return productosDisponibles;

    }


}
