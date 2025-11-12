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
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author javierfernandez
 */
public class Sistema extends Observable{
    private ListaPersonas listaPersonas;
    private ListaAreas listaAreas;

    public Sistema() {
        this.listaPersonas = new ListaPersonas();
        this.listaAreas = new ListaAreas();
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
    
    
    
    public void restarPresupuestoArea(Area area, int cantidadARestar){
        double nuevoPresupuesto = area.getPresupuesto() - cantidadARestar;
        
        area.setPresupuesto(nuevoPresupuesto);           
                
    }
    
    public void sumarPresupuestoArea(Area area, int cantidadASumar){
        double nuevoPresupuesto = area.getPresupuesto() - cantidadASumar;
        
        area.setPresupuesto(nuevoPresupuesto); 
    }
    
    public boolean validarPresupuestoArea(Empleado empleado, Area area, int mesesDeTrabajo){
        
        boolean daElPresupuesto = false;
        int salarioMensual = empleado.getSalarioMensual();
        
        
        daElPresupuesto = salarioMensual*mesesDeTrabajo <= area.getPresupuesto();
        
        
        return daElPresupuesto;
    }
    
    public void agregarEmpleado(Empleado empleado, Area area){
        
        int mesesDeTrabajo = 12;
        
        if(validarPresupuestoArea(empleado,area,mesesDeTrabajo)){

            this.listaAreas.agregarEmpleadoAArea(area, empleado);
            this.listaPersonas.agregarEmpleado(empleado);
            
            
            
            restarPresupuestoArea(area, empleado.getSalarioMensual()*mesesDeTrabajo);
            
            setChanged();
            notifyObservers();
        
        }
        
    }
    
    public void cambiarEmpleadoDeArea(Empleado empleado, Area nuevaArea, int mesDeEntrada){
        
        int mesesTrabajadosEnAreaAnterior = mesDeEntrada - 1;
        int mesesATrabajarEnNuevaArea = 12 - mesesTrabajadosEnAreaAnterior;
        
        
        if(validarPresupuestoArea(empleado,nuevaArea,mesesATrabajarEnNuevaArea)){
            
            Area areaAnterior = getAreaDelEmpleado(empleado);
            int salarioMensual = empleado.getSalarioMensual();
            
            Area areaAnt = this.listaAreas.getAreaPorNombre(areaAnterior.getNombre());
            int presupuestoLiberado = salarioMensual * mesesATrabajarEnNuevaArea;
            areaAnt.setPresupuesto((int) (areaAnt.getPresupuesto() + presupuestoLiberado));
            
            areaAnt.borrarUnEmpleado(empleado);
            
            Area areaNueva = this.listaAreas.getAreaPorNombre(nuevaArea.getNombre());
            int presupuestoRequerido = salarioMensual * mesesATrabajarEnNuevaArea;
            areaNueva.setPresupuesto((int) (areaNueva.getPresupuesto() - presupuestoRequerido));
            
            areaNueva.agregarEmpleado(empleado);
            
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
   
}
