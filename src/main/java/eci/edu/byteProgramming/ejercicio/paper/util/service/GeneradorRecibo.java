package videoclub.service;

import videoclub.enums.TipoMembresia;
import videoclub.model.Pelicula;
import java.util.List;

public class GeneradorRecibo {

    public void imprimir(TipoMembresia membresia, List<Pelicula> peliculas,
                         double subtotal, double descuento, double total) {
        System.out.println("\n--- RECIBO DE ALQUILER ---");
        System.out.println("Cliente: " + membresia.name());
        System.out.println("Peliculas:");
        for (Pelicula p : peliculas) {
            System.out.printf(" - %s (%s) - $%.0f%n",
                    p.getTitulo(), p.getTipo(), p.getPrecio());
        }
        System.out.printf("Subtotal: $%.0f%n", subtotal);
        if (descuento > 0) {
            System.out.printf("Descuento (%.0f%%): $%.0f%n",
                    membresia.getDescuento() * 100, descuento);
        }
        System.out.printf("Total a pagar: $%.0f%n", total);
        System.out.println("--------------------------");
        System.out.println("¡Disfrute su pelicula!");
    }
}