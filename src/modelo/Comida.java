package modelo;

import java.util.ArrayList;

import java.util.List;

public class Comida extends Producto
{
    // ATRIBUTOS
    private String tipo;
    private boolean vegetariano;

   // CONSTRUCTOR
    public Comida(String nombre, double precio, boolean disponibilidad, boolean estado, String tipo, boolean vegetariano)
    {
        super(nombre, precio, disponibilidad, estado);
        this.tipo = tipo;
        this.vegetariano = vegetariano;
    }

    // METODOS GETTER
    public String getTipo() throws ProductoNoDisponibleException {
        if (!isDisponibilidad()) {
            throw new ProductoNoDisponibleException("El producto de comida no está disponible.");
        }
        return tipo;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    // METODOS SETTER
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
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

