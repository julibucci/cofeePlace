package modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cocinero extends Empleado implements Serializable {
    private int cantidadDePlatos;
    private static int salarioBase=70000;

    public Cocinero(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        cantidadDePlatos=0;
    }

    public void setCantidadDePlatos(int cantidadDePlatos) {
        this.cantidadDePlatos = cantidadDePlatos;
    }

    @Override
    public double calcularSalario() {
        double resultado;
        resultado= cantidadDePlatos*200;
        if(resultado<salarioBase){
            resultado=salarioBase;
        }
        return resultado;
    }
    //Recibe una receta, se fija en el stock si hay suficientes ingredientes y crea y devuelve una comida lista
    public Producto prepararPlato(Receta receta, Stock stock) {
        Producto platoPreparado = null;
        try {
            ArrayList<Ingrediente> ingredientesNecesarios = receta.getIngredientes();

            for (Ingrediente ingrediente : ingredientesNecesarios) {
                int cantidadNecesaria = ingrediente.getCantidad();
                int cantidadDisponible = stock.getCantidad(ingrediente.getNombre());

                if (cantidadDisponible < cantidadNecesaria) {
                    throw new Exception("No hay suficiente cantidad de " + ingrediente.getNombre() + " para preparar el plato.");
                }
            }
            for (Ingrediente ingrediente : ingredientesNecesarios) {
                stock.eliminarIngrediente(ingrediente.getNombre(), ingrediente.getCantidad());
            }
            cantidadDePlatos++;
            platoPreparado = new Comida(receta.getNombrePlato(), 0 , true, Producto.Estado.LISTO, Producto.TipoProducto.COMIDA, "Dulce", false, receta);


        } catch (Exception e) {
            e.getMessage();
        }
        return platoPreparado;
    }

    @Override
    public String toString() {
        return "Cocinero{" + super.toString() +
                "cantidadDePlatos=" + cantidadDePlatos +
                " salario " + calcularSalario()+
                '}';
    }
}