/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Areas;
import Dominio.Personas.Empleado;
import java.util.*;
/**
 *
 * @author javierfernandez
 */
public class ListaAreas {
    private ArrayList<Area> areas;
    
    public ListaAreas(){
        this.areas = new ArrayList<Area>();
    }

    public void agregarArea(Area area){
        
        boolean areaYaExiste = false;
        
        for(int i = 0; i < areas.size() && !areaYaExiste; i++){
            
            Area areaActual = areas.get(i);
            
            if(areaActual.equals(area)){
                areaYaExiste = true;
            }
        }
        
        if(!areaYaExiste){
          areas.add(area);  
        }
        
    }
    
    public ArrayList<Area> getAreas() {
        return areas;
    }
    
    public void agregarEmpleadoAArea(Area area, Empleado empleado){
        
        boolean areaEncontrada = false; 
        
        for(int i = 0; i < this.areas.size() && !areaEncontrada; i++){
            
            Area areaSeleccionada = this.areas.get(i);
            
            if(areaSeleccionada.equals(area)){
               areaEncontrada = true;
               areaSeleccionada.agregarEmpleado(empleado);
            }
            
        }
       
        
        
    }

    
    
    public ArrayList<Area> getAreasSinEmpleados(){
        
        ArrayList<Area> areasSinEmpleados = new ArrayList<Area>();
        
        for(int i = 0; i < this.areas.size(); i++){
            
            boolean areaSinEmpleados = this.areas.get(i).getListaEmpleados().size() == 0;
            
            if(areaSinEmpleados){
                areasSinEmpleados.add(this.areas.get(i));
            }
            
        }
        
        
        return areasSinEmpleados;
    }
    
    
}
