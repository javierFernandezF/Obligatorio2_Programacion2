/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Personas;
import java.util.*;


/**
 *
 * @author javierfernandez
 */
public class ListaPersonas{
    private ArrayList<Persona> listaPersonas;

    public ListaPersonas() {
        this.listaPersonas = new ArrayList<Persona>();
    }
    
    
    public void agregarEmpleado(Empleado empleado){
        
        boolean personaYaExiste = false;
        
        for(int i = 0; i < listaPersonas.size() && !personaYaExiste; i++){
            
            Persona personaActual = (Persona) listaPersonas.get(i);
            
            if(personaActual.equals((Persona) empleado)){
                personaYaExiste = true;
            }
        }
        
        if(!personaYaExiste){
          listaPersonas.add(empleado);
          
        }
        
       
    }
    
    
    public void agregarManager(Manager manager){
        
        boolean managerYaExiste = false;
        
        for(int i = 0; i < listaPersonas.size() && !managerYaExiste; i++){
            
            Persona personaActual = (Persona) listaPersonas.get(i);
            
            if(personaActual.equals((Persona) manager)){
                managerYaExiste = true;
            }
        }
        
        if(!managerYaExiste){
          listaPersonas.add(manager);  
        }
        
        
        
    }
    
    public ArrayList<Empleado> getSoloEmpleados() {
    ArrayList<Empleado> empleados = new ArrayList<>();
    
    for (int i = 0; i < this.listaPersonas.size(); i++) {
        
        Persona posibleEmpleado = this.listaPersonas.get(i);
    
        
        if (posibleEmpleado instanceof Empleado) {
            
            
            empleados.add((Empleado) posibleEmpleado);
        }
    }
    
    return empleados;
    }
    
    public ArrayList<Empleado> getEmpleadosOrdenados(){
        
        ArrayList<Empleado> empleados = this.getSoloEmpleados();
        
        
        Collections.sort(empleados, new Comparator<Empleado>() {
        @Override
            public int compare(Empleado e1, Empleado e2) {
                return Integer.compare(e1.getSalarioMensual(), e2.getSalarioMensual());
            }
        });
    
    return empleados;
        
        
    }
    
    public ArrayList<Manager> getSoloManagers() {
        
    ArrayList<Manager> Managers = new ArrayList<>();
    
    for (int i = 0; i < this.listaPersonas.size(); i++) {
        
        Persona posibleManager = this.listaPersonas.get(i);
    
        
        if (posibleManager instanceof Manager) {
            
            
            Managers.add((Manager) posibleManager);
        }
    }
    
    return Managers;
    }
    
    public ArrayList<Manager> getManagersOrdenados(){
        
        ArrayList<Manager> managers = this.getSoloManagers();
        
        
        Collections.sort(managers, new Comparator<Manager>() {
        @Override
            public int compare(Manager e1, Manager e2) {
                return Integer.compare(e2.getAnosDeAntiguedad(), e1.getAnosDeAntiguedad());
            }
        });
    
    return managers;
        
        
    }
    
    public Manager getManagerPorCedula(int cedula){
        
        Manager manager = new Manager("test", 123, "123", 123) ;
        
        for(int i = 0; i < this.getManagersOrdenados().size(); i++){
            Manager managerSeleccionado = this.getManagersOrdenados().get(i);
            
            if(managerSeleccionado.getCedula() == cedula){
                manager = managerSeleccionado;
            }
        }
        
        return manager;
        
    }
    
    public Empleado getEmpleadoPorCedula(int cedula){
        
        
        
        Empleado empleado = new Empleado("test", 123, "123", 0, null) ;
        
        for(int i = 0; i < this.getEmpleadosOrdenados().size(); i++){
            Empleado empleadoSeleccionado = this.getEmpleadosOrdenados().get(i);
            
            if(empleadoSeleccionado.getCedula() == cedula){
                empleado = empleadoSeleccionado;
            }
        }
        
        return empleado;
        
    }
    
    public ArrayList<Manager> getManagersSinEmpleadosACargo(){
            
            ArrayList<Manager> managers = this.getManagersOrdenados();
            
            ArrayList<Empleado> empleados = this.getEmpleadosOrdenados();
            
            ArrayList<Manager> managersConEmpleados = new ArrayList<Manager>();
            
            for(int e = 0; e < empleados.size(); e++){
                
                Manager manager = empleados.get(e).getManager();
                
                managersConEmpleados.add(manager);
            }

           
            
            
            ArrayList<Manager> managersSinEmpleados  = new ArrayList<Manager>();
            
            for(int i = 0; i < managers.size(); i++){
                
                Manager manager = managers.get(i);
                
                boolean managerTieneEmpleados = false;
                
                for(int k = 0; k < managersConEmpleados.size() && !managerTieneEmpleados; k++){
                    if(manager.equals(managersConEmpleados.get(k))){
                        managerTieneEmpleados = true;
                    }
                }
                
                if(!managerTieneEmpleados){
                    managersSinEmpleados.add(manager);
                }
            }


            return managersSinEmpleados;
    }

        
    public void eliminarManager(Manager manager){
        this.listaPersonas.remove(manager);
      
    }
    
    public int cantidadDeEmpleadosDeUnManager(Manager manager){
        int cantidad = 0;
        
        for(int i = 0; i< this.getEmpleadosOrdenados().size(); i++){
            
            if(manager.equals(this.getEmpleadosOrdenados().get(i).getManager())){
                cantidad++;
            }
        
        }
        
        return cantidad;
    }
    
    public void setCelularManager(Manager manager, String nuevoTelefono){
        
        
        for(int i = 0; i < this.getManagersOrdenados().size(); i++){
        Manager managerSelecionado = this.getManagersOrdenados().get(i);  
        
            if(managerSelecionado.equals(manager)){

            managerSelecionado.setCelular(nuevoTelefono);

            }

        }
                
                
                    
    }
}
