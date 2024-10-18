package modelo;

import java.time.LocalDate;

public class Gastronomia extends Servicio {
    public final String gastronomia;
    public final double precio;
    private final int diaSemDesc;

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        // Aplica descuento solo si coincide el día de la semana
        if (isEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc) {
            return precio * (1 - getPorcentajeDescuento() / 100);
        }
        return precio; // Retorna el precio completo si no hay descuento
    }
}
