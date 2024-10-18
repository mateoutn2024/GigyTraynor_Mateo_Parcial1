package Sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Gastronomia;
import modelo.Hospedaje;
import modelo.Servicio;

public class Sistema {
    private final List<Servicio> lstServicio = new ArrayList<>();

    public Servicio traerServicio(String codServicio) {
        for (Servicio s : lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                return s;
            }
        }
        return null;
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion && s.calcularPrecioFinal(dia) > 0) {
                resultado.add(s);
            }
        }
        return resultado;
    }
    
    public List<Servicio> traerTodosLosServicios() {
        return lstServicio; // Método para obtener todos los servicios sin filtrado
    }
    
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio con este código ya existe.");
        }
        Gastronomia nuevoServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        lstServicio.add(nuevoServicio); // Agrega el nuevo servicio a la lista
        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio con este código ya existe.");
        }
        Hospedaje nuevoServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        lstServicio.add(nuevoServicio); // Agrega el nuevo servicio a la lista
        return true;
    }

    public List<Servicio> traerTodosLosServicios(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
