package modelo;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, Producto> productos;

    public Menu() {
        productos = new HashMap<>();
        inicializarProductos();
    }

    private void inicializarProductos() {
        // Inicializar productos con los precios correspondientes
        productos.put("Pizza Muzzarella", new Comida("Pizza Muzzarella", 8.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Principal", false, Gestor.getRecetaPizza()));
        productos.put("Hamburguesa Triple", new Comida("Hamburguesa Triple", 10.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Rápida", false, Gestor.getRecetaHamburguesa()));
        productos.put("Ravioles", new Comida("Ravioles", 12.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Pastas", false, Gestor.getRecetaRavioles()));
        productos.put("Milanesas a la Napolitana", new Comida("Milanesas a la Napolitana", 11.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Principal", false, Gestor.getRecetaMilanesa()));
        productos.put("Tarta de Jamón y Queso", new Comida("Tarta de Jamón y Queso", 7.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Principal", false, Gestor.getRecetaTarta()));
        productos.put("Tostados", new Comida("Tostados", 5.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Rápida", false, Gestor.getRecetaTostado()));
        productos.put("Ensalada", new Comida("Ensalada", 6.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Ligera", true, Gestor.getRecetaEnsalada()));
        productos.put("Coca Cola", new Bebida("Coca Cola", 1.50, true, Producto.Estado.LISTO, Producto.TipoProducto.BEBIDA, "Dulce", "Grande", false));
        productos.put("Cerveza Heineken", new Bebida("Cerveza Heineken", 2.50, true, Producto.Estado.LISTO, Producto.TipoProducto.BEBIDA, "Amarga", "Mediano", true));
        productos.put("Agua Mineral", new Bebida("Agua Mineral", 1.00, true, Producto.Estado.LISTO, Producto.TipoProducto.BEBIDA, "Sin sabor", "Pequeño", false));
        productos.put("Café", new Bebida("Café", 1.20, true, Producto.Estado.LISTO, Producto.TipoProducto.BEBIDA, "Amargo", "Pequeño", false));
        productos.put("Helado", new Comida("Helado", 3.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Dulce", true, Gestor.getRecetaHelado()));
        productos.put("Tortas", new Comida("Tortas", 4.00, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Dulce", false, Gestor.getRecetaTorta()));
        productos.put("Flan", new Comida("Flan", 2.50, true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Dulce", false, Gestor.getRecetaFlan()));
    }

    public Producto getProductoPorNombre(String nombre) {
        return productos.get(nombre);
    }

    @Override
    public String toString() {
        return "COMIDAS:\n" +
                "Pizza Muzzarella ----------------------  $8.00\n" +
                "Hamburguesa Triple -------------------- $10.00\n" +
                "Ravioles ------------------------------ $12.00\n" +
                "Milanesas a la Napolitana ------------- $11.00\n" +
                "Tarta de Jamón y Queso ---------------- $7.00\n" +
                "Tostados ------------------------------ $5.00\n" +
                "Ensalada ------------------------------ $6.00\n" +
                "--------------------------------------------------------\n" +
                "BEBIDAS:\n" +
                "Coca Cola --------------------------- $1.50\n" +
                "Cerveza Heineken -------------------- $2.50\n" +
                "Agua Mineral ------------------------ $1.00\n" +
                "Café -------------------------------- $1.20\n" +
                "--------------------------------------------------------\n" +
                "POSTRES:\n" +
                "Helado ------------------------------ $3.00\n" +
                "Tortas ------------------------------ $4.00\n" +
                "Flan -------------------------------- $2.50\n" +
                "---------------------------------------------------------";
    }
}
