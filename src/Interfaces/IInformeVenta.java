package Interfaces;
import modelo.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface IInformeVenta<T>
{
    int obtenerCantidadProducto(Producto.TipoProducto tipoProducto);
    double obtenerIngresoTotal();
    Producto obtenerProductoMasVendido();
    Producto obtenerProductoConMayorIngreso();
    ArrayList<T> listarProductosPedidos();


}
