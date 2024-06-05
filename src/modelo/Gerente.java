package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Gerente extends Empleado implements Serializable {
    private static int salario=150000;

    public Gerente(String nombre, String apellido, int dni) {

        super(nombre, apellido, dni);
    }

    @Override
    public double calcularSalario() {

        return salario;
    }

    // Método para guardar el stock en un archivo
    public void guardarStock(Stock stock) {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("stock.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stock);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para leer el stock desde un archivo
    public Stock leerStock() {
        ObjectInputStream objectInputStream = null;
        Stock stock = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("stock.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);
            stock = (Stock) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            stock = new Stock();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return stock;
    }
    @Override
    public String toString() {

        return super.toString() +" salario: " + calcularSalario();
    }
}
