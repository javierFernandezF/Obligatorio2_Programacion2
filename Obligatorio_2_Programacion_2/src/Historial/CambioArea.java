/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Historial;

import Dominio.Personas.Empleado;
import java.io.Serializable;

/**
 *
 * @author javierfernandez
 */
public class CambioArea implements Serializable{
    private Empleado empleado;
    private String nombreAreaAnterior;
    private String nombreAreaNueva;
    private int mesInicio;
    private int mesFin;
    
    public CambioArea(Empleado empleado, String nombreAreaAnterior, String nombreAreaNueva, int mesInicio, int mesFin) {
        this.empleado = empleado;
        this.nombreAreaAnterior = nombreAreaAnterior;
        this.nombreAreaNueva = nombreAreaNueva;
        this.mesInicio = mesInicio;
        this.mesFin = mesFin;
    }
    
    public Empleado getEmpleado() { 
        return empleado; 
    }
    
    public String getNombreAreaAnterior() { 
        return nombreAreaAnterior; 
    }
    
    public String getNombreAreaNueva() { 
        return nombreAreaNueva; 
    }
    
    public int getMesInicio() { 
        return mesInicio; 
    }
    
    public int getMesFin() { 
        return mesFin; 
    }
    
    public int getMesesTrabajados() {
        return mesFin - mesInicio + 1;
    }
    
    public int getCostoTotal() {
        return empleado.getSalarioMensual() * getMesesTrabajados();
    }
}
