package proyecto02.practica03;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author adryhd
 */

public class Config {

    public static ArrayList<String> cargartxt() {
        ArrayList<String> lineas = new ArrayList<>();
        String rutatxt = "src/main/java/proyecto02/practica03/Catalogo.txt";
        try {
            DataInputStream txt = new DataInputStream(new FileInputStream(rutatxt));
            String linea;
            while ((linea = txt.readLine()) != null) {
                lineas.add(linea);
            }
            txt.close();
        } catch (IOException e) {
            System.out.println("No se puede leer el txt: " + e.getMessage());
        }
        return lineas;
    }

}
