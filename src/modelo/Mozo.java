package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Mozo extends Empleado implements Serializable {
    private static int salarioBase=90000;
    private int añoDeIngreso;
    private int propinas;


    public Mozo(String nombre, String apellido, int dni, int añoDeIngreso) {
        super(nombre, apellido, dni);
        this.añoDeIngreso = añoDeIngreso;
        propinas=0;
    }

    public int getAñoDeIngreso() {
        return añoDeIngreso;
    }

    public void setPropinas(int propinas) {
        this.propinas = propinas;
    }

    @Override
    public double calcularSalario() {
        double resultado;
        int anios=2024-añoDeIngreso;

        if(anios<=2){
            resultado= salarioBase;
        } else if(anios<=3){
            resultado=salarioBase + (salarioBase*0.05);
        }else if(anios<=7){
            resultado=salarioBase + (salarioBase*0.1);
        }else if(anios<=15){
            resultado=salarioBase + (salarioBase*0.15);
        }else{
            resultado=salarioBase + (salarioBase*0.2);
        }
        return resultado+propinas;
    }

    @Override
    public String toString() {
        return "Mozo{" +
                "añoDeIngreso=" + añoDeIngreso +
                ", propinas=" + propinas +
                " salario " + calcularSalario() +
                '}';
    }

    public void asignarMozoAMesa(Mesa mesa, Mozo empleado){

        mesa.asignarMozo(empleado);
    }
    //Agarra el array de platos del pedido de una mesa en especifico y se los pasa de a uno al cocinero para que le
    //retorne una comida y con eso devuelve un array de comidas listas
    public ArrayList<Comida> tomarPedidoYenviarAcocinero(Mesa mesa, Cocinero cocinero, Stock stock){
        Pedido pedido=mesa.getMiPedido();
        Comida comida=null;
        ArrayList<Comida> comidas=new ArrayList<>();
        ArrayList<Producto> platos=pedido.getPedido(mesa.getIdMesa());
        for(Producto plato : platos){
            if(plato instanceof Comida){
                try{
                    comida= (Comida) cocinero.prepararPlato(((Comida)plato).getReceta(), stock);
                    comidas.add(comida);
                }catch (Exception e){

                }
            }
        }

        return comidas;
    }

}
