package Classes.Items;

import java.util.HashMap;

public interface IInformeVenta
{
    int obtenerCantidadBebidas(HashMap<Producto, Integer> cantidadProductos);
    int obtenerCantidadComida(HashMap<Producto, Integer> cantidadProductos);

    double obtenerIngresoTotal(HashMap<Producto, Double> ingresosProductos);
   Producto obtenerProductoConMayorIngreso(HashMap<Producto, Double> ingresosProductos);
   Producto obtenerProductoMasVendido(HashMap<Producto, Integer> cantidadProductos);


}
