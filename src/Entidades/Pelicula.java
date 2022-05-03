/*
// Curso Egg FullStack
 */
package Entidades;

// @author JulianCVidal
public class Pelicula {

    private final String titulo;
    private final String director;
    private final Integer duracion; //en minutos
    private final Integer edadMinima;
    private final Integer precio;

    public Pelicula(String titulo, String director, Integer duracion, Integer edadMinima, Integer precio) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public Integer getPrecio() {
        return precio;
    }

}
