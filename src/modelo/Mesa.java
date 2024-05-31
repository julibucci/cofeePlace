package modelo;

import Excepciones.OrdenNoEncontradaException;

public class Mesa {

    // Clase Mesa que gestiona un pedido y un empleado asignado
    private Mozo mozoAsignado;
    private Pedido miPedido;
    private int idMesa;

    public Mesa(int idMesa, Mozo mozoAsignado) {
        this.idMesa = idMesa;
        this.mozoAsignado = mozoAsignado;
        this.miPedido = new Pedido();
    }

    public Mozo getMozoAsignado() {

        return mozoAsignado;
    }

    public void asignarMozo(Mozo mozo) {
        this.mozoAsignado = mozo;
    }

    public Pedido getMiPedido() {
        return miPedido;
    }

    public void setMiPedido(Pedido miPedido) {
        this.miPedido = miPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void agregarPlatoAlPedido(Producto plato) {
        miPedido.agregarPlato(idMesa, plato);
    }

    public void eliminarPlatoDelPedido(Producto plato) {
        miPedido.eliminarPlato(idMesa, plato);
    }

    public void cancelarPedido() throws OrdenNoEncontradaException {
        miPedido.cancelarPedido(idMesa);
    }

    public double calcularTotalPedido() {
        return miPedido.calcularTotal(idMesa);
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "idMesa=" + idMesa +
                ", empleadoAsignado=" + mozoAsignado.getNombre() +
                ", miPedido=" + miPedido +
                '}';
    }
}
