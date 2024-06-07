package modelo;

import Interfaces.IInformeVenta;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public JSONObject toJson() throws Comida.ProductoNoDisponibleException {
        JSONObject json = new JSONObject();
        JSONArray pedidosArray = new JSONArray();

        try {
            for (Map.Entry<Integer, ArrayList<T>> entry : cantidadProductos.entrySet()) {
                JSONObject pedidoJson = new JSONObject();
                pedidoJson.put("idMesa", entry.getKey());

                JSONArray productosArray = new JSONArray();
                for (T producto : entry.getValue()) {
                    JSONObject productoJson = new JSONObject();
                    productoJson.put("nombre", producto.getNombre());
                    productoJson.put("precio", producto.getPrecio());
                    productoJson.put("disponibilidad", producto.isDisponibilidad());
                    // Obtiene el estado del producto
                    Producto.Estado estadoProducto = producto.getEstado();
                    // Convierte el estado a String
                    String estado = estadoProducto.toString();
                    // Asigna el estado al JSON
                    productoJson.put("estado", estado);

                    // Agregar información específica para cada tipo de producto
                    if (producto instanceof Bebida) {
                        Bebida bebida = (Bebida) producto;
                        productoJson.put("tipoProducto", bebida.getTipoProducto().toString());
                        productoJson.put("tipo", bebida.getTipo());
                        productoJson.put("tamanio", bebida.getTamanio());
                        productoJson.put("alcoholica", bebida.isAlcoholica());
                    } else if (producto instanceof Comida) {
                        Comida comida = (Comida) producto;
                        productoJson.put("tipoProducto", comida.getTipoProducto().toString());
                        productoJson.put("vegetariano", comida.isVegetariano());
                        Receta receta = comida.getReceta();
                        if (receta != null) {
                            String nombrePlato = receta.getNombrePlato();
                            productoJson.put("receta", nombrePlato);
                        }
                    }

                    productosArray.put(productoJson);
                }

                pedidoJson.put("productos", productosArray);
                pedidosArray.put(pedidoJson);
            }

            json.put("pedidos", pedidosArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
    public static ReporteVenta<Producto> fromJson(JSONObject json) {
        ReporteVenta<Producto> reporteVenta = null;
        try {
            // Obtener el array de pedidos del JSON
            JSONArray pedidosArray = json.getJSONArray("pedidos");

            // Crear un HashMap para almacenar los productos
            HashMap<Integer, ArrayList<Producto>> cantidadProductos = new HashMap<>();

            // Iterar sobre los pedidos
            for (int i = 0; i < pedidosArray.length(); i++) {
                JSONObject pedidoJson = pedidosArray.getJSONObject(i);
                int idMesa = pedidoJson.getInt("idMesa");

                // Obtener el array de productos del pedido
                JSONArray productosArray = pedidoJson.getJSONArray("productos");
                ArrayList<Producto> productos = new ArrayList<>();

                // Iterar sobre los productos del pedido
                for (int j = 0; j < productosArray.length(); j++) {
                    JSONObject productoJson = productosArray.getJSONObject(j);
                    String nombre = productoJson.getString("nombre");
                    double precio = productoJson.getDouble("precio");
                    boolean disponibilidad = productoJson.getBoolean("disponibilidad");
                    String estadoString = productoJson.getString("estado");
                    Producto.Estado estado = Producto.Estado.valueOf(estadoString);
                    String tipoProductoString = productoJson.getString("tipoProducto");
                    Producto.TipoProducto tipoProducto = Producto.TipoProducto.valueOf(tipoProductoString);

                    // Lógica para instanciar el producto adecuado (Bebida o Comida)
                    Producto producto;
                    if (tipoProducto == Producto.TipoProducto.BEBIDA) {
                        // Verificar si el campo "tipo" está presente antes de intentar obtenerlo
                        if (productoJson.has("tipo")) {
                            String tipo = productoJson.getString("tipo");
                            boolean alcoholica = productoJson.getBoolean("alcoholica");
                            String tamanio = productoJson.getString("tamanio");
                            producto = new Bebida(nombre, precio, disponibilidad, estado, tipoProducto, tipo, tamanio, alcoholica);
                        } else {
                            // Manejar el caso donde no hay campo "tipo" para bebidas
                            producto = new Bebida(nombre, precio, disponibilidad, estado, tipoProducto, "", "", false);
                        }
                    } else {
                        boolean vegetariano = productoJson.getBoolean("vegetariano");
                        Receta receta = null;
                        if (productoJson.has("receta")) {
                            String nombrePlato = productoJson.getString("receta");
                            receta = new Receta(nombrePlato, new ArrayList<>());
                        }
                        producto = new Comida(nombre, precio, disponibilidad, estado, tipoProducto, "", vegetariano, receta);
                    }

                    // Agregar el producto a la lista de productos
                    productos.add(producto);
                }

                // Agregar la lista de productos al HashMap
                cantidadProductos.put(idMesa, productos);
            }

            // Crear la instancia de ReporteVenta con el HashMap de productos
            reporteVenta = new ReporteVenta<>(cantidadProductos);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return reporteVenta;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte de Ventas:\n");
        for (Map.Entry<Integer, ArrayList<T>> entry : cantidadProductos.entrySet()) {
            sb.append("Pedido en la mesa ").append(entry.getKey()).append(":\n");
            for (T producto : entry.getValue()) {
                sb.append("\t").append(producto).append("\n");
            }
        }
        return sb.toString();
    }
}

