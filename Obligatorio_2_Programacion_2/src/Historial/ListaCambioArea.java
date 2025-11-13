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
        double presupuestoUsado;
        CambioArea cambio;
        String nombreArea;
        
        presupuestoUsado = 0;
        nombreArea = area.getNombre();
        
        for (int i = 0; i < listaCambios.size(); i++) {
            cambio = listaCambios.get(i);
            
            if (cambio.getNombreAreaNueva().equals(nombreArea)) {
                presupuestoUsado = presupuestoUsado + cambio.getCostoTotal();
            }
            if (cambio.getNombreAreaAnterior() != null && cambio.getNombreAreaAnterior().equals(nombreArea)) {
                presupuestoUsado = presupuestoUsado - cambio.getCostoTotal();
            }
        }
        
        return presupuestoUsado;
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
        return getPresupuestoDisponible(area) >= costoAdicional;
    }
    
    public double getPresupuestoOriginal(Area area) {
        return area.getPresupuesto();
    }
    
    public double getPresupuestoUsado(Area area) {
        return calcularPresupuestoUsadoPorArea(area);
    }
}
