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

/**
 *
 * @author javierfernandez
 */
public class Sistema {
    private ListaPersonas listaPersonas;
    private ListaAreas listaAreas;

    public Sistema() {
        this.listaPersonas = new ListaPersonas();
        this.listaAreas = new ListaAreas();
    }

    public void agregarArea(Area area){
        this.listaAreas.agregarArea(area);
    }
    
    
    
    public void agregarEmpleado(Empleado empleado, Area area){
        
        
        this.listaPersonas.agregarEmpleado(empleado);
        this.listaAreas.agregarEmpleadoAArea(area, empleado);
        
    }
    
    
    
    
    
}
