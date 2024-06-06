package modelo;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cocinero extends Empleado implements Serializable {
    private int cantidadDePlatos;
    private static int salarioBase=70000;
    private HashMap<String, Receta> recetas;

    public Cocinero(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        cantidadDePlatos=0;
        this.recetas = new HashMap<>();
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

    //Guardar recetas en un archivo
    public void guardarRecetas(HashMap<String, Receta> recetas) {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("recetas.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(recetas);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //leer recetas del archivo
    public HashMap<String, Receta> leerRecetas() {
        ObjectInputStream objectInputStream = null;
        HashMap<String, Receta> recetasLeidas = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("recetas.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);
            recetasLeidas = (HashMap<String, Receta>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            recetasLeidas = new HashMap<>();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return recetasLeidas;
    }

    // Método para agregar una nueva receta al mapa de recetas
    public HashMap<String, Receta> agregarReceta(String nombrePlato, Receta receta) {
        recetas.put(nombrePlato, receta);
        return recetas;
    }

    @Override
    public String toString() {
        return "Cocinero{" + super.toString() +
                "cantidadDePlatos=" + cantidadDePlatos +
                " salario " + calcularSalario()+
                '}';
    }
}