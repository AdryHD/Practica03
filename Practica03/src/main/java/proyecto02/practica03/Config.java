package proyecto02.practica03;
import java.io.*;
import java.util.ArrayList;

public class Config {

    // cargar el archivo en una lista
    public static ArrayList<String> cargarArchivo() {
        ArrayList<String> lineas = new ArrayList<>();
        String rutaArchivo = "src/main/java/org/example/CatalogoPeliculas.txt";

        try {
            DataInputStream archivo = new DataInputStream(new FileInputStream(rutaArchivo));
            String linea;
            // leer linea por linea con readline
            while ((linea = archivo.readLine()) != null) {
                lineas.add(linea);
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return lineas;
    }

}
