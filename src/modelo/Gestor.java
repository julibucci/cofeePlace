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

    // Se crean y se cargan los ingredientes y recetas una vez antes de cualquier operación
    public static Stock inicializarIngredientesYRecetas()
    {
        // Carga de ingredientes individules
        carne = new Ingrediente("Carne", 300);
        lechuga = new Ingrediente("Lechuga", 250);
        tomate = new Ingrediente("Tomate", 100);
        queso = new Ingrediente("Queso", 200);
        jamon = new Ingrediente("Jamón", 150);
        harina = new Ingrediente("Harina", 500);
        huevo = new Ingrediente("Huevo", 100);
        pan = new Ingrediente("Pan", 50);
        salsa = new Ingrediente("Salsa", 75);
        aceitunas = new Ingrediente("Aceitunas", 30);
        pollo = new Ingrediente("Pollo", 350);
        papas = new Ingrediente("Papas", 200);
        leche = new Ingrediente("Leche", 200);
        azucar = new Ingrediente("Azúcar", 100);
        crema = new Ingrediente("Crema", 150);
        chocolate = new Ingrediente("Chocolate", 100);

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
}
