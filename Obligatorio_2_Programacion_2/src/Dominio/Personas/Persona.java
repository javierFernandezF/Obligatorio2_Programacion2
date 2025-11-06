/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Personas;


/**
 *
 * @author javierfernandez
 */
public class Persona {
    private String nombre;
    private int cedula;
    private String celular;

    public Persona(String nombre, int cedula, String celular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.cedula;
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
        final Persona other = (Persona) obj;
        return this.cedula == other.cedula;
    }
    
    
    
}
