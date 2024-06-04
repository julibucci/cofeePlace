package modelo;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GestionEmpleado implements Serializable {

    private HashMap<Integer, Empleado> empleados;
    private String nombreArchivo = "Empleados.dat";

    public GestionEmpleado() {
        empleados = new HashMap<>();
        traerEmpleados();  // Traer a todos los empleados
    }

    public void agregarMozo(String nombre, String apellido, int dni, int añoDeIngreso) {
        Empleado empleado = new Mozo(nombre, apellido, dni, añoDeIngreso);
        empleados.put(dni, empleado);
        guardarEmpleados();
    }

    public void agregarCocinero(String nombre, String apellido, int dni) {
        Empleado empleado = new Cocinero(nombre, apellido, dni);
        empleados.put(dni, empleado);
        guardarEmpleados();
    }

    public void agregarGerente(String nombre, String apellido, int dni) {
        Empleado empleado = new Gerente(nombre, apellido, dni);
        empleados.put(dni, empleado);
        guardarEmpleados();
    }

    // Guarda todos los empleados del HashMap en el archivo
    private void guardarEmpleados() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            objectOutputStream.writeObject(empleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Trae todos los empleados del archivo al HashMap
    private void traerEmpleados() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            empleados = (HashMap<Integer, Empleado>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            // Si no se encuentra el archivo se genera un nuevo HashMap
            empleados = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Busca un empleado por DNI en el HashMap
    public Empleado buscarEmpleadoPorDNIEnHashMap(int dni) {
        return empleados.get(dni);
    }

    // Muestra todos los empleados


    public HashMap<Integer, Empleado> getEmpleados() {
        return empleados;
    }

    // Busca un empleado por DNI directamente en el archivo
    public Empleado buscarEmpleadoPorDNIEnArchivo(int dni) {
        Empleado empleadoEncontrado = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            HashMap<Integer, Empleado> empleadosArchivo = (HashMap<Integer, Empleado>) objectInputStream.readObject();
            empleadoEncontrado = empleadosArchivo.get(dni);
        } catch (FileNotFoundException e) {
            // Archivo no encontrado, no hay empleados guardados
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return empleadoEncontrado;
    }

    public Empleado logearEmpleado(int dni) {
        Empleado empleado = buscarEmpleadoPorDNIEnHashMap(dni);
        return empleado;
    }


}









