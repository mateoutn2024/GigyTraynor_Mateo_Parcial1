package modelo;

import java.time.LocalDate;

public abstract class Servicio {
    private String codServicio;  // Longitud de 6
    private double porcentajeDescuento;
    private boolean enPromocion;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        if (codServicio.length() != 6) {
            throw new Exception("El código de servicio debe tener 6 caracteres.");
        }
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    // Método abstracto para que lo implementen las subclases.
    public abstract double calcularPrecioFinal(LocalDate dia);
}
