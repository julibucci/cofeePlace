package Enum;

public enum TipoProducto
{
    COMIDA("Comida"),
    BEBIDA("Bebida");

    private String descripcion;

    // CONSTRUCTOR PRIVADO
    private TipoProducto(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }
}
