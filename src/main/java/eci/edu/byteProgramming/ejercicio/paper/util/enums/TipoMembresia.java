package videoclub.enums;

public enum TipoMembresia {
    BASICA(0.0),
    PREMIUM(0.20);

    private final double descuento;

    TipoMembresia(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }
}