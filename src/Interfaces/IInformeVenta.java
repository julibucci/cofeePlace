package modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface IInformeVenta
{
    int obtenerCantidadBebidas(HashMap<Integer, ArrayList<Producto>> cantidadProductos);
    int obtenerCantidadComida(HashMap<Integer, ArrayList<Producto>> cantidadProductos);
    double obtenerIngresoTotal(HashMap<Integer, ArrayList<Producto>> cantidadProductos);
    Producto obtenerProductoMasVendido(HashMap<Integer, ArrayList<Producto>> cantidadProductos);
    Producto obtenerProductoConMayorIngreso(HashMap<Integer, ArrayList<Producto>> cantidadProductos);
    ArrayList<Producto> listarProductosDisponibles(HashMap<Integer, ArrayList<Producto>> cantidadProductos);


}
