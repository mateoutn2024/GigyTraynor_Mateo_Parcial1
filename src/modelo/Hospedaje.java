package modelo;

import java.time.LocalDate;

/**
 * Clase que representa un servicio de hospedaje.
 * Esta clase hereda de la clase abstracta Servicio e implementa el método 
 * calcularPrecioFinal para calcular el precio de un hospedaje.
 */
public class Hospedaje extends Servicio {
    // Nombre del hospedaje, que representa el tipo o descripción de la habitación o cabaña.
    public final String hospedaje;
    
    // Precio por noche del hospedaje.
    public final double precioPorNoche;

    /**
     * Constructor de la clase Hospedaje.
     * 
     * @param codServicio Identificador único del servicio, debe tener una longitud de 6 caracteres.
     * @param porcentajeDescuento Porcentaje de descuento aplicable al servicio de hospedaje.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param hospedaje Nombre o tipo del hospedaje.
     * @param precioPorNoche Precio por noche del hospedaje.
     * @throws Exception Si el código de servicio no tiene una longitud de 6 caracteres.
     */
    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion); // Llama al constructor de la superclase Servicio
        this.hospedaje = hospedaje; // Asigna el nombre del hospedaje
        this.precioPorNoche = precioPorNoche; // Asigna el precio por noche
    }

    /**
     * Método que calcula el precio final del hospedaje para un día específico.
     * Aplica un descuento si el hospedaje está en promoción y el día es un día laborable.
     * 
     * @param dia La fecha para la cual se calculará el precio final.
     * @return El precio final del hospedaje, aplicando el descuento si corresponde.
     */
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        // Aplica descuento solo de lunes a viernes si está en promoción
        if (isEnPromocion() && (dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5)) {
            return precioPorNoche * (1 - getPorcentajeDescuento() / 100); // Aplica el descuento
        }
        return precioPorNoche; // Retorna el precio sin descuento si no está en promoción o es fin de semana
    }
}
