package Clases.Item;

    public abstract class Producto
    {
        // ATRIBUTOS
        private String nombre;
        private double precio;
        private boolean disponibilidad;
        private boolean estado; // listo o no

        // CONSTRUCTOR
        public Producto ()
        {
            nombre = "";
            precio = 0.0;
            disponibilidad = true;
            estado = true;
        }

        public Producto(String nombre, double precio, boolean disponibilidad, boolean estado) {
            this.nombre = nombre;
            this.precio = precio;
            this.disponibilidad = disponibilidad;
            this.estado = estado;
        }

        // METODOS GETTER
        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public boolean isDisponibilidad() {
            return disponibilidad;
        }

        public boolean isEstado() {
            return estado;
        }

        // METODOS SETTER
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public void setDisponibilidad(boolean disponibilidad) {
            this.disponibilidad = disponibilidad;
        }

        public void setEstado(boolean estado) {
            this.estado = estado;
        }

        // METODO TO STRING
        @Override
        public String toString() {
            return "Producto{" +
                    "nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    ", disponibilidad=" + disponibilidad +
                    ", estado=" + estado +
                    '}';
        }
    }




