package modelo;

import java.util.HashMap;
import java.util.Map;

class ReporteVentas implements IInformeVenta
{
    @Override
    public int obtenerCantidadBebidas(HashMap<Producto, Integer> cantidadProductos) {
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

    @Override
    public double obtenerIngresoTotal(HashMap<Producto, Double> ingresosProductos) {
        double ingresoTotal = 0;
        for (double ingreso : ingresosProductos.values()) {
            ingresoTotal += ingreso;
        }
        return ingresoTotal;
    }
}
