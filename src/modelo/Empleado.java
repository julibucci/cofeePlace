package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Empleado implements Serializable {
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDateTime fechaYhora;

    public Empleado(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaYhora = LocalDateTime.now();
    }

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public String getFechaHoraFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaYhora.format(formatter);
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", fechaYhora=" + fechaYhora +
                '}';
    }

    public abstract double calcularSalario();
}