package modelo;

import java.time.LocalDate;

/**
 * Clase abstracta que representa un servicio genérico en el sistema.
 * Esta clase sirve como base para los tipos de servicios específicos,
 * como gastronomía y hospedaje.
 */
public abstract class Servicio {
    // Atributo que representa el código único del servicio. Debe tener una longitud de 6 caracteres.
    private String codServicio;  
    
    // Atributo que representa el porcentaje de descuento aplicable al servicio.
    private double porcentajeDescuento;  
    
    // Atributo que indica si el servicio está actualmente en promoción.
    private boolean enPromocion;  

    /**
     * Constructor de la clase Servicio.
     * 
     * @param codServicio Identificador único del servicio, debe tener una longitud de 6 caracteres.
     * @param porcentajeDescuento Porcentaje de descuento aplicable al servicio.
     * @param enPromocion Indica si el servicio está en promoción.
     * @throws Exception Si el código de servicio no tiene una longitud de 6 caracteres.
     */
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        // Validación para asegurar que el código de servicio tiene exactamente 6 caracteres.
        if (codServicio.length() != 6) {
            throw new Exception("El codigo de servicio debe tener 6 caracteres.");
        }
        this.codServicio = codServicio;           // Asignar el código de servicio.
        this.porcentajeDescuento = porcentajeDescuento; // Asignar el porcentaje de descuento.
        this.enPromocion = enPromocion;           // Asignar el estado de promoción.
    }

    /**
     * Método para obtener el código de servicio.
     * 
     * @return El código del servicio.
     */
    public String getCodServicio() {
        return codServicio;
    }

    /**
     * Método para obtener el porcentaje de descuento.
     * 
     * @return El porcentaje de descuento del servicio.
     */
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    /**
     * Método para verificar si el servicio está en promoción.
     * 
     * @return true si el servicio está en promoción, false en caso contrario.
     */
    public boolean isEnPromocion() {
        return enPromocion;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases.
     * Este método calcula el precio final del servicio basado en la fecha dada.
     * 
     * @param dia La fecha para la cual se calculará el precio final.
     * @return El precio final del servicio.
     */
    public abstract double calcularPrecioFinal(LocalDate dia);
}
