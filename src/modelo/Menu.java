package modelo;

public class Menu
{
    public Menu()
    {

    }
    @Override
    public String toString()
    {
        //Comidas tienen recetas. Bebidas no, por lo que se pueden tener n bebidas.

        return "COMIDAS:\n" +
                "Pizza Muzzarella" + " ---------------------- " +
                "Hamburguesa Triple" + " -------------------- " +
                "Ravioles" + " ------------------------------ " +
                "Milanesas a la Napolitana" + " ------------- " +
                "Tarta de Jamón y Queso" + " ---------------- " +
                "Tostados" + " ------------------------------ " +
                "Ensalada" + " ------------------------------ " +
                "--------------------------------------------------------\n" +
                "BEBIDAS:\n" +
                "Coca Cola" + " --------------------------- " +
                "Cerveza Heineken" + " -------------------- " +
                "Agua Mineral" + " ------------------------ " +
                "Café" + " -------------------------------- " +
                "--------------------------------------------------------\n" +
                "POSTRES:\n" +
                "Helado" + " ------------------------------ " +
                "Tortas" + " ------------------------------ " +
                "Flan" + " -------------------------------- ";

    }
\}
