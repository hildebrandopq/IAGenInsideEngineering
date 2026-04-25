package eci.edu.byteProgramming.ejercicio.paper.util.service;

import videoclub.enums.TipoMembresia;
import videoclub.model.Pelicula;
import java.util.List;

public class CalculadorPrecio {

    public double calcularSubtotal(List<Pelicula> peliculas) {
        return peliculas.stream()
                .mapToDouble(Pelicula::getPrecio)
                .sum();
    }

    public double calcularDescuento(double subtotal, TipoMembresia membresia) {
        return subtotal * membresia.getDescuento();
    }

    public double calcularTotal(double subtotal, double descuento) {
        return subtotal - descuento;
    }
}