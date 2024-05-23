package modelo;
import java.util.HashMap;
import java.util.Map;

public interface IInformeVenta
{
    public int obtenerCantidadBebidas(HashMap<Producto, Integer> cantidadProductos);
 public int obtenerCantidadComida(HashMap<Producto, Integer> cantidadProductos);

  public double obtenerIngresoTotal(HashMap<Producto, Double> ingresosProductos);
 public Producto obtenerProductoConMayorIngreso(HashMap<Producto, Double> ingresosProductos);
  public Producto obtenerProductoMasVendido(HashMap<Producto, Integer> cantidadProductos);


}
