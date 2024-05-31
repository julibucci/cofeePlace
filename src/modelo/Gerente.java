package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Gerente extends Empleado {
    private static int salario=150000;

    public Gerente(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    public int obtenerCantidadBebidas(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        ReporteVenta reporte = new ReporteVenta();
        return reporte.obtenerCantidadBebidas(cantidadProductos);
    }

    public int obtenerCantidadComida(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        ReporteVenta reporte = new ReporteVenta();
        return reporte.obtenerCantidadComida(cantidadProductos);
    }

    public double obtenerIngresoTotal(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        ReporteVenta reporte = new ReporteVenta();
        return reporte.obtenerIngresoTotal(cantidadProductos);
    }

    public Producto obtenerProductoMasVendido(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        ReporteVenta reporte = new ReporteVenta();
        return reporte.obtenerProductoMasVendido(cantidadProductos);
    }

    public Producto obtenerProductoConMayorIngreso(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        ReporteVenta reporte = new ReporteVenta();
        return reporte.obtenerProductoConMayorIngreso(cantidadProductos);
    }

    public ArrayList<Producto> listarProductosDisponibles(HashMap<Integer, ArrayList<Producto>> cantidadProductos) {
        ReporteVenta reporte = new ReporteVenta();
        return reporte.listarProductosDisponibles(cantidadProductos);
    }

    @Override
    public String toString() {
        return super.toString() +" salario: " + calcularSalario();
    }
}
