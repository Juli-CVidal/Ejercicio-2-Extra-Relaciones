/*
// Curso Egg FullStack
 */
package Servicios;

// @author JulianCVidal
import Entidades.Pelicula;
import Entidades.Sala;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiciosPelicula {

    public ArrayList<Pelicula> obtenerCatalogo() {
        ArrayList<Pelicula> catalogoCine = new ArrayList();
        String[] titulos = {"Animales Fantásticos 3", "Batman", "C Mon C Mon", "Dr Strange 2", "El hombre del Norte"};
        String[] directores = {"David Yates", "Matt Reeves", "Mike Mills", "Sam Raimi", "Robert Eggers"};
        Integer[] duraciones = {142, 176, 109, 126, 137};
        Integer[] edadesMinimas = {13, 16, 13, 0, 16};
        Integer precio;

        Pelicula nuevaPeli;
        for (int i = 0; i < titulos.length; i++) {
            precio = (int) (Math.random() * 200 + 500);
            nuevaPeli = new Pelicula(titulos[i], directores[i], duraciones[i], edadesMinimas[i], precio);
            catalogoCine.add(nuevaPeli);
        }
        return catalogoCine;
    }

    public void mostrarPelicula(Pelicula pelicula) {
        System.out.println();
        System.out.println(pelicula.getTitulo() + ", "
                + pelicula.getDuracion() + " minutos");
        System.out.println("Director: " + pelicula.getDirector());
        System.out.println("Para mayores de: " + pelicula.getEdadMinima() + " años");
        System.out.println("Precio de entrada: $" + pelicula.getPrecio());

    }

    public Pelicula obtenerPelicula(HashMap<Pelicula, Sala> salasCine, String titulo) {
        for (Map.Entry<Pelicula, Sala> entry : salasCine.entrySet()) {
            Pelicula peli = entry.getKey();
            if (peli.getTitulo().equals(titulo)) {
                return peli;
            }
        }
        return null;
    }

}
