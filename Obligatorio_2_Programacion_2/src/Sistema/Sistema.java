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
    
    public void agregarEmpleado(Empleado empleado, Area area){
        this.listaPersonas.agregarEmpleado(empleado);
        this.listaAreas.agregarEmpleadoAArea(area, empleado);
        setChanged();
        notifyObservers();
        
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
        return this.listaAreas.getAreaPorNOmbre(areaNombre);
    }
    
    //Conviene dejar las listas public para no repetir metodos??
    
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
   
}
