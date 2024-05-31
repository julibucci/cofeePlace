package modelo;

import Excepciones.OrdenNoEncontradaException;

public class Mesa {

    // Clase Mesa que gestiona un pedido y un empleado asignado
    private Empleado empleadoAsignado;
    private Pedido miPedido;
    private int idMesa;

    public Mesa(int idMesa, Empleado empleadoAsignado) {
        this.idMesa = idMesa;
        this.empleadoAsignado = empleadoAsignado;
        this.miPedido = new Pedido();
    }
    public Empleado getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public void setEmpleadoAsignado(Empleado empleadoAsignado) {
        this.empleadoAsignado = empleadoAsignado;
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
                ", empleadoAsignado=" + empleadoAsignado.getNombre() +
                ", miPedido=" + miPedido +
                '}';
    }
}
