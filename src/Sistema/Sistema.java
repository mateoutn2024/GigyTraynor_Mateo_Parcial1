package Sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Gastronomia;
import modelo.Hospedaje;
import modelo.Servicio;

/**
 * Clase que gestiona los servicios de hospedaje y gastronomía.
 * Permite agregar servicios, recuperarlos y filtrarlos según diferentes criterios.
 */
public class Sistema {
    // Lista que almacena los servicios (gastronomía y hospedaje) disponibles en el sistema.
    private final List<Servicio> lstServicio = new ArrayList<>();

    /**
     * Método que busca un servicio por su código.
     *
     * @param codServicio Código del servicio a buscar.
     * @return El servicio encontrado o null si no existe.
     */
    public Servicio traerServicio(String codServicio) {
        for (Servicio s : lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                return s; // Retorna el servicio si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra
    }

    /**
     * Método que recupera los servicios según su estado de promoción.
     *
     * @param enPromocion Indica si se desean recuperar solo los servicios en promoción.
     * @return Lista de servicios que cumplen con el estado de promoción solicitado.
     */
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion) {
                resultado.add(s); // Agrega el servicio a la lista si coincide el estado
            }
        }
        return resultado; // Retorna la lista de servicios filtrados
    }

    /**
     * Método que recupera los servicios según su estado de promoción y la fecha.
     *
     * @param enPromocion Indica si se desean recuperar solo los servicios en promoción.
     * @param dia Fecha para la cual se calculará el precio final del servicio.
     * @return Lista de servicios que cumplen con el estado de promoción y cuya
     *         precio final es mayor a cero para la fecha dada.
     */
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion && s.calcularPrecioFinal(dia) > 0) {
                resultado.add(s); // Agrega el servicio a la lista si coincide el estado y tiene precio
            }
        }
        return resultado; // Retorna la lista de servicios filtrados
    }
    
    /**
     * Método que recupera todos los servicios disponibles en el sistema.
     *
     * @return Lista de todos los servicios sin ningún tipo de filtrado.
     */
    public List<Servicio> traerTodosLosServicios() {
        return lstServicio; // Retorna la lista completa de servicios
    }
    
    /**
     * Método que agrega un nuevo servicio de gastronomía al sistema.
     *
     * @param codServicio Código único del servicio, debe tener una longitud de 6 caracteres.
     * @param porcentajeDescuento Porcentaje de descuento aplicable al servicio.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param gastronomia Nombre o descripción del platillo gastronómico.
     * @param precio Precio del servicio gastronómico.
     * @param diaSemDesc Día de la semana en que se aplica el descuento.
     * @return true si el servicio fue agregado correctamente.
     * @throws Exception Si el código de servicio ya existe en el sistema.
     */
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio con este código ya existe."); // Evita duplicados
        }
        Gastronomia nuevoServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        lstServicio.add(nuevoServicio); // Agrega el nuevo servicio a la lista
        return true; // Retorna true si la adición fue exitosa
    }

    /**
     * Método que agrega un nuevo servicio de hospedaje al sistema.
     *
     * @param codServicio Código único del servicio, debe tener una longitud de 6 caracteres.
     * @param porcentajeDescuento Porcentaje de descuento aplicable al servicio.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param hospedaje Nombre o descripción del hospedaje.
     * @param precioPorNoche Precio por noche del hospedaje.
     * @return true si el servicio fue agregado correctamente.
     * @throws Exception Si el código de servicio ya existe en el sistema.
     */
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio con este código ya existe."); // Evita duplicados
        }
        Hospedaje nuevoServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        lstServicio.add(nuevoServicio); // Agrega el nuevo servicio a la lista
        return true; // Retorna true si la adición fue exitosa
    }

    /**
     * Método no soportado.
     * Este método fue generado automáticamente y no tiene implementación.
     *
     * @param b Parámetro no utilizado.
     * @return 
     * @throws UnsupportedOperationException Siempre lanza esta excepción si se invoca.
     */
    public List<Servicio> traerTodosLosServicios(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Indica que el método no está implementado
    }
}
