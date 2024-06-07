package modelo;

import java.io.Serializable;

public class Ingrediente implements Serializable
{
    // ATRIBUTOS
    private String nombre;
    private int cantidad;

    // CONSTRUCTORES
    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // METODOS GETTER
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    // METODOS SETTER
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // METODO TOSTRING
    @Override
    public String toString() {
        return "Ingrediente{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}



