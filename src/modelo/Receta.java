package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Receta implements Serializable {
    private String nombrePlato;
    private ArrayList<Ingrediente> ingredientes;

    public Receta(String nombrePlato, ArrayList<Ingrediente> ingredientes) {
        this.nombrePlato = nombrePlato;
        this.ingredientes = ingredientes;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "nombrePlato='" + nombrePlato + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}