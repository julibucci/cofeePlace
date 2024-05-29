import modelo.*;


import java.util.ArrayList;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Ingrediente agua = new Ingrediente("Agua", 500);
        Ingrediente azucar = new Ingrediente("Azúcar", 100);
        Ingrediente cebada = new Ingrediente("Cebada", 200);
        Ingrediente carne = new Ingrediente("Carne", 300);
        Ingrediente lechuga = new Ingrediente("Lechuga", 100);
        Ingrediente tomate = new Ingrediente("Tomate", 100);

        ArrayList<Ingrediente> ingredientesCocaCola = new ArrayList<>();
        ingredientesCocaCola.add(agua);
        ingredientesCocaCola.add(azucar);

        ArrayList<Ingrediente> ingredientesCerveza = new ArrayList<>();
        ingredientesCerveza.add(agua);
        ingredientesCerveza.add(cebada);

        ArrayList<Ingrediente> ingredientesHamburguesa = new ArrayList<>();
        ingredientesHamburguesa.add(carne);
        ingredientesHamburguesa.add(lechuga);
        ingredientesHamburguesa.add(tomate);

        ArrayList<Ingrediente> ingredientesEnsalada = new ArrayList<>();
        ingredientesEnsalada.add(lechuga);
        ingredientesEnsalada.add(tomate);

        Producto bebida1 = new Bebida("Coca Cola", 1.50, true, true, "Dulce", "Grande", false);
        Producto bebida2 = new Bebida("Cerveza", 2.50, true, true, "Dulce", "Mediano", true);
        Producto comida1 = new Comida("Hamburguesa", 5.00, true, true, "Rápida", false);
        Producto comida2 = new Comida("Ensalada", 3.50, true, true, "Ligera", true);

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

        ReporteVenta reporteVenta = new ReporteVenta();

        int cantidadBebidas = reporteVenta.obtenerCantidadBebidas(ventas);
        System.out.println("Cantidad de bebidas vendidas: " + cantidadBebidas);

        int cantidadComidas = reporteVenta.obtenerCantidadComida(ventas);
        System.out.println("Cantidad de comidas vendidas: " + cantidadComidas);

        double ingresoTotal = reporteVenta.obtenerIngresoTotal(ventas);
        System.out.println("Ingreso total: " + ingresoTotal);

        Producto productoMasVendido = reporteVenta.obtenerProductoMasVendido(ventas);
        System.out.println("Producto más vendido: " + productoMasVendido.getNombre());

        Producto productoMayorIngreso = reporteVenta.obtenerProductoConMayorIngreso(ventas);
        System.out.println("Producto con mayor ingreso: " + productoMayorIngreso.getNombre());

        ArrayList<Producto> productosDisponibles = reporteVenta.listarProductosDisponibles(ventas);
        System.out.println("Productos disponibles: ");
        for (Producto producto : productosDisponibles) {
            System.out.println(producto);
        }

    }
}






