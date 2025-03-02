package proyecto02.practica03;

import Interfaz.PeliculasInterface;

public abstract class Pelicula implements PeliculasInterface {
    private String nombre;
    private String genero;
    private int duracion;
    private int anioEstreno;

    public Pelicula(String nombre, String genero, int duracion, int anioEstreno) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.anioEstreno = anioEstreno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    @Override
    public String toString() {
        return nombre + " (" + anioEstreno + ")";
    }
}

