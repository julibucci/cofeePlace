import modelo.*;
import org.json.JSONObject;


import java.io.IOException;
import java.util.*;

/*
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


        Gerente gerente = new Gerente("Marta","Gomez",343243);
        // Guardar el stock
        gerente.guardarStock(stock);


        // Leer el stock
        Stock nuevoStock = gerente.leerStock();
        System.out.println("Inventario del stock leído:");
        for (HashMap.Entry<String, Ingrediente> entry : nuevoStock.getInventario().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        // Crear un cocinero y agregar recetas
        Cocinero cocinero = new Cocinero("Roman", "Fernandez", 234328);
        cocinero.agregarReceta("Ensalada", recetaEnsalada);
        cocinero.agregarReceta("Hamburguesa", recetaHamburguesa);

        // Guardar las recetas
        cocinero.guardarRecetas();

        // Leer las recetas
        Map<String, Receta> recetasLeidas = cocinero.leerRecetas();
        System.out.println("Recetas leídas:");

        // Usar un bucle para imprimir las recetas
        for (Map.Entry<String, Receta> entry : recetasLeidas.entrySet()) {
            String nombre = entry.getKey();
            Receta receta = entry.getValue();
            System.out.println(nombre + ": " + receta);
        }


    }
}


 */
import modelo.*;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        menuPrincipal();
        scanner.close();

    }

    private static void menuPrincipal() {
        // Primero pregunta si es admin o empleado
        System.out.println("--------------------------------------");
        System.out.println("MENÚ PRINCIPAL:");

        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Administrador.");
        System.out.println("2. Empleado.");
        System.out.println("3. Salir.");
        System.out.println("--------------------------------------");
        int tipoUsuario = scanner.nextInt();

        switch (tipoUsuario) {
            case 1:
                menuAdmin();
                break;
            case 2:
                menuEmpleado();
                break;
            case 3:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private static void menuAdmin() {
        char continuar = 's';

        while (continuar == 's') {
            System.out.println("--------------------------------------");
            System.out.println("MENÚ ADMINISTRADOR:");

            System.out.println("1. Mostrar menú de pedidos.");
            System.out.println("2. Anotar pedidos y registrar ventas.");
            System.out.println("3. Gestionar reporte de ventas.");
            System.out.println("4. Gestionar stock.");
            System.out.println("5. Gestionar recetas.");
            System.out.println("6. Volver al menú principal.");
            System.out.println("--------------------------------------");
            int opcion = scanner.nextInt();

            Gestor.inicializarIngredientesYRecetas(); //Paso necesario (y obligatorio) que se debe hacer antes que cualquier otra cosa

            switch (opcion) {
                case 1:
                    Menu menu = new Menu();
                    String mostrarMenu = menu.toString();
                    System.out.println(mostrarMenu);
                    break;
                case 2:
                    Gestor.anotarPedidos();
                    System.out.println("Pedidos anotados y ventas registradas correctamente.");
                    break;
                case 3:
                    char subContinuar = 's';

                    while (subContinuar == 's') {
                        System.out.println("--------------------------------------");
                        System.out.println("Elija una opción referente a la gestión del reporte de ventas.");
                        System.out.println("1. Producto de mayor ingreso.");
                        System.out.println("2. Cantidad de bebidas vendidas.");
                        System.out.println("3. Cantidad de comidas vendidas.");
                        System.out.println("4. Mostrar productos disponibles.");
                        System.out.println("5. Guardar reporte de ventas en JSON.");
                        System.out.println("6. Volver al menú del administrador.");
                        System.out.println("--------------------------------------");
                        int subOpcion = scanner.nextInt();

                        switch (subOpcion) {
                            case 1:
                                Producto producto = Gestor.obtenerProductoMayorIngreso();
                                String productoMayorIngreso = producto.toString();
                                System.out.println(productoMayorIngreso);
                                break;
                            case 2:
                                int cantBebidasVendidas = Gestor.obtenerCantidadBebidasVendidas();
                                System.out.println("Cantidad de bebidas vendidas: " + cantBebidasVendidas);
                                break;
                            case 3:
                                int cantComidasVendidas = Gestor.obtenerCantidadComidasVendidas();
                                System.out.println("Cantidad de comidas vendidas: " + cantComidasVendidas);
                                break;
                            case 4:
                                ArrayList<Producto> productos = Gestor.obtenerProductosDisponibles();
                                System.out.println("Productos disponibles:");

                                for (Producto productoActual : productos) {
                                    System.out.println(productoActual);
                                }
                                break;
                            case 5:
                                Gestor.guardarReporteVentas();
                                System.out.println("Reporte de ventas guardado correctamente.");
                                break;
                            case 6:
                                menuAdmin();
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                        System.out.println("Desea volver al sub menú anterior?: (s/n)");
                        scanner.nextLine();
                        subContinuar = scanner.next().charAt(0);
                    }
                    break;
                case 4:
                    char subContinuar2 = 's';

                    while (subContinuar2 == 's') {
                        System.out.println("--------------------------------------");
                        System.out.println("Elija una opción referente a la gestión del stock.");
                        System.out.println("1. Leer y guardar stock en archivo.");
                        System.out.println("2. Modificar stock.");
                        System.out.println("3. Volver al menú del administrador.");
                        System.out.println("--------------------------------------");
                        int subOpcion = scanner.nextInt();

                        switch (subOpcion) {
                            case 1:
                                System.out.println("Stock inicial:");
                                Stock stock = Gestor.guardarYLeerStock();
                                String stockInicial = stock.toString();
                                System.out.println(stockInicial);
                                break;
                            case 2:
                                System.out.println("Stock actualizado luego de eliminar 50 de 'Lechuga':");
                                String stockActualizado = Gestor.modificarStock();
                                System.out.println(stockActualizado);
                                break;
                            case 3:
                                menuAdmin();
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                        System.out.println("Desea volver al sub menú anterior?: (s/n)");
                        scanner.nextLine();
                        subContinuar2 = scanner.next().charAt(0);
                    }
                    break;
                case 5:
                    char subContinuar3 = 's';
                    Cocinero cocineroAdmin = new Cocinero("Pedro", "Gomez", 65432134);

                    while (subContinuar3 == 's') {
                        System.out.println("--------------------------------------");
                        System.out.println("Elija una opción referente a la gestión de recetas.");
                        System.out.println("1. Guardar recetas en archivo.");
                        System.out.println("2. Leer recetas.");
                        System.out.println("3. Volver al menú del administrador.");
                        System.out.println("--------------------------------------");
                        int subOpcion = scanner.nextInt();

                        switch (subOpcion) {
                            case 1:
                                Gestor.guardarRecetas(cocineroAdmin);
                                System.out.println("Recetas guardadas correctamente.");
                                break;
                            case 2:
                                HashMap<String, Receta> recetas = Gestor.leerRecetas(cocineroAdmin);

                                if (recetas != null && !recetas.isEmpty()) {
                                    System.out.println("Recetas:");

                                    for (Map.Entry<String, Receta> entry : recetas.entrySet()) {
                                        String nombreReceta = entry.getKey();
                                        Receta receta = entry.getValue();
                                        System.out.println("Nombre: " + nombreReceta + ", Receta: " + receta);
                                    }
                                } else {
                                    System.out.println("No hay recetas disponibles. Primero debe cargarlas utilizando la opción 1 de este sub menú.");
                                }
                                break;
                            case 3:
                                menuAdmin();
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                        System.out.println("Desea volver al sub menú anterior?: (s/n)");
                        scanner.nextLine();
                        subContinuar3 = scanner.next().charAt(0);
                    }
                    break;
                case 6:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println("Desea volver al menú del administrador?: (s/n)");
            scanner.nextLine();
            continuar = scanner.next().charAt(0);

        }
    }


    public static void menuEmpleado() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Cocinero("Pedro", "Gomez", 65432134));
        empleados.add(new Mozo("Juan", "Perez", 12345678, 2019));
        empleados.add(new Gerente("Ana", "Lopez", 78912361));
        Stock stockGerente = Gestor.inicializarIngredientesYRecetas();

        System.out.println("--------------------------------------");
        System.out.println("MENÚ EMPLEADO:");

        System.out.println("Seleccione el tipo de empleado:");
        System.out.println("1. Cocinero.");
        System.out.println("2. Mozo.");
        System.out.println("3. Gerente.");
        System.out.println("4. Volver al menú principal.");
        System.out.println("--------------------------------------");
        int tipoEmpleado = scanner.nextInt();

        switch (tipoEmpleado) {
            case 1:
                menuCocinero((Cocinero) empleados.getFirst());
                break;
            case 2:
                menuMozo((Mozo) empleados.get(1), (Cocinero) empleados.getFirst(), stockGerente);
                break;
            case 3:
                menuGerente((Gerente) empleados.getLast(), stockGerente);
                break;
            case 4:
                menuPrincipal();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }


    private static void menuCocinero(Cocinero cocinero) {
        char continuar = 's';

        while (continuar == 's') {
            System.out.println("--------------------------------------");
            System.out.println("Menú Cocinero:");
            System.out.println("1. Guardar recetas en archivo.");
            System.out.println("2. Leer recetas.");
            System.out.println("3. Volver al menú de empleados.");
            System.out.println("--------------------------------------");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    HashMap<String, Receta> recetas = cocinero.agregarReceta("Ensalada", Gestor.getRecetaEnsalada());
                    recetas = cocinero.agregarReceta("Hamburguesa", Gestor.getRecetaHamburguesa());
                    cocinero.guardarRecetas(recetas);
                    System.out.println("Recetas guardadas correctamente.");
                    break;
                case 2:
                    cocinero.leerRecetas();
                    HashMap<String, Receta> recetasLeer = cocinero.leerRecetas();

                    if (recetasLeer != null && !recetasLeer.isEmpty()) {
                        System.out.println("Recetas:");

                        for (Map.Entry<String, Receta> entry : recetasLeer.entrySet()) {
                            String nombreReceta = entry.getKey();
                            Receta receta = entry.getValue();
                            System.out.println("Nombre: " + nombreReceta + ", Receta: " + receta);
                        }
                    } else {
                        System.out.println("No hay recetas disponibles. Primero debe cargarlas utilizando la opción 1 de este sub menú.");
                    }
                    break;
                case 3:
                    menuEmpleado();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println("Desea volver al menú del cocinero?: (s/n)");
            scanner.nextLine();
            continuar = scanner.next().charAt(0);
        }
    }

    private static void menuMozo(Mozo mozo, Cocinero cocinero, Stock stock) {
        char continuar = 's';
        Mesa mesa = new Mesa(3, mozo);

        while (continuar == 's') {
            System.out.println("--------------------------------------");
            System.out.println("Menú Mozo:");
            System.out.println("1. Asignar mozo a mesa.");
            System.out.println("2. Tomar pedido y enviar a cocinero.");
            System.out.println("3. Volver al menú de empleados.");
            System.out.println("--------------------------------------");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mozo.asignarMozoAMesa(mesa, mozo);
                    System.out.println("Mozo " + mozo.getNombre() + " " + mozo.getApellido() + " asignado a la mesa " + mesa.getIdMesa());
                    break;
                case 2:
                    mozo.tomarPedidoYenviarAcocinero(mesa, cocinero, stock);
                    System.out.println("Pedidos anotados y pasados al cocinero correctamente.");
                    break;
                case 3:
                    menuEmpleado();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            System.out.println("Desea volver al menú del mozo?: (s/n)");
            scanner.nextLine();
            continuar = scanner.next().charAt(0);
        }
    }

    private static void menuGerente(Gerente gerente, Stock stock) {
        char continuar = 's';

        while (continuar == 's') {
            System.out.println("--------------------------------------");
            System.out.println("Menú Gerente:");
            System.out.println("1. Leer stock.");
            System.out.println("2. Guardar stock en archivo.");
            System.out.println("3. Volver al menú de empleados.");
            System.out.println("--------------------------------------");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Stock actual:");
                    Stock stockALeer = gerente.leerStock();

                    if (stockALeer == null) {
                        System.out.println("Error: El archivo está vacío.");
                    } else {
                        String informacionStock = stockALeer.toString();
                        System.out.println(informacionStock);
                    }
                    break;
                case 2:
                    gerente.guardarStock(stock);
                    System.out.println("Stock guardado correctamente.");
                    break;
                case 3:
                    menuEmpleado();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            System.out.println("¿Desea volver al menú del gerente?: (s/n)");
            scanner.nextLine();
            continuar = scanner.next().charAt(0);
        }
    }
}
