/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Historial;

import Dominio.Areas.Area;
import Dominio.Personas.Empleado;
import java.util.ArrayList;

/**
 *
 * @author javierfernandez
 */
public class ListaCambioArea {
    private ArrayList<CambioArea> listaCambios;
    
    public ListaCambioArea() {
        this.listaCambios = new ArrayList<>();
    }
    
    public void agregarCambio(Empleado empleado, String nombreAreaAnterior, String nombreAreaNueva, int mesInicio, int mesFin) {
        CambioArea cambio;
        
        cambio = new CambioArea(empleado, nombreAreaAnterior, nombreAreaNueva, mesInicio, mesFin);
        listaCambios.add(cambio);
    }
    
    public void agregarEmpleadoNuevo(Empleado empleado, String nombreArea) {
        agregarCambio(empleado, null, nombreArea, 1, 12);
    }
    
    public double calcularPresupuestoUsadoPorArea(Area area) {
        String nombreArea = area.getNombre();
        double presupuestoUsado = 0;
        
        // Obtener todos los empleados únicos que han tenido cambios
        ArrayList<Empleado> empleadosUnicos = new ArrayList<>();
        for (int i = 0; i < listaCambios.size(); i++) {
            CambioArea cambio = listaCambios.get(i);
            if (!empleadosUnicos.contains(cambio.getEmpleado())) {
                empleadosUnicos.add(cambio.getEmpleado());
            }
        }
        
        // Para cada empleado, calcular cuántos meses trabajó en esta área
        for (int i = 0; i < empleadosUnicos.size(); i++) {
            Empleado empleado = empleadosUnicos.get(i);
            int mesesEnArea = calcularMesesEmpleadoEnArea(empleado, nombreArea);
            presupuestoUsado += empleado.getSalarioMensual() * mesesEnArea;
        }
        
        return presupuestoUsado;
    }
    
    /**
     * Calcula cuántos meses trabajó un empleado específico en un área específica,
     * considerando todos los cambios y manejando correctamente las superposiciones.
     */
    private int calcularMesesEmpleadoEnArea(Empleado empleado, String nombreArea) {
        // Array para almacenar en qué área estuvo cada mes (null si no hay asignación)
        String[] areasPorMes = new String[13]; // índices 1-12 para los meses
        
        // Obtener todos los cambios de este empleado ordenados por mes de inicio
        ArrayList<CambioArea> cambiosEmpleado = getCambiosPorEmpleado(empleado);
        cambiosEmpleado.sort((c1, c2) -> Integer.compare(c1.getMesInicio(), c2.getMesInicio()));
        
        // Procesar cada cambio en orden cronológico
        // Los cambios posteriores sobrescriben los anteriores en caso de superposición
        for (int i = 0; i < cambiosEmpleado.size(); i++) {
            
            CambioArea cambio = cambiosEmpleado.get(i);
            
            for (int mes = cambio.getMesInicio(); mes <= cambio.getMesFin(); mes++) {
                areasPorMes[mes] = cambio.getNombreAreaNueva();
            }
        }
        
        // Contar cuántos meses estuvo en el área especificada
        int totalMeses = 0;
        for (int mes = 1; mes <= 12; mes++) {
            if (nombreArea.equals(areasPorMes[mes])) {
                totalMeses++;
            }
        }
        
        return totalMeses;
    }
    
    public ArrayList<CambioArea> getCambiosPorArea(Area area) {
        ArrayList<CambioArea> cambiosArea;
        CambioArea cambio;
        String nombreArea;
        
        cambiosArea = new ArrayList<>();
        nombreArea = area.getNombre();
        
        for (int i = 0; i < listaCambios.size(); i++) {
            cambio = listaCambios.get(i);
            
            if (cambio.getNombreAreaNueva().equals(nombreArea) || (cambio.getNombreAreaAnterior() != null && cambio.getNombreAreaAnterior().equals(nombreArea))) {
                cambiosArea.add(cambio);
            }
        }
        
        return cambiosArea;
    }
    
    public ArrayList<CambioArea> getCambiosPorEmpleado(Empleado empleado) {
        ArrayList<CambioArea> cambiosEmpleado;
        CambioArea cambio;
        
        cambiosEmpleado = new ArrayList<>();
        
        for (int i = 0; i < listaCambios.size(); i++) {
            
            cambio = listaCambios.get(i);
            
            if (cambio.getEmpleado().equals(empleado)) {
                cambiosEmpleado.add(cambio);
            }
        }
        
        return cambiosEmpleado;
    }
    
    /**
     * Elimina todos los cambios de área de un empleado específico.
     * Se usa cuando se hace un cambio desde enero para limpiar el historial anterior.
     */
    public void limpiarCambiosDeEmpleado(Empleado empleado) {
        for (int i = listaCambios.size() - 1; i >= 0; i--) {
            
            CambioArea cambio = listaCambios.get(i);
            
            if (cambio.getEmpleado().equals(empleado)) {
                listaCambios.remove(i);
            }
        }
    }
    
    public ArrayList<CambioArea> getListaCambios() {
        return listaCambios;
    }
    
    public double getPresupuestoDisponible(Area area) {
        double presupuestoOriginal;
        double presupuestoUsado;
        
        presupuestoOriginal = area.getPresupuesto();
        presupuestoUsado = calcularPresupuestoUsadoPorArea(area);
        
        return presupuestoOriginal - presupuestoUsado;
    }
    
    public boolean validarPresupuesto(Area area, double costoAdicional) {
        return getPresupuestoDisponible(area) > costoAdicional;
    }
    
    public double getPresupuestoOriginal(Area area) {
        return area.getPresupuesto();
    }
    
    public double getPresupuestoUsado(Area area) {
        return calcularPresupuestoUsadoPorArea(area);
    }
}
