package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Gerente extends Empleado {
    private static int salario=150000;

    public Gerente(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString() +" salario: " + calcularSalario();
    }
}
