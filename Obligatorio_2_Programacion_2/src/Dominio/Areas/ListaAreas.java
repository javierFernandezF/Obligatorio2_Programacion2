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
public class ListaAreas{
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
    
    public Area getAreaPorNombre(String areaNombre){
        
        Area areaSeleccionada = new Area();
        
        for(int i = 0; i < this.areas.size(); i++){
            
            if(this.areas.get(i).getNombre().equals(areaNombre)){
                areaSeleccionada = this.areas.get(i);
            }
        }

        
        
        return areaSeleccionada;
    }
    
    public ArrayList<Area> getAreasOrdenadasPorNombre(){
    
    ArrayList<Area> areasOrdenadas = new ArrayList<>(this.areas); 
    
    Collections.sort(areasOrdenadas, new Comparator<Area>() {
        @Override
        public int compare(Area e1, Area e2) {
            return e1.getNombre().compareToIgnoreCase(e2.getNombre());
        }
    });
    
   

    return areasOrdenadas;
    
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
    
    public void borrarArea(String areaNombre){
        
        int index = 0;
        boolean areaEncontrada = false;
        for(int i = 0; i < this.areas.size(); i++){
           
            if(this.areas.get(i).getNombre().equals(areaNombre)){
                index = i;
                areaEncontrada = true;
            }    
        }
        
        if(areaEncontrada){
        this.areas.remove(index);
        }
        
       
    }
    
    
}
