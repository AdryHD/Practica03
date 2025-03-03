package Genero;

import proyecto02.practica03.Peliculas;



public class Pelicula implements Peliculas {

    //Atributos de la pelicula
    private String nombre;
    private String genero;
    private int duracion;
    private int annoEstreno;

    //constructor de la pelicula
    public Pelicula(String nombre, String genero, int duracion, int annoEstreno){
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.annoEstreno = annoEstreno;
    }


    //implementacion de la interfaz
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

    //Generamos automaticamente con click derecho, para leer el texto de la pelicula
    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion=" + duracion +
                ", año estreno=" + annoEstreno +
                '}';
    }
}
