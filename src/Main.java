import modelo.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Ingrediente carne = new Ingrediente("Carne", 300);
        Ingrediente lechuga = new Ingrediente("Lechuga", 100);
        Ingrediente tomate = new Ingrediente("Tomate", 100);

        ArrayList<Ingrediente> ingredientesHamburguesa = new ArrayList<>();
        ingredientesHamburguesa.add(carne);
        ingredientesHamburguesa.add(lechuga);
        ingredientesHamburguesa.add(tomate);

        ArrayList<Ingrediente> ingredientesEnsalada = new ArrayList<>();
        ingredientesEnsalada.add(lechuga);
        ingredientesEnsalada.add(tomate);

        Producto bebida1 = new Bebida("Coca Cola", 1.50, true, Producto.Estado.LISTO, "Dulce", "Grande", false);
        Producto bebida2 = new Bebida("Cerveza", 2.50, true, Producto.Estado.LISTO, "Dulce", "Mediano", true);
        Producto comida1 = new Comida("Hamburguesa", 5.00, true, Producto.Estado.LISTO, "Rápida", false);
        Producto comida2 = new Comida("Ensalada", 3.50, true, Producto.Estado.LISTO, "Ligera", true);

        //Se crea un registro para las ventas
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

        //Se crea una instancia de ReporteVenta que ahora es generica. De esat forma, se le puede pasar una lista de ventas de cualquier tipo de producto.
        ReporteVenta<Producto> reporteVenta = new ReporteVenta<>(ventas);

        int cantidadBebidas = reporteVenta.obtenerCantidadProducto(Producto.TipoProducto.BEBIDA);
        System.out.println("Cantidad de bebidas vendidas: " + cantidadBebidas);

        int cantidadComidas = reporteVenta.obtenerCantidadProducto(Producto.TipoProducto.COMIDA);
        System.out.println("Cantidad de comidas vendidas: " + cantidadComidas);

        double ingresoTotal = reporteVenta.obtenerIngresoTotal();
        System.out.println("Ingreso total: " + ingresoTotal);

        Producto productoMasVendido = reporteVenta.obtenerProductoMasVendido();
        if (productoMasVendido != null) {
            System.out.println("Producto más vendido: " + productoMasVendido.getNombre());
        } else {
            System.out.println("No hay productos vendidos.");
        }

        Producto productoMayorIngreso = reporteVenta.obtenerProductoConMayorIngreso();
        if (productoMayorIngreso != null) {
            System.out.println("Producto con mayor ingreso: " + productoMayorIngreso.getNombre());
        } else {
            System.out.println("No hay productos vendidos.");
        }

        ArrayList<Producto> productosDisponibles = reporteVenta.listarProductosDisponibles();
        System.out.println("Productos disponibles: ");
        for (Producto producto : productosDisponibles) {
            System.out.println(producto);
        }
    }
}
