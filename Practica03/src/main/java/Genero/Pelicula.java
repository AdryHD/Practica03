package Genero;

import proyecto02.practica03.Peli;


/**
 *
 * @author adryhd
 */

public class Pelicula implements Peli {

    private String nombre;
    private String genero;
    private int duracion;
    private int annoEstreno;


    public Pelicula(String nombre, String genero, int duracion, int annoEstreno){
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.annoEstreno = annoEstreno;
    }


    @Override
    public String getNombre() {
        return "";
    }

    @Override
    public String getGenero() {
        return "";
    }

    @Override
    public int getDuracion() {
        return 0;
    }

    @Override
    public int getAnnoEstreno() {
        return 0;
    }


    @Override
    public String toString() {
        return "Pelicula{" +
                "Nombre='" + nombre + '\'' +
                ", Genero='" + genero + '\'' +
                ", Duracion=" + duracion +
                ", Año estreno=" + annoEstreno +
                '}';
    }
}
