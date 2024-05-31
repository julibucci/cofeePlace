package modelo;


import java.util.List;

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

    public Producto prepararPlato(Receta receta, Stock stock) throws Exception {
        List<Ingrediente> ingredientesNecesarios = receta.getIngredientes();
        for (Ingrediente ingrediente : ingredientesNecesarios) {
            stock.eliminarIngrediente(ingrediente.getNombre(), ingrediente.getCantidad());
        }
        cantidadDePlatos++;
        return new Comida(receta.getNombrePlato(), 0 , true, Producto.Estado.LISTO, "preparado", false, receta); // Precio y otros detalles se pueden ajustar
    }

    @Override
    public String toString() {
        return "Cocinero{" + super.toString() +
                "cantidadDePlatos=" + cantidadDePlatos +
                " salario " + calcularSalario()+
                '}';
    }
}