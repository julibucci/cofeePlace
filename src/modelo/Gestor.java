package modelo;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gestor {

    // Ingredientes
    private static Ingrediente carne;
    private static Ingrediente lechuga;
    private static Ingrediente tomate;

    // Recetas
    private static ArrayList<Ingrediente> ingredientesHamburguesa = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesEnsalada = new ArrayList<>();
    private static Receta recetaHamburguesa;
    private static Receta recetaEnsalada;

    // Productos
    private static Producto bebida1;
    private static Producto bebida2;
    private static Producto comida1;
    private static Producto comida2;

    // Reporte de ventas
    private static HashMap<Integer, ArrayList<Producto>> ventas = new HashMap<>();
    private static ReporteVenta reporteVenta;

    // Stock
    private static Stock stock = new Stock();

    // Se crean y se cargan los ingredientes y recetas una vez antes de cualquier operación
    public static Stock inicializarIngredientesYRecetas() {
        carne = new Ingrediente("Carne", 300);
        lechuga = new Ingrediente("Lechuga", 250);
        tomate = new Ingrediente("Tomate", 100);

        ingredientesHamburguesa.add(carne);
        ingredientesHamburguesa.add(lechuga);
        ingredientesHamburguesa.add(tomate);

        ingredientesEnsalada.add(lechuga);
        ingredientesEnsalada.add(tomate);

        recetaHamburguesa = new Receta("Hamburguesa", ingredientesHamburguesa);
        recetaEnsalada = new Receta("Ensalada", ingredientesEnsalada);

        stock.agregarIngrediente(carne);
        stock.agregarIngrediente(lechuga);
        stock.agregarIngrediente(tomate);

        return stock;
    }

    // Getteres necesarios
    public static Receta getRecetaHamburguesa() {
        return recetaHamburguesa;
    }

    public static Receta getRecetaEnsalada() {
        return recetaEnsalada;
    }


    public static void anotarPedidos() {
        bebida1 = new Bebida("Coca Cola", 1.50, true, Producto.Estado.LISTO, Producto.TipoProducto.BEBIDA, "Dulce", "Grande", false);
        bebida2 = new Bebida("Cerveza", 2.50, true, Producto.Estado.LISTO, Producto.TipoProducto.BEBIDA, "Dulce", "Mediano", true);
        comida1 = new Comida("Hamburguesa", 5.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Rápida", false, recetaHamburguesa);
        comida2 = new Comida("Ensalada", 3.50, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Ligera", true, recetaEnsalada);

        ArrayList<Producto> listaVentas1 = new ArrayList<>();
        listaVentas1.add(bebida1);
        listaVentas1.add(comida1);

        ArrayList<Producto> listaVentas2 = new ArrayList<>();
        listaVentas2.add(bebida2);
        listaVentas2.add(comida2);
        listaVentas2.add(bebida1);

        ventas.put(1, listaVentas1);
        ventas.put(2, listaVentas2);

        reporteVenta = new ReporteVenta(ventas);
    }

    public static int obtenerCantidadBebidasVendidas() {
        if (reporteVenta == null) {
            throw new IllegalStateException("Primero anote los pedidos.");
        }
        return reporteVenta.obtenerCantidadProducto(Producto.TipoProducto.BEBIDA);
    }

    public static int obtenerCantidadComidasVendidas() {
        if (reporteVenta == null) {
            throw new IllegalStateException("Primero anote los pedidos.");
        }
        return reporteVenta.obtenerCantidadProducto(Producto.TipoProducto.COMIDA);
    }

    public static Producto obtenerProductoMayorIngreso() {
        if (reporteVenta == null) {
            throw new IllegalStateException("Primero anote los pedidos.");
        }
        return reporteVenta.obtenerProductoConMayorIngreso();
    }

    public static ArrayList<Producto> obtenerProductosDisponibles() {
        if (reporteVenta == null) {
            throw new IllegalStateException("Primero anote los pedidos.");
        }
        return reporteVenta.listarProductosDisponibles();
    }

    public static void guardarReporteVentas()
    {
        if (reporteVenta == null) {
            throw new IllegalStateException("Primero anote los pedidos.");
        }

        try {
            JSONObject json = reporteVenta.toJson();
            JsonUtiles.grabar(json, "reporte_ventas");
        } catch (Comida.ProductoNoDisponibleException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }


    public static String modificarStock()
    {
        String informacion = " ";

        try {
            // Verificar si el archivo de stock existe y no está vacío
            File file = new File("stock.dat");

            if (!file.exists() || file.length() == 0) {
                informacion = "El archivo de stock no existe o está vacío. Por favor, cargue el stock primero.";
            } else {
                // Modificar el stock
                stock.eliminarIngrediente("Lechuga", 50);
                informacion = stock.toString();
            }
        } catch (Exception e) {
            informacion = "Error: " + e.getMessage();
        }

        return informacion;
    }


    public static Stock guardarYLeerStock() {
        Gerente gerente = new Gerente("Ana", "Lopez", 78912361);
        gerente.guardarStock(stock);

        Stock nuevoStock = gerente.leerStock();
        return nuevoStock;
    }

    public static void guardarRecetas(Cocinero cocinero) {
        HashMap<String, Receta> recetas = cocinero.agregarReceta("Ensalada", recetaEnsalada);
        recetas = cocinero.agregarReceta("Hamburguesa", recetaHamburguesa);

        cocinero.guardarRecetas(recetas);
    }

    public static HashMap<String, Receta> leerRecetas(Cocinero cocinero) {
        return cocinero.leerRecetas();
    }

}
