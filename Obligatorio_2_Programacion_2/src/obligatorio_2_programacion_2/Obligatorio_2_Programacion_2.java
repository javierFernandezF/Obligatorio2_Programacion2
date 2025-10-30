/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package obligatorio_2_programacion_2;

import Sistema.Sistema;
import Ventanas.VentanaInicio;
import Ventanas.VentanaPresentacion;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author javierfernandez
 */
public class Obligatorio_2_Programacion_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Sistema sistema = new Sistema();
        
        Timer timer = new Timer();
        
        VentanaPresentacion ventanaPresentacion = new VentanaPresentacion();

        java.awt.EventQueue.invokeLater(() -> ventanaPresentacion.setVisible(true));

        
        TimerTask pantallaDeInicio = new TimerTask() {
            @Override
            public void run() {
            java.awt.EventQueue.invokeLater(() -> new VentanaInicio().setVisible(true));
            ventanaPresentacion.setVisible(false);         
                
            }
        };
        
        timer.schedule(pantallaDeInicio, 4000);



    }
    
}
