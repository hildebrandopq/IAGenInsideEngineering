package videoclub;

import videoclub.enums.TipoMembresia;
import videoclub.model.*;
import videoclub.service.*;
import java.util.*;

public class VideoClubApp {

    public static void main(String[] args) {

        // Catálogo de películas
        List<Pelicula> catalogo = new ArrayList<>();
        catalogo.add(new PeliculaFisica("Interestellar", 8000, true));   // 1
        catalogo.add(new PeliculaFisica("El Padrino",    7000, false));  // 2
        catalogo.add(new PeliculaDigital("Inception",    5000, true));   // 3
        catalogo.add(new PeliculaDigital("Matrix",       6000, true));   // 4

        Scanner scanner = new Scanner(System.in);

        // Mostrar catálogo
        System.out.println("=== VIDEOCLUB DON MARIO ===");
        System.out.println("Peliculas disponibles:");
        for (int i = 0; i < catalogo.size(); i++) {
            System.out.println((i + 1) + ". " + catalogo.get(i));
        }

        // Elegir membresía
        System.out.println("\nTipo de membresia (1=BASICA, 2=PREMIUM):");
        int opcionMem = scanner.nextInt();
        TipoMembresia membresia = (opcionMem == 2)
                ? TipoMembresia.PREMIUM
                : TipoMembresia.BASICA;

        // Seleccionar películas
        System.out.println("Seleccione peliculas (numeros separados por coma, ej: 1,3):");
        scanner.nextLine();
        String[] seleccion = scanner.nextLine().split(",");

        List<Pelicula> seleccionadas = new ArrayList<>();
        for (String s : seleccion) {
            int idx = Integer.parseInt(s.trim()) - 1;
            if (idx >= 0 && idx < catalogo.size()) {
                Pelicula p = catalogo.get(idx);
                if (p.isDisponible()) {
                    seleccionadas.add(p);
                } else {
                    System.out.println("⚠ \"" + p.getTitulo()
                            + "\" no esta disponible. Se omite.");
                }
            }
        }

        if (seleccionadas.isEmpty()) {
            System.out.println("No hay peliculas validas seleccionadas.");
            return;
        }

        // Calcular y mostrar recibo
        CalculadorPrecio calc = new CalculadorPrecio();
        double subtotal  = calc.calcularSubtotal(seleccionadas);
        double descuento = calc.calcularDescuento(subtotal, membresia);
        double total     = calc.calcularTotal(subtotal, descuento);

        new GeneradorRecibo().imprimir(membresia, seleccionadas,
                subtotal, descuento, total);
        scanner.close();
    }
}