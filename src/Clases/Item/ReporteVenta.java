package Clases.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class ReporteVenta implements IInformeVenta
{
    // METODO OBTENER CANTIDAD DE BEBIDAS QUE FUERON VENDIDAS
    @Override
    public
    int obtenerCantidadBebidas(HashMap<Producto, Integer> cantidadProductos) {
        int totalBebidas = 0;
        for (HashMap.Entry<Producto, Integer> entry : cantidadProductos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            if (producto instanceof Bebida) {
                totalBebidas += cantidad;
            }
        }
        return totalBebidas;
    }
    // METODO OBTENER CANTIDAD DE COMIDA QUE FUERON VENDIDAS

    @Override
    public int obtenerCantidadComida(HashMap<Producto, Integer> cantidadProductos) {
        int totalComida = 0;
        for (HashMap.Entry<Producto, Integer> entry : cantidadProductos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            if (producto instanceof Comida) {
                totalComida += cantidad;
            }
        }
        return totalComida;
    }

    // METODO PARA OBTENER INGRESO TOTAL
    @Override
    public double obtenerIngresoTotal(HashMap<Producto, Double> ingresosProductos) {
        double ingresoTotal = 0;
        for (double ingreso : ingresosProductos.values()) {
            ingresoTotal += ingreso;
        }
        return ingresoTotal;
    }

    // METODO PARA OBTENER EL PRODUCTO MAS VENDIDO
    public Producto obtenerProductoMasVendido(HashMap<Producto, Integer> cantidadProductos) {
        Producto masVendido = null;
        int maxCantidad = 0;

        for (HashMap.Entry<Producto, Integer> entry : cantidadProductos.entrySet()) {
            if (entry.getValue() > maxCantidad) {
                masVendido = entry.getKey();
                maxCantidad = entry.getValue();
            }
        }

        return masVendido;
    }

    // METODO PARA OBTENER EL PRODUCTO CON MAS VENTAS
    public Producto obtenerProductoConMayorIngreso(HashMap<Producto, Double> ingresosProductos) {
        Producto mayorIngreso = null;
        double maxIngreso = 0;

        for (HashMap.Entry<Producto, Double> entry : ingresosProductos.entrySet()) {
            if (entry.getValue() > maxIngreso) {
                mayorIngreso = entry.getKey();
                maxIngreso = entry.getValue();
            }
        }

        return mayorIngreso;
    }

    // METODO PARA LISTAS PRODUCTOS DISPONIBLES
    public ArrayList<Producto> listarProductosDisponibles(HashMap<Producto, Integer> cantidadProductos) {
        ArrayList<Producto> productosDisponibles = new ArrayList<>();
        for (Producto producto : cantidadProductos.keySet()) {
            if (producto.isDisponibilidad()) {
                productosDisponibles.add(producto);
            }
        }
        return productosDisponibles;
    }
}
