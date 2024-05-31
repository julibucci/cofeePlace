package modelo;

public class Menu
{
    @Override
    public String toString()
    {
        //Comidas tienen recetas. Bebidas no, por lo que se pueden tener n bebidas.

        return "COMIDAS:\n" +
                "Pizza Muzzarella" + " ---------------------- \n" +
                "Hamburguesa Triple" + " -------------------- \n" +
                "Ravioles" + " ------------------------------ \n" +
                "Milanesas a la Napolitana" + " ------------- \n" +
                "Tarta de Jamón y Queso" + " ---------------- \n" +
                "Tostados" + " ------------------------------ \n" +
                "Ensalada" + " ------------------------------ \n" +
                "--------------------------------------------------------\n" +
                "BEBIDAS:\n" +
                "Coca Cola" + " --------------------------- \n" +
                "Cerveza Heineken" + " -------------------- \n" +
                "Agua Mineral" + " ------------------------ \n" +
                "Café" + " -------------------------------- \n" +
                "--------------------------------------------------------\n" +
                "POSTRES:\n" +
                "Helado" + " ------------------------------ \n" +
                "Tortas" + " ------------------------------ \n" +
                "Flan" + " -------------------------------- \n";

    }
}
