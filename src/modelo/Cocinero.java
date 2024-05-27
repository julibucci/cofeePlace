package modelo;


public class Cocinero extends Empleado{
    private int cantidadDePlatos;
    private static int salarioBase=70000;

    public Cocinero(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        cantidadDePlatos=0;
    }

    public void setCantidadDePlatos(int cantidadDePlatos) {
        this.cantidadDePlatos = cantidadDePlatos;
    }

    @Override
    public double calcularSalario() {
        double resultado;
        resultado= cantidadDePlatos*200;
        if(resultado<salarioBase){
            resultado=salarioBase;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Cocinero{" +
                "cantidadDePlatos=" + cantidadDePlatos +
                " salario " + calcularSalario()+
                '}';
    }
}