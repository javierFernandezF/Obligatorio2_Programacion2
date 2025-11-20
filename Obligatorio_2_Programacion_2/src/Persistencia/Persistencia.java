package Persistencia;


import Sistema.Sistema;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Persistencia {
    
    
    private static  String RUTA_COMPLETA = "src/ArchivoPersistencia/datos.dat";
    
    // Guardar sistema
    public static void guardarSistema(Sistema sistema) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(RUTA_COMPLETA));
        out.writeObject(sistema);
        out.close();
    }
    
    // Cargar sistema
    public static Sistema cargarSistema() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(RUTA_COMPLETA));
        Sistema sistema = (Sistema) in.readObject();
        in.close();
        return sistema;
    }
}