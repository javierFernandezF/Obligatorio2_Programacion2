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
public class Area {
    private String nombre;
    private String descripcion;
    private double presupuesto;
    private ArrayList<Empleado> listaEmpleados;
    
    public Area(){
        this.nombre = "test";
        this.descripcion = "test";
        this.presupuesto = 123;
        this.listaEmpleados = new ArrayList<Empleado>(); 
    }

    public Area(String nombre, String descripcion, double presupuesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
        this.listaEmpleados = new ArrayList<Empleado>(); 
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    public void agregarEmpleado(Empleado empleado){
        this.listaEmpleados.add(empleado);
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Area other = (Area) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
    
   
}
