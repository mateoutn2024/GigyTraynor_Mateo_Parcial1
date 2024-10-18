package modelo;

import java.time.LocalDate;

public class Hospedaje extends Servicio {
    private final String hospedaje;
    private final double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    /**
     *
     * @param dia
     * @return
     */
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        // Aplica descuento solo de lunes a viernes si está en promoción
        if (isEnPromocion() && (dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5)) {
            return precioPorNoche * (1 - getPorcentajeDescuento() / 100);
        }
        return precioPorNoche;
    }
}
