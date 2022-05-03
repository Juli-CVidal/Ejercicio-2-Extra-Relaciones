/*
// Curso Egg FullStack
 */
package Servicios;

// @author JulianCVidal
import Entidades.Espectador;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiciosEspectador {

    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private final String[] nombres = {"Nati", "Sergio", "Matías", "Julián", "Pedro", "Carlos", "María", "Paz", "Augusto", "Micaela", "Emiliano", "Bruno", "Paula", "Rocío", "Florencia"};

    public Espectador crearEspectador(ArrayList<Espectador> listaEspectadores) {
        System.out.print("Ingrese su nombre: ");
        String nombre = leer.next();

        System.out.print("Su edad: ");
        Integer edad = leer.nextInt();

        System.out.print("Y su dinero disponible: ");
        Integer dineroDisponible = leer.nextInt();

        Espectador nuevoEspectador = new Espectador(nombre, edad, dineroDisponible);
        listaEspectadores.add(nuevoEspectador);
        return nuevoEspectador;
    }

    public boolean leAlcanza(Integer dineroDisponible, Integer precioEntrada) {
        return dineroDisponible >= precioEntrada;
    }

    public boolean pagarPelicula(Espectador espectador, Integer precioEntrada) {
        Integer dineroDisponible = espectador.getDineroDisponible();
        espectador.setDineroDisponible(dineroDisponible - precioEntrada);
        return true;

    }

    public boolean tieneEdad(Integer edadEspectador, Integer edadMinima) {
        return edadEspectador >= edadMinima;
    }

    public Espectador obtenerEspectador(ArrayList<Espectador> listaEspectadores, String nombre) {
        for (Espectador espectador : listaEspectadores) {
            if (espectador.getNombre().equalsIgnoreCase(nombre)) {
                return espectador;
            }
        }
        return null;
    }

    public void mostrarEspectador(Espectador espectador) {
        System.out.println(espectador.getNombre() + ", " + espectador.getEdad() + " años.");
        System.out.println("Dinero disponible: $" + espectador.getDineroDisponible());
    }
}
