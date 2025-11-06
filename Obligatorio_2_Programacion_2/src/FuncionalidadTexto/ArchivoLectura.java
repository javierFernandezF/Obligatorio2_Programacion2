/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionalidadTexto;

import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;


/**
 *
 * @author javierfernandez
 */
public class ArchivoLectura {
    private Scanner in;
    private String linea;
    
    public ArchivoLectura(String unNombre){
        try { 
        in = new Scanner(Paths.get(unNombre));
        
        
        } catch (IOException e){
        System.out.println("Error");
        System.exit(1);
        }
    
    }
    
    public boolean hayMasLineas(){
        boolean hay = false;
        linea = null;
        if(in.hasNext()){
            linea = in.nextLine();
            hay = true;
        }
     return hay;
    }
    
    public String linea(){
        return linea;
    }
    
    public void cerrar(){
        in.close();
    }
    /*
    public static void listar(String unNombre){
        ArchivoLectura arch = new ArchivoLectura(Sring unNombre);
        
        while(arch.hayMasLineas()){
            System.out.println(arch.linea());
        }
        
    arch.cerrar();    
    }
    */
    
}
