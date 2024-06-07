package modelo;

import java.io.Serializable;
import java.util.List;

public class Bebida extends Producto implements Serializable
{
    // ATRIBUTOS
    private String tipo;
    private String tamanio; // Puede ser chico,mediano o grande
    private boolean alcoholica;

    // CONSTRUCTOR
    public Bebida(String nombre, double precio, boolean disponibilidad, Estado estado, TipoProducto tipoProducto, String tipo, String tamanio, boolean alcoholica)
    {
        super(nombre, precio, disponibilidad, estado, tipoProducto);
        this.tipo = tipo;
        this.tamanio = tamanio;
        this.alcoholica = alcoholica;
    }

    // METODOS GETTER
    public String getTipo() {
        return tipo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public boolean isAlcoholica() {
        return alcoholica;
    }

    // METODOS SETTER
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTamanio(String tamaño) {
        this.tamanio = tamanio;
    }

    public void setAlcoholica(boolean alcoholica) {
        this.alcoholica = alcoholica;
    }

    // METODO TO STRING
    @Override
    public String toString() {
        return super.toString() + " - " + getTipoProducto() +"{" +
                "tipo = '" + tipo + '\'' +
                ", tamanio = '" + tamanio + '\'' +
                '}';
    }

    // METODO PARA CAMBIAR EL TAMANIO DE LA BEBIDA
    public void cambiarTamanio(String nuevoTamanio) {
        this.tamanio = nuevoTamanio;
    }
}

