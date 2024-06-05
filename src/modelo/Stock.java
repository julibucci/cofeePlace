package modelo;
import java.io.Serializable;
import java.util.HashMap;

public class Stock implements Serializable
{
    // ATRIBUTOS
    private HashMap<String, Ingrediente> inventario;

    // CONSTRUCTOR
    public Stock()
    {
        this.inventario = new HashMap<>();
    }

    // METODOS
    // METODO AGREGAR INGREDIENTE
    public void agregarIngrediente(Ingrediente ingrediente)
    {
        String nombre = ingrediente.getNombre();
        int cantidad = ingrediente.getCantidad();

        if (inventario.containsKey(nombre)) {
            Ingrediente existente = inventario.get(nombre);
            existente.setCantidad(existente.getCantidad() + cantidad);
        } else {
            inventario.put(nombre, new Ingrediente(nombre, cantidad));
        }
    }

    // METODO ELIMINAR INGREDIENTE
    public void eliminarIngrediente(String nombre, int cantidad) throws Exception
    {
        if (inventario.containsKey(nombre))
        {
            Ingrediente ingrediente = inventario.get(nombre);
            int nuevaCantidad = ingrediente.getCantidad() - cantidad;
            if (nuevaCantidad < 0)
            {
                throw new Exception("No hay suficiente cantidad del ingrediente: " + nombre);
            } else
            {
                ingrediente.setCantidad(nuevaCantidad);
                if (nuevaCantidad == 0)
                {
                    inventario.remove(nombre);
                }
            }
        } else
        {
            throw new Exception("Ingrediente no encontrado: " + nombre);
        }
    }

    // METODO GET CANTIDAD
    public int getCantidad(String nombre) {
        return inventario.getOrDefault(nombre, new Ingrediente(nombre, 0)).getCantidad();
    }

    public HashMap<String, Ingrediente> getInventario() {
        return inventario;
    }

    // METODO TOSTRING
    @Override
    public String toString() {
        return "Stock{" +
                "inventario=" + inventario +
                '}';
    }
}


