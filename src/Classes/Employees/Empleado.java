package Classes.Employees;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Empleado {
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

    public LocalDateTime getFechaYhora(){
        return fechaYhora;
    }
    public String getFechaHoraFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaYhora.format(formatter);
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
