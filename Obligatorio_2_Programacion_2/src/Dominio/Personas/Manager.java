/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio.Personas;

/**
 *
 * @author javierfernandez
 */
public class Manager extends Persona {
    
    private int anosDeAntiguedad;

    public Manager(String nombre, int cedula, String celular, int anosDeAntiguedad) {
        super(nombre, cedula, celular);
        this.anosDeAntiguedad = anosDeAntiguedad;
    }

    public int getAnosDeAntiguedad() {
        return anosDeAntiguedad;
    }
    
    

  
        
        
}
