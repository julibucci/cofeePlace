package Excepciones;

public class OrdenNoEncontradaException extends Exception {

    // Excepción para manejar pedidos no encontrados. Esto es para comprobar si un pedido que se quiere cancelar existe o no.
    public OrdenNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}