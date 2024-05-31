package modelo;

import Interfaces.IInformeVenta;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReporteVenta<T extends Producto> implements IInformeVenta<T>
{

    private HashMap<Integer, ArrayList<T>> cantidadProductos;

    // Custom constructor
    public ReporteVenta(HashMap<Integer, ArrayList<T>> cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int obtenerCantidadProducto(Producto.TipoProducto tipoProducto)
    {
        int total = 0;
        for(Map.Entry<Integer, ArrayList<T>> entry : cantidadProductos.entrySet())
        {
            ArrayList<T> listaProductos = entry.getValue();

            for (T producto : listaProductos)
            {
                if (producto.getTipoProducto() == tipoProducto)
                {
                    total++;
                }
            }
        }
        return total;
    }

    @Override
    public double obtenerIngresoTotal()
    {
        double ingresoTotal = 0;
        for (Map.Entry<Integer, ArrayList<T>> entry : cantidadProductos.entrySet()) {
            ArrayList<T> listaProductos = entry.getValue();
            for (T producto : listaProductos) {
                ingresoTotal += producto.getPrecio();
            }
        }
        return ingresoTotal;
    }

    @Override
    public T obtenerProductoMasVendido() {
        T masVendido = null;
        int maxCantidad = 0;
        HashMap<T, Integer> contadorProductos = new HashMap<>();

        for (Map.Entry<Integer, ArrayList<T>> entry : cantidadProductos.entrySet()) {
            ArrayList<T> listaProductos = entry.getValue();
            for (T producto : listaProductos) {
                contadorProductos.put(producto, contadorProductos.getOrDefault(producto, 0) + 1);
            }
        }

        for (Map.Entry<T, Integer> entry : contadorProductos.entrySet()) {
            if (entry.getValue() > maxCantidad) {
                masVendido = entry.getKey();
                maxCantidad = entry.getValue();
            }
        }

        return masVendido;
    }

    @Override
    public T obtenerProductoConMayorIngreso() {
        T mayorIngreso = null;
        double maxIngreso = 0;
        HashMap<T, Double> ingresosProductos = new HashMap<>();

        for (Map.Entry<Integer, ArrayList<T>> entry : cantidadProductos.entrySet()) {
            ArrayList<T> listaProductos = entry.getValue();
            for (T producto : listaProductos) {
                double ingreso = producto.getPrecio();
                ingresosProductos.put(producto, ingresosProductos.getOrDefault(producto, 0.0) + ingreso);
            }
        }

        for (Map.Entry<T, Double> entry : ingresosProductos.entrySet()) {
            if (entry.getValue() > maxIngreso) {
                mayorIngreso = entry.getKey();
                maxIngreso = entry.getValue();
            }
        }

        return mayorIngreso;
    }

    @Override
    public ArrayList<T> listarProductosDisponibles() {
        ArrayList<T> productosDisponibles = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<T>> entry : cantidadProductos.entrySet()) {
            ArrayList<T> listaProductos = entry.getValue();
            for (T producto : listaProductos) {
                if (producto.isDisponibilidad()) {
                    productosDisponibles.add(producto);
                }
            }
        }
        return productosDisponibles;
    }
}

