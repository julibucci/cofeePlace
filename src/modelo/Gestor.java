package modelo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gestor {

    // Ingredientes
    private static Ingrediente carne;
    private static Ingrediente lechuga;
    private static Ingrediente tomate;
    private static Ingrediente queso;
    private static Ingrediente jamon;
    private static Ingrediente harina;
    private static Ingrediente huevo;
    private static Ingrediente pan;
    private static Ingrediente salsa;
    private static Ingrediente aceitunas;
    private static Ingrediente pollo;
    private static Ingrediente papas;
    private static Ingrediente leche;
    private static Ingrediente azucar;
    private static Ingrediente crema;
    private static Ingrediente chocolate;

    // Recetas
    private static ArrayList<Ingrediente> ingredientesPizza = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesHamburguesa = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesRavioles = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesMilanesa = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesTarta = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesTostados = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesEnsalada = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesHelado = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesTorta = new ArrayList<>();
    private static ArrayList<Ingrediente> ingredientesFlan = new ArrayList<>();

    private static Receta recetaPizza;
    private static Receta recetaHamburguesa;
    private static Receta recetaRavioles;
    private static Receta recetaMilanesa;
    private static Receta recetaTarta;
    private static Receta recetaTostados;
    private static Receta recetaEnsalada;
    private static Receta recetaHelado;
    private static Receta recetaTorta;
    private static Receta recetaFlan;
    private static HashMap<String, Receta> listaRecetas = new HashMap<>();

    // Reporte de ventas
    private static HashMap<Integer, ArrayList<Producto>> ventas = new HashMap<>();
    private static ReporteVenta reporteVenta;

    // Stock
    private static Stock stock = new Stock();

    private String nombreArchvioEmpleados = "empleados.dat";

    // Se crean y se cargan los ingredientes y recetas una vez antes de cualquier operación
    public static Stock inicializarIngredientesYRecetas()
    {
        // Carga de ingredientes individules
        carne = new Ingrediente("Carne", 1300);
        lechuga = new Ingrediente("Lechuga", 1250);
        tomate = new Ingrediente("Tomate", 2100);
        queso = new Ingrediente("Queso", 3200);
        jamon = new Ingrediente("Jamón", 1150);
        harina = new Ingrediente("Harina", 4500);
        huevo = new Ingrediente("Huevo", 2100);
        pan = new Ingrediente("Pan", 1150);
        salsa = new Ingrediente("Salsa", 875);
        aceitunas = new Ingrediente("Aceitunas", 3000);
        pollo = new Ingrediente("Pollo", 3250);
        papas = new Ingrediente("Papas", 1200);
        leche = new Ingrediente("Leche", 5200);
        azucar = new Ingrediente("Azúcar", 4100);
        crema = new Ingrediente("Crema", 3150);
        chocolate = new Ingrediente("Chocolate", 2100);

        // Carga de ingredientes por producto
        ingredientesPizza.add(harina);
        ingredientesPizza.add(queso);
        ingredientesPizza.add(salsa);
        ingredientesPizza.add(aceitunas);

        ingredientesHamburguesa.add(carne);
        ingredientesHamburguesa.add(lechuga);
        ingredientesHamburguesa.add(tomate);
        ingredientesHamburguesa.add(queso);
        ingredientesHamburguesa.add(pan);

        ingredientesRavioles.add(harina);
        ingredientesRavioles.add(queso);
        ingredientesRavioles.add(huevo);

        ingredientesMilanesa.add(carne);
        ingredientesMilanesa.add(harina);
        ingredientesMilanesa.add(huevo);
        ingredientesMilanesa.add(papas);

        ingredientesTarta.add(harina);
        ingredientesTarta.add(queso);
        ingredientesTarta.add(jamon);
        ingredientesTarta.add(huevo);

        ingredientesTostados.add(pan);
        ingredientesTostados.add(queso);
        ingredientesTostados.add(jamon);

        ingredientesEnsalada.add(lechuga);
        ingredientesEnsalada.add(tomate);
        ingredientesEnsalada.add(aceitunas);

        ingredientesHelado.add(leche);
        ingredientesHelado.add(crema);
        ingredientesHelado.add(azucar);

        ingredientesTorta.add(harina);
        ingredientesTorta.add(huevo);
        ingredientesTorta.add(azucar);
        ingredientesTorta.add(chocolate);

        ingredientesFlan.add(leche);
        ingredientesFlan.add(huevo);
        ingredientesFlan.add(azucar);

        // Carga de recetas
        recetaPizza = new Receta("Pizza Muzzarella", ingredientesPizza);
        recetaHamburguesa = new Receta("Hamburguesa Triple", ingredientesHamburguesa);
        recetaRavioles = new Receta("Ravioles", ingredientesRavioles);
        recetaMilanesa = new Receta("Milanesas a la Napolitana", ingredientesMilanesa);
        recetaTarta = new Receta("Tarta de Jamón y Queso", ingredientesTarta);
        recetaTostados = new Receta("Tostados", ingredientesTostados);
        recetaEnsalada = new Receta("Ensalada", ingredientesEnsalada);
        recetaHelado = new Receta("Helado", ingredientesHelado);
        recetaTorta = new Receta("Tortas", ingredientesTorta);
        recetaFlan = new Receta("Flan", ingredientesFlan);

        // Carga de "lista" (HashMap) de recetas
        listaRecetas.put(recetaPizza.getNombrePlato(), recetaPizza);
        listaRecetas.put(recetaHamburguesa.getNombrePlato(), recetaHamburguesa);
        listaRecetas.put(recetaRavioles.getNombrePlato(), recetaRavioles);
        listaRecetas.put(recetaMilanesa.getNombrePlato(), recetaMilanesa);
        listaRecetas.put(recetaTarta.getNombrePlato(), recetaTarta);
        listaRecetas.put(recetaTostados.getNombrePlato(), recetaTostados);
        listaRecetas.put(recetaEnsalada.getNombrePlato(), recetaEnsalada);
        listaRecetas.put(recetaHelado.getNombrePlato(), recetaHelado);
        listaRecetas.put(recetaTorta.getNombrePlato(), recetaTorta);
        listaRecetas.put(recetaFlan.getNombrePlato(), recetaFlan);

        // Carga de stock de ingredientes
        stock.agregarIngrediente(carne);
        stock.agregarIngrediente(lechuga);
        stock.agregarIngrediente(tomate);
        stock.agregarIngrediente(queso);
        stock.agregarIngrediente(jamon);
        stock.agregarIngrediente(harina);
        stock.agregarIngrediente(huevo);
        stock.agregarIngrediente(pan);
        stock.agregarIngrediente(salsa);
        stock.agregarIngrediente(aceitunas);
        stock.agregarIngrediente(pollo);
        stock.agregarIngrediente(papas);
        stock.agregarIngrediente(leche);
        stock.agregarIngrediente(azucar);
        stock.agregarIngrediente(crema);
        stock.agregarIngrediente(chocolate);

        return stock;
    }

    // Getters para las recetas. Usados en clase Menú
    public static Receta getRecetaPizza() {
        return recetaPizza;
    }

    public static Receta getRecetaHamburguesa() {
        return recetaHamburguesa;
    }

    public static Receta getRecetaRavioles() {
        return recetaRavioles;
    }

    public static Receta getRecetaMilanesa() {
        return recetaMilanesa;
    }

    public static Receta getRecetaTarta() {
        return recetaTarta;
    }

    public static Receta getRecetaTostado() {
        return recetaTostados;
    }

    public static Receta getRecetaEnsalada() {
        return recetaEnsalada;
    }

    public static Receta getRecetaHelado() {
        return recetaHelado;
    }

    public static Receta getRecetaTorta() {
        return recetaTorta;
    }

    public static Receta getRecetaFlan() {
        return recetaFlan;
    }

    public static Receta obtenerRecetaPorNombreProducto(String nombreProducto) {
        return listaRecetas.get(nombreProducto);
    }

    public static HashMap<String, Receta> getListaRecetas()
    {
        return listaRecetas;
    }

    public static HashMap<Integer, ArrayList<Producto>> getVentas()
    {
        return ventas;
    }

    // Métodos de mozo y mesa (LLama a métodos de las clases Mozo y Mesa según corresponde)
    public static void anotarPedidos(ArrayList<Producto> pedidos) {

        // Se asigna un nuevo ID a la mesa. "Ventas.size" devuelve la cantidad de keys del mapa. En su primer uso, esta cantidad será 0, por lo que el ID de la priemr mesa será 1, y así sucesivamente
        int mesaId = ventas.size() + 1;

        ventas.put(mesaId, pedidos);

        // Crea una nueva instancia de Mesa con el ID y el mozo asignado
        Mozo mozoAsignado = new Mozo("Juan", "Perez", 12345678, 2019);
        Mesa mesa = new Mesa(mesaId, mozoAsignado);

        Cocinero cocinero = new Cocinero("Pedro", "Gomez", 65432134);

        // Se hace el pase de manos de lo que tiene anotado el mozo a cocinero
        ArrayList<Comida> comidasPreparadas = mozoAsignado.tomarPedidoYenviarAcocinero(mesa, cocinero, stock);

        // Imprime las comidas preparadas. Es lo que tiene anotado el mozo
        for (Comida comida : comidasPreparadas) {
            System.out.println("Comida preparada: " + comida.getNombre());
        }

        // Actualiza el reporte de ventas con la información actualizada del mapa de ventas
        reporteVenta = new ReporteVenta<>(ventas);

    }

    // Métodos de reporte de venta (cada uno llama a los métodos de la clase Reporte Venta según corresponde)
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

    public static Producto obtenerProductoMasVendido() {
        if (reporteVenta == null) {
            throw new IllegalStateException("Primero anote los pedidos.");
        }
        return reporteVenta.obtenerProductoMasVendido();
    }

    public static Producto obtenerProductoMayorIngreso() {
        if (reporteVenta == null) {
            throw new IllegalStateException("Primero anote los pedidos.");
        }
        return reporteVenta.obtenerProductoConMayorIngreso();
    }

    public static ArrayList<Producto> obtenerProductosPedidos() {
        if (reporteVenta == null) {
            throw new IllegalStateException("Primero anote los pedidos.");
        }
        return reporteVenta.listarProductosPedidos();
    }

    public static void guardarReporteVentas() {
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
    public static String leerReporteVentas() {
        String infoJson = " ";
        try {
             infoJson = JsonUtiles.leer("reporte_ventas");
        } catch (Exception e) {
            throw new IllegalStateException("Error al leer el reporte de ventas: " + e.getMessage());
        }
        return infoJson;
    }


    // Metodos de stock (cada uno llama a los métodos de la clase Stock según corresponde)
    public static String modificarStock(Gerente gerente, ArrayList<Ingrediente> ingredientes) {
        try {
            return gerente.modificarStock(ingredientes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void guardarStock(Gerente gerente, Stock stock) {
        gerente.guardarStock(stock);
    }

    public static Stock leerStock(Gerente gerente) {
        Stock nuevoStock = gerente.leerStock();
        return nuevoStock;
    }


    // Métodos de recetas (cada uno llama a los métodos de la clase Cocinero según corresponde)
    public static void guardarRecetas(Cocinero cocinero) {
        for (Map.Entry<String, Receta> entry : listaRecetas.entrySet()) {
            cocinero.agregarReceta(entry.getKey(), entry.getValue());
        }

        cocinero.guardarRecetas(listaRecetas);
    }

    public static HashMap<String, Receta> leerRecetas(Cocinero cocinero) {
        return cocinero.leerRecetas();
    }

    public static void guardarEmpleados(ArrayList<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleados.dat"))) {
            oos.writeObject(empleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar empleados desde archivo
    @SuppressWarnings("unchecked")
    public static ArrayList<Empleado> cargarEmpleados() {
        File file = new File("empleados.dat");
        if (!file.exists()) {
            return new ArrayList<>(); // Retornar lista vacía si no existe el archivo
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.dat"))) {
            return (ArrayList<Empleado>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static ArrayList<Empleado> leerEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.dat"))) {
            // Leer el objeto que contiene la lista de empleados
            Object obj = ois.readObject();

            // Verificar si el objeto es una lista de empleados
            if (obj instanceof ArrayList<?>) {

                ArrayList<Empleado> lista = (ArrayList<Empleado>) obj;
                empleados.addAll(lista); // Agregar todos los empleados a la lista principal
            } else {
                System.err.println("El archivo no contiene una lista de empleados.");
            }
        } catch (EOFException e) {
            // Se alcanzó el final del archivo, no hay más objetos que leer
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo de empleados: " + e.getMessage());
        }

        return empleados;
    }
}
