package modelo;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

public class Comida extends Producto implements Serializable
{
    // ATRIBUTOS
    private String tipo;// dulce o salado
    private boolean vegetariano;
    private Receta receta;

   // CONSTRUCTOR
    public Comida(String nombre, double precio, boolean disponibilidad, Estado estado, TipoProducto tipoProducto, String tipo, boolean vegetariano,Receta receta)
    {
        super(nombre, precio, disponibilidad, estado, tipoProducto);
        this.tipo = tipo;
        this.vegetariano = vegetariano;
        this.receta = receta;
    }

    // METODOS GETTER
    public String getTipo() throws ProductoNoDisponibleException {
        if (!isDisponibilidad()) {
            throw new ProductoNoDisponibleException("El producto de comida no esta disponible.");
        }
        return tipo;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    public Receta getReceta() {
        return receta;
    }

    // METODOS SETTER
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    // EXCEPCION
    public static class ProductoNoDisponibleException extends Exception {
        public ProductoNoDisponibleException(String mensaje) {
            super(mensaje);
        }
    }

    // METODO TO STRING
    @Override
    public String toString() {
        return super.toString() + "Comida{" +
                "tipo='" + tipo + '\'' +
                ", vegetariano=" + vegetariano +
                '}';
    }
}

