/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionalidadTexto;
import java.io.*;
import java.util.Formatter;

/**
 *
 * @author javierfernandez
 */
public class ArchivoGrabacion {
    private Formatter out;
    
    public ArchivoGrabacion(String unNombre) {
        try {
            out = new Formatter(unNombre);
        } catch (FileNotFoundException e) {
            System.out.println("No se puede crear");
            System.exit(1);
        }
    }

    public ArchivoGrabacion(String unNombre, boolean ext) {
        // Si el parámetro viene true, implica que se extiende; si viene false, se sobreescribe.
        try {
            FileWriter writer = new FileWriter(unNombre, ext);
            out = new Formatter(writer);
        } catch (IOException e) {
            System.out.println("No se puede crear/extender");
            System.exit(1);
        }
    }

    public void grabarLinea(String linea){
        
        out.format("%s%n", linea);

    }
    
    public void cerrar(){
        
        out.close();
        

    }

    
    
    
    
}
