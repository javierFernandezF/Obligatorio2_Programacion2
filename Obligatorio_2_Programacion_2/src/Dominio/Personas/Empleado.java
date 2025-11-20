/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Personas;

import java.io.Serializable;


/**
 *
 * @author javierfernandez
 */
public class Empleado extends Persona implements Serializable{
    private int salarioMensual;
    private Manager manager;

    public Empleado(String nombre, int cedula, String celular,int salarioMensual, Manager manager) {
        super(nombre, cedula, celular);
        this.salarioMensual = salarioMensual;
        this.manager = manager;
        
        
        
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
    
    
    
    
}
