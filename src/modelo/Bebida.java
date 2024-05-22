package modelo;

import java.util.List;

public class Bebida extends Producto
{
    // ATRIBUTOS
    private String tipo; // dulce o salado
    private String tamanio; // Puede ser chico,mediano o grande

    // CONSTRUCTOR
    public Bebida(String nombre, double precio, boolean disponibilidad, boolean estado, String tipo, String tamanio)
    {
        super(nombre, precio, disponibilidad, estado);
        this.tipo = tipo;
        this.tamanio = tamanio;
    }

    // METODOS GETTER
    public String getTipo() {
        return tipo;
    }

    public String getTamaño() {
        return tamanio;
    }

    // METODOS SETTER
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTamaño(String tamaño) {
        this.tamanio = tamaño;
    }

}

