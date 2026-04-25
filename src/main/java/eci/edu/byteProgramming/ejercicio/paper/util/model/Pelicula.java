package videoclub.model;

public abstract class Pelicula {
    private final String titulo;
    private final double precio;
    private boolean disponible;

    public Pelicula(String titulo, double precio, boolean disponible) {
        this.titulo = titulo;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getTitulo()              { return titulo; }
    public double getPrecio()              { return precio; }
    public boolean isDisponible()          { return disponible; }
    public void setDisponible(boolean d)   { this.disponible = d; }

    // Método abstracto: cada subclase define su tipo
    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("[%s] %s - $%.0f - %s",
                getTipo(), titulo, precio,
                disponible ? "Disponible" : "No disponible");
    }
}