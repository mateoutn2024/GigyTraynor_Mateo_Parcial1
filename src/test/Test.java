package test;

import Sistema.Sistema;
import java.time.LocalDate;
import java.util.List;
import modelo.Servicio;

public class Test {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        LocalDate fecha1 = LocalDate.of(2020, 10, 28);
        LocalDate fecha2 = LocalDate.of(2020, 10, 27);

        try {
            // Test de creación de objetos
            System.out.println("1-1) Intentar crear el objeto Gastronomia con cod incorrecto:");
            sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("1-2) Crear el objeto Gastronomia:");
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("1-3) Intentar crear el objeto Hospedaje con cod incorrecto:");
            sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("1-4) Crear el objeto Hospedaje:");
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test de cálculo de precios
        System.out.println("2-1) Calcular precio final de Gastronomia para el dia 2020-10-28:");
        Servicio gastr = sistema.traerServicio("489235");
        System.out.println(gastr.calcularPrecioFinal(fecha1));

        System.out.println("2-2) Calcular precio final de Hospedaje para el dia 2020-10-27:");
        Servicio hosp = sistema.traerServicio("287282");
        System.out.println(hosp.calcularPrecioFinal(fecha2));

        // Test de agregar servicios
        try {
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test de consulta
        System.out.println("4-1) Traer todos los servicios en promocion:");
        List<Servicio> enPromocion = sistema.traerServicio(true);
        for (Servicio s : enPromocion) {
            System.out.println(s.getCodServicio());
        }

        System.out.println("4-2) Traer todos los servicios del dia 2020-10-28 y en promocion:");
        List<Servicio> enPromocionDia = sistema.traerServicio(true, fecha1);
        for (Servicio s : enPromocionDia) {
            System.out.println(s.getCodServicio());
        }
    }
}
