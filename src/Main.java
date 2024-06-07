import modelo.*;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*Ingrediente carne = new Ingrediente("Carne", 300);
        Ingrediente lechuga = new Ingrediente("Lechuga", 100);
        Ingrediente tomate = new Ingrediente("Tomate", 100);

        ArrayList<Ingrediente> ingredientesHamburguesa = new ArrayList<>();
        ingredientesHamburguesa.add(carne);
        ingredientesHamburguesa.add(lechuga);
        ingredientesHamburguesa.add(tomate);

        ArrayList<Ingrediente> ingredientesEnsalada = new ArrayList<>();
        ingredientesEnsalada.add(lechuga);
        ingredientesEnsalada.add(tomate);

        Receta recetaHamburguesa = new Receta("Hamburguesa", ingredientesHamburguesa);
        Receta recetaEnsalada = new Receta("Ensalada", ingredientesEnsalada);

        Producto bebida1 = new Bebida("Coca Cola", 1.50, true, Producto.Estado.LISTO, Producto.TipoProducto.BEBIDA, "Dulce", "Grande", false);
        Producto bebida2 = new Bebida("Cerveza", 2.50, true, Producto.Estado.LISTO, Producto.TipoProducto.BEBIDA, "Dulce", "Mediano", true);
        Producto comida1 = new Comida("Hamburguesa", 5.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Rápida", false, recetaHamburguesa);
        Producto comida2 = new Comida("Ensalada", 3.50, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Ligera", true, recetaEnsalada);

        // HashMap de productos vendidos
        HashMap<Integer, ArrayList<Producto>> ventas = new HashMap<>();

        ArrayList<Producto> listaVentas1 = new ArrayList<>();
        listaVentas1.add(bebida1);
        listaVentas1.add(comida1);

        ArrayList<Producto> listaVentas2 = new ArrayList<>();
        listaVentas2.add(bebida2);
        listaVentas2.add(comida2);
        listaVentas2.add(bebida1);

        ventas.put(1, listaVentas1);
        ventas.put(2, listaVentas2);

        ReporteVenta reporteVenta = new ReporteVenta(ventas);

        int cantidadBebidas = reporteVenta.obtenerCantidadProducto(Producto.TipoProducto.BEBIDA);
        System.out.println("Cantidad de bebidas vendidas: " + cantidadBebidas);

        int cantidadComidas = reporteVenta.obtenerCantidadProducto(Producto.TipoProducto.COMIDA);
        System.out.println("Cantidad de comidas vendidas: " + cantidadComidas);

        double ingresoTotal = reporteVenta.obtenerIngresoTotal();
        System.out.println("Ingreso total: " + ingresoTotal);

        Producto productoMasVendido = reporteVenta.obtenerProductoMasVendido();
        System.out.println("Producto más vendido: " + productoMasVendido.getNombre());

        Producto productoMayorIngreso = reporteVenta.obtenerProductoConMayorIngreso();
        System.out.println("Producto con mayor ingreso: " + productoMayorIngreso.getNombre());

        ArrayList<Producto> productosDisponibles = reporteVenta.listarProductosDisponibles();
        System.out.println("Productos disponibles: ");
        for (Producto producto : productosDisponibles) {
            System.out.println(producto);
        }

        Stock stock = new Stock();
        stock.agregarIngrediente(carne);
        stock.agregarIngrediente(lechuga);
        stock.agregarIngrediente(tomate);

        System.out.println("Stock inicial:");
        System.out.println(stock);

        try {
            stock.eliminarIngrediente("Lechuga", 50);
            System.out.println("Stock despues de eliminar 50 de Lechuga:");
            System.out.println(stock);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            // Convertir a JSON y guardar en archivo
            JSONObject json = reporteVenta.toJson();
            JsonUtiles.grabar(json, "reporte_ventas");
            System.out.println("Reporte de ventas guardado exitosamente.");
            System.out.println(json.toString());
        } catch (Comida.ProductoNoDisponibleException e) {
            System.err.println(e.getMessage());
        }

         */

        // Crear un HashMap para simular datos de venta
        HashMap<Integer, ArrayList<Producto>> ventas = new HashMap<>();
        ArrayList<Producto> productos1 = new ArrayList<>();
        productos1.add(new Comida("Hamburguesa", 10.0, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Rápida", false, null));
        productos1.add(new Bebida("Refresco", 2.5, true, Producto.Estado.LISTO, Producto.TipoProducto.BEBIDA, "Gaseosa", "500ml", false));
        ArrayList<Producto> productos2 = new ArrayList<>();
        productos2.add(new Comida("Pizza", 12.0, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Italiana", true, null));
        ventas.put(1, productos1);
        ventas.put(2, productos2);

        // Crear un objeto ReporteVenta con los datos simulados
        ReporteVenta<Producto> reporteVenta = new ReporteVenta<>(ventas);

        try {
            // Convertir el reporte de ventas a JSON
            JSONObject jsonReporte = reporteVenta.toJson();
            System.out.println("Reporte en formato JSON:");
            System.out.println(jsonReporte.toString());

            // Convertir el JSON nuevamente a un objeto ReporteVenta
            ReporteVenta<Producto> reporteDesdeJson = ReporteVenta.fromJson(jsonReporte);
            System.out.println("\nReporte reconstruido desde JSON:");
            System.out.println(reporteDesdeJson);
        } catch (Comida.ProductoNoDisponibleException e) {
            System.out.println("Error al convertir a JSON: " + e.getMessage());
        }
    }
}






