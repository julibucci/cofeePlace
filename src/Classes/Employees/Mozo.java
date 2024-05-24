package Classes.Employees;

public class Mozo extends Empleado {
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
}
