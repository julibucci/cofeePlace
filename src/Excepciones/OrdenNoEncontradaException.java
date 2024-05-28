package Excepciones;

public class OrdenNoEncontradaException extends Exception {

    // Excepción para manejar pedidos no encontrados
    public OrdenNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}