package Enum;

public enum Estado
{
    LISTO("Listo"),
    NO_LISTO("No Listo");

    private String descripcion;

    // CONSTRUCTOR PRIVADO
    private Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
