import Classes.Employees.*;
import Classes.Items.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Comida pizza = new Comida("Pizza", 8.99, true, true, "Italiana", false);
        Comida sushi = new Comida("Sushi", 12.99, false, true, "Japonesa", false);
        Bebida cola = new Bebida("Cola", 2.50, true, true, "Dulce", "Grande", false);
        Bebida cerveza = new Bebida("Cerveza", 3.00, true, true, "Dulce", "Mediano", true);

        // Crear mapas para cantidades y ingresos
        HashMap<Producto, Integer> cantidadProductos = new HashMap<>();
        HashMap<Producto, Double> ingresosProductos = new HashMap<>();

        // Añadir productos a los mapas
        cantidadProductos.put(pizza, 10);
        cantidadProductos.put(sushi, 5);
        cantidadProductos.put(cola, 20);
        cantidadProductos.put(cerveza, 15);

        ingresosProductos.put(pizza, 89.90);
        ingresosProductos.put(sushi, 64.95);
        ingresosProductos.put(cola, 50.00);
        ingresosProductos.put(cerveza, 45.00);

        // Crear instancia de ReporteVenta
        ReporteVenta reporte = new ReporteVenta();

        // Obtener y mostrar cantidades e ingresos
        int totalBebidas = reporte.obtenerCantidadBebidas(cantidadProductos);
        int totalComidas = reporte.obtenerCantidadComida(cantidadProductos);
        double ingresoTotal = reporte.obtenerIngresoTotal(ingresosProductos);

        System.out.println("Total de bebidas vendidas: " + totalBebidas);
        System.out.println("Total de comidas vendidas: " + totalComidas);
        System.out.println("Ingreso total: $" + ingresoTotal);

        // Obtener y mostrar el producto más vendido
        Producto masVendido = reporte.obtenerProductoMasVendido(cantidadProductos);
        System.out.println("Producto más vendido: " + masVendido.getNombre());

        // Obtener y mostrar el producto con mayor ingreso
        Producto mayorIngreso = reporte.obtenerProductoConMayorIngreso(ingresosProductos);
        System.out.println("Producto con mayor ingreso: " + mayorIngreso.getNombre());

        // Listar y mostrar productos disponibles
        ArrayList<Producto> productosDisponibles = reporte.listarProductosDisponibles(cantidadProductos);
        System.out.println("Productos disponibles:");
        for (Producto producto : productosDisponibles) {
            System.out.println("- " + producto.getNombre());
        }

        // Usar algunos métodos adicionales
        // Cambiar el tamaño de la cola
        cola.cambiarTamanio("Mediano");

        // Mostrar información de la cola después de cambiar el tamaño
        System.out.println("Información de la cola después de cambiar el tamaño:");
        System.out.println(cola);

        // Intentar obtener el tipo de sushi
        try {
            System.out.println("Tipo de sushi: " + sushi.getTipo());
        } catch (Comida.ProductoNoDisponibleException e) {
            System.out.println(e.getMessage());
        }

        Mozo empleado1= new Mozo("Martina","Perez", 41583224,2018);
        empleado1.setPropinas(1000);

        Empleado empleado2=new Gerente("Juana","Pepe",28596474);

        Cocinero empleado3=new Cocinero("Pedro","Sunsu",32659874);
        empleado3.setCantidadDePlatos(800);

        System.out.println(empleado1.toString());
        System.out.println(empleado2.toString());
        System.out.println(empleado3.toString());
    }
}






