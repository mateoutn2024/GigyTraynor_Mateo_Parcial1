package test;

import Sistema.Sistema;
import java.time.LocalDate;
import java.util.List;
import modelo.Gastronomia;
import modelo.Hospedaje;
import modelo.Servicio;

/**
 * Clase de prueba que contiene el método principal para ejecutar los 
 * casos de prueba del sistema de gestión de servicios de gastronomía 
 * y hospedaje.
 */
public class Test {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(); // Instancia del sistema de gestión de servicios
        LocalDate fecha1 = LocalDate.of(2020, 10, 28); // Fecha para la prueba de gastronomía
        LocalDate fecha2 = LocalDate.of(2020, 10, 27); // Fecha para la prueba de hospedaje

        // Pruebas de creación de objetos
        try {
            System.out.println("1-1) Intentar crear el objeto Gastronomia con cod incorrecto:");
            sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Captura y muestra el mensaje de error
        }

        try {
            System.out.println("1-2) Crear el objeto Gastronomia:");
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Captura y muestra el mensaje de error
        }

        try {
            System.out.println("1-3) Intentar crear el objeto Hospedaje con cod incorrecto:");
            sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Captura y muestra el mensaje de error
        }

        try {
            System.out.println("1-4) Crear el objeto Hospedaje:");
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Captura y muestra el mensaje de error
        }

        // Pruebas de cálculo de precios
        System.out.println("2-1) Calcular precio final de Gastronomia para el día 2020-10-28:");
        Servicio gastr = sistema.traerServicio("489235"); // Recupera el servicio de gastronomía
        System.out.println(gastr.calcularPrecioFinal(fecha1)); // Calcula y muestra el precio final

        System.out.println("2-2) Calcular precio final de Hospedaje para el día 2020-10-27:");
        Servicio hosp = sistema.traerServicio("287282"); // Recupera el servicio de hospedaje
        System.out.println(hosp.calcularPrecioFinal(fecha2)); // Calcula y muestra el precio final

        // Pruebas de agregar servicios
        try {
            // Agrega varios servicios al sistema
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);

            // Imprimir la lista de servicios después de agregar
            System.out.println("\n---(3) Lista de servicios agregados ---");
            imprimirListaServicios(sistema); // Llama al método para imprimir la lista de servicios

        } catch (Exception e) {
            System.out.println(e.getMessage()); // Captura y muestra el mensaje de error
        }

        // Prueba de consulta
        System.out.println("\n4-1) Traer todos los servicios en promoción:");
        List<Servicio> enPromocion = sistema.traerServicio(true); // Recupera servicios en promoción
        for (Servicio s : enPromocion) {
            // Imprime los detalles de cada servicio en promoción
            if (s instanceof Gastronomia g) {
                System.out.println("Gastronomia: " + g.getCodServicio() + " - " + g.gastronomia + " - Precio: " + g.precio
                                   + " - Porcentaje Descuento: " + g.getPorcentajeDescuento() + " - En Promoción: " + g.isEnPromocion());
            } else if (s instanceof Hospedaje h) {
                System.out.println("Hospedaje: " + h.getCodServicio() + " - " + h.hospedaje + " - Precio por noche: " + h.precioPorNoche
                                   + " - Porcentaje Descuento: " + h.getPorcentajeDescuento() + " - En Promoción: " + h.isEnPromocion());
            }
        }

        System.out.println("4-2) Traer todos los servicios del día 2020-10-28 y en promoción:");
        List<Servicio> enPromocionDia = sistema.traerServicio(true, fecha1); // Recupera servicios en promoción para una fecha específica
        for (Servicio s : enPromocionDia) {
            // Imprime los detalles de cada servicio en promoción para esa fecha
            if (s instanceof Gastronomia g) {
                System.out.println("Gastronomia: " + g.getCodServicio() + " - " + g.gastronomia + " - Precio: " + g.precio
                                   + " - Porcentaje Descuento: " + g.getPorcentajeDescuento() + " - En Promoción: " + g.isEnPromocion());
            } else if (s instanceof Hospedaje h) {
                System.out.println("Hospedaje: " + h.getCodServicio() + " - " + h.hospedaje + " - Precio por noche: " + h.precioPorNoche
                                   + " - Porcentaje Descuento: " + h.getPorcentajeDescuento() + " - En Promoción: " + h.isEnPromocion());
            }
        }
    }

    /**
     * Método para imprimir la lista de servicios agregados.
     *
     * @param sistema El sistema desde el cual se recuperan los servicios para imprimir.
     */
    public static void imprimirListaServicios(Sistema sistema) {
        List<Servicio> servicios = sistema.traerTodosLosServicios(); // Obtiene todos los servicios
        for (Servicio s : servicios) {
            if (s instanceof Gastronomia g) {
                // Imprime los detalles del servicio de gastronomía
                System.out.println("Gastronomia: " + g.getCodServicio() + " - " + g.gastronomia + " - Precio: " + g.precio
                                   + " - Porcentaje Descuento: " + g.getPorcentajeDescuento() + " - En Promoción: " + g.isEnPromocion());
            } else if (s instanceof Hospedaje h) {
                // Imprime los detalles del servicio de hospedaje
                System.out.println("Hospedaje: " + h.getCodServicio() + " - " + h.hospedaje + " - Precio por noche: " + h.precioPorNoche
                                   + " - Porcentaje Descuento: " + h.getPorcentajeDescuento() + " - En Promoción: " + h.isEnPromocion());
            }
        }
    }
}
