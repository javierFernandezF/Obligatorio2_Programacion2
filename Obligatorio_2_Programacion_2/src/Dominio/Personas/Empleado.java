/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Personas;

import Dominio.Areas.Area;

/**
 *
 * @author javierfernandez
 */
public class Empleado extends Persona {
    private int salarioMensual;
    private Manager manager;
    private Area area;

    public Empleado(int salarioMensual, Manager manager, String nombre, int cedula, int celular, Area area) {
        super(nombre, cedula, celular);
        this.salarioMensual = salarioMensual;
        this.manager = manager;
        this.area = area;
        
        
        
    }

    public Area getArea() {
        return area;
    }

    public int getSalarioMensual() {
        return salarioMensual;
    }

    public Manager getManager() {
        return manager;
    }

    public void setSalarioMensual(int salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }
    
    
    
}
