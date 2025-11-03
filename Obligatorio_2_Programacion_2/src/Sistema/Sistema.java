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
    
    
    
}
