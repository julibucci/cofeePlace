package modelo;

import java.io.Serializable;

public abstract class Producto implements Serializable
{
    // ATRIBUTOS
    private String nombre;
    private double precio;
    private boolean disponibilidad;
    private Estado estado;
    private TipoProducto tipoProducto;

    // ENUMERACION
    public enum Estado {
        LISTO, NO_LISTO
    }

    public enum TipoProducto{
        COMIDA, BEBIDA
    }

    // CONSTRUCTOR
    public Producto ()
    {
        nombre = "";
        precio = 0.0;
        disponibilidad = true;
        estado = Estado.LISTO;
    }

    public Producto(String nombre, double precio, boolean disponibilidad, Estado estado, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.estado = estado;
        this.tipoProducto = tipoProducto;
    }

    // METODOS GETTER
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }
    public TipoProducto getTipoProducto()
    {
        return tipoProducto;
    }

    // METODOS SETTER
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }



    // METODO TO STRING
    @Override
    public String toString() {
        return "PRODUCTO{" +
                "nombre = '" + nombre + '\'' +
                ", precio = " + precio +
                ", disponibilidad = " + disponibilidad +
                ", estado = " + estado +
                '}';
    }
}




