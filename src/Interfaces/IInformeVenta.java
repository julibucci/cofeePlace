package Interfaces;
import modelo.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface IInformeVenta<T>
{
    int obtenerCantidadBebidas();
    int obtenerCantidadComida();
    double obtenerIngresoTotal();
    Producto obtenerProductoMasVendido();
    Producto obtenerProductoConMayorIngreso();
    ArrayList<T> listarProductosDisponibles();


}
