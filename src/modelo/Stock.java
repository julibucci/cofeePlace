package modelo;

import java.util.HashMap;

public class Stock
{
    // ATRIBUTOS
    private Map<String, Ingrediente> inventario;

    // CONSTRUCTOR
    public Stock()
    {
        this.inventario = new HashMap<>();
    }

    // METODOS
    // METODO AGREGAR INGREDIENTE
    public void agregarIngrediente(Ingrediente ingrediente) {
        inventario.put(ingrediente.getNombre(), inventario.getOrDefault(ingrediente.getNombre(), new Ingrediente(ingrediente.getNombre(), 0)));
        inventario.get(ingrediente.getNombre()).setCantidad(inventario.get(ingrediente.getNombre()).getCantidad() + ingrediente.getCantidad());
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

    // METODO TOSTRING
    @Override
    public String toString() {
        return "Stock{" +
                "inventario=" + inventario +
                '}';
    }
}


