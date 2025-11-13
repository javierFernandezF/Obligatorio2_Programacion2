/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Dominio.Areas.Area;
import Dominio.Areas.ListaAreas;
import Dominio.Personas.Empleado;
import Dominio.Personas.ListaPersonas;
import Dominio.Personas.Manager;
import Historial.ListaCambioArea;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Observable;

/**
 *
 * @author javierfernandez
 */
public class Sistema extends Observable{
    private ListaPersonas listaPersonas;
    private ListaAreas listaAreas;
    private ListaCambioArea listaCambioArea;

    public Sistema() {
        this.listaPersonas = new ListaPersonas();
        this.listaAreas = new ListaAreas();
        this.listaCambioArea = new ListaCambioArea();
    }

    public ListaPersonas getListaPersonas() {
        return listaPersonas;
    }

    public ListaAreas getListaAreas() {
        return listaAreas;
    }
    
    
    public void agregarArea(Area area){
        this.listaAreas.agregarArea(area);
        setChanged();
        notifyObservers();
    }
    
    public void agregarManager(Manager manager){
        this.listaPersonas.agregarManager(manager);
        setChanged();
        notifyObservers();
    }
    
    
    
    
    public boolean validarPresupuestoArea(Empleado empleado, Area area, int mesesDeTrabajo){
        int salarioMensual = empleado.getSalarioMensual();
        double costoTotal = salarioMensual * mesesDeTrabajo;
        
        return listaCambioArea.validarPresupuesto(area, costoTotal);
    }
    
    public void agregarEmpleado(Empleado empleado, Area area){
        
        int mesesDeTrabajo = 12;
        
        if(validarPresupuestoArea(empleado,area,mesesDeTrabajo)){

            this.listaAreas.agregarEmpleadoAArea(area, empleado);
            this.listaPersonas.agregarEmpleado(empleado);
            
            listaCambioArea.agregarEmpleadoNuevo(empleado, area.getNombre());
            
            setChanged();
            notifyObservers();
        
        }
        
    }
    
    public void cambiarEmpleadoDeArea(Empleado empleado, Area nuevaArea, int mesDeEntrada){
        
        int mesesTrabajadosEnAreaAnterior = mesDeEntrada - 1;
        int mesesATrabajarEnNuevaArea = 12 - mesesTrabajadosEnAreaAnterior;
        
        
        if(validarPresupuestoArea(empleado,nuevaArea,mesesATrabajarEnNuevaArea)){
            
            Area areaAnterior = getAreaDelEmpleado(empleado);
            
            // Si se selecciona enero (mes 1), limpiar todos los cambios anteriores del empleado
            if(mesDeEntrada == 1){
                listaCambioArea.limpiarCambiosDeEmpleado(empleado);
            }
            
            listaCambioArea.agregarCambio(empleado, areaAnterior.getNombre(), nuevaArea.getNombre(), mesDeEntrada, 12);
            
            areaAnterior.borrarUnEmpleado(empleado);
            nuevaArea.agregarEmpleado(empleado);
            
            setChanged();
            notifyObservers();
            
        }
        
        
    }
    
    public Area getAreaDelEmpleado(Empleado empleado){
        
        Area areaDelEmpleado = null;
        
        for(int i = 0; i < this.listaAreas.getAreasOrdenadasPorNombre().size(); i++){
            
            Area areaActual = this.listaAreas.getAreasOrdenadasPorNombre().get(i);
            
            for(int j = 0; j < areaActual.getListaEmpleados().size(); j++){
                
                Empleado empleadoActual = areaActual.getListaEmpleados().get(j);
                
                if(empleadoActual.equals(empleado)){
                    areaDelEmpleado = areaActual;
                }
            }
        }
        
        return areaDelEmpleado;
    }
    
    public ArrayList<Area> getAreasOrdenadasPorNombre(){
        return this.listaAreas.getAreasOrdenadasPorNombre();
                
    }
    
    public ArrayList<Area> getAreasSinEmpleados(){
        return this.listaAreas.getAreasSinEmpleados();
    }
    
    public void borrarArea(String areaNombre){
        this.listaAreas.borrarArea(areaNombre);
        setChanged();
        notifyObservers();
        
    }
    
    public Area getAreaPorNOmbre(String areaNombre){
        return this.listaAreas.getAreaPorNombre(areaNombre);
    }
    
    
    public ArrayList<Manager> getManagersOrdenados(){
        return this.listaPersonas.getManagersOrdenados();
    }
    
    public ArrayList<Manager> getManagersSinEmpleadosACargo(){
        return this.listaPersonas.getManagersSinEmpleadosACargo();
    }
    
    public void eliminarManager(Manager manager){
        this.listaPersonas.eliminarManager(manager);
        setChanged();
        notifyObservers();
    }
    
    public int cantidadDeEmpleadosDeUnManager(Manager manager){
        return this.listaPersonas.cantidadDeEmpleadosDeUnManager(manager);
    }
    
     public void setCelularManager(Manager manager, String nuevoTelefono){
         this.listaPersonas.setCelularManager(manager, nuevoTelefono);
         setChanged();
        notifyObservers();
     }
     
     public ListaCambioArea getListaCambioArea() {
         return listaCambioArea;
     }
     
     public double getPresupuestoDisponible(Area area) {
         return listaCambioArea.getPresupuestoDisponible(area);
     }
     
      //le da al reporte acceso a todos los empleados
     public ArrayList<Empleado> getEmpleados() {
         return this.listaPersonas.getSoloEmpleados();
     }
     
     //le da al reporte acceso a todas las áreas registradas en el sistema
     public ArrayList<Area> getAreas() {
         return this.listaAreas.getAreas();
     }
     
     //obtiene y devuelve los empleados que pertenecen a un área específica
     //y los ordena por nombre
     
     public ArrayList<Empleado> getEmpleadosDe(Area area) {
         ArrayList<Empleado> out = listaAreas.getEmpleadosDe(area);
        out.sort(Comparator.comparing(Empleado::getNombre));
        return out;
     }
     
     // Cálculos del reporte Estado de Áreas
    public double salarioAnual(Empleado e) {
        return e.getSalarioMensual() * 12.0;
    }

    public double totalAsignado(Area a) {
        double total = 0;
        for (Empleado e : getEmpleadosDe(a)) total += salarioAnual(e);
        return total;
    }

    public double porcentajeAsignado(Area a) {
        double presu = a.getPresupuesto();
        if (presu <= 0) return 0.0;
        return (totalAsignado(a) * 100.0) / presu;
    }

    public ArrayList<Area> getAreasOrdenadasPorPorcentajeDesc() {
        ArrayList<Area> copia = new ArrayList<>(getAreas());
        copia.sort((a,b) -> Double.compare(porcentajeAsignado(b), porcentajeAsignado(a)));
        return copia;
    }

    public double minSalarioEn(Area a){
        double m = Double.POSITIVE_INFINITY;
        for (Empleado e: getEmpleadosDe(a)) m = Math.min(m, e.getSalarioMensual());
        return (m==Double.POSITIVE_INFINITY)? 0 : m;
    }

    public double maxSalarioEn(Area a){
        double m = 0;
        for (Empleado e: getEmpleadosDe(a)) m = Math.max(m, e.getSalarioMensual());
        return m;
    }
   
}
