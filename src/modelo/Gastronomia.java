package modelo;

import java.time.LocalDate;

/**
 * Clase que representa un servicio de gastronomía.
 * Esta clase hereda de la clase abstracta Servicio e implementa el método 
 * calcularPrecioFinal para calcular el precio de un servicio gastronómico.
 */
public class Gastronomia extends Servicio {
    // Nombre o tipo de la gastronomía, que representa la descripción del platillo o producto.
    public final String gastronomia;  
    
    // Precio del servicio gastronómico.
    public final double precio;   
    
    // Día de la semana en que se aplica el descuento (1 = Lunes, 7 = Domingo).
    private final int diaSemDesc;  

    /**
     * Constructor de la clase Gastronomia.
     * 
     * @param codServicio Identificador único del servicio, debe tener una longitud de 6 caracteres.
     * @param porcentajeDescuento Porcentaje de descuento aplicable al servicio de gastronomía.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param gastronomia Nombre o tipo del platillo o producto gastronómico.
     * @param precio Precio del servicio gastronómico.
     * @param diaSemDesc Día de la semana en que se aplica el descuento.
     * @throws Exception Si el código de servicio no tiene una longitud de 6 caracteres.
     */
    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion); // Llama al constructor de la superclase Servicio
        this.gastronomia = gastronomia; // Asigna el nombre del platillo
        this.precio = precio; // Asigna el precio
        this.diaSemDesc = diaSemDesc; // Asigna el día de descuento
    }

    /**
     * Método que calcula el precio final del servicio gastronómico para un día específico.
     * Aplica un descuento si el servicio está en promoción y coincide con el día de descuento.
     * 
     * @param dia La fecha para la cual se calculará el precio final.
     * @return El precio final del servicio gastronómico, aplicando el descuento si corresponde.
     */
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        // Aplica descuento solo si coincide el día de la semana
        if (isEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc) {
            return precio * (1 - getPorcentajeDescuento() / 100); // Aplica el descuento
        }
        return precio; // Retorna el precio completo si no hay descuento
    }
}
