/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Personas;

/**
 *
 * @author javierfernandez
 */
public class Manager extends Persona  {
    
    private int anosDeAntiguedad;

    public Manager(String nombre, int cedula, String celular, int anosDeAntiguedad) {
        super(nombre, cedula, celular);
        this.anosDeAntiguedad = anosDeAntiguedad;
    }

    public int getAnosDeAntiguedad() {
        return anosDeAntiguedad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Manager other = (Manager) obj;
        return this.getCedula() == other.getCedula();
    }
    
    

  
        
        
}
