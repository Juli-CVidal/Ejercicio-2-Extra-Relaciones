/*
// Curso Egg FullStack
 */
package Servicios;

// @author JulianCVidal
import Entidades.*;
import java.util.ArrayList;
import java.util.HashMap;
import Constantes.Constantes;
import java.util.Map;
import java.util.Scanner;

public class Cine implements Constantes{

    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");

    ServiciosEspectador ServEsp = new ServiciosEspectador();
    ServiciosPelicula ServPeli = new ServiciosPelicula();
    ServiciosSala ServSala = new ServiciosSala();
    char quiereVer;

    public void menu() {
        HashMap<Pelicula, Sala> peliculasCine = obtenerPeliculas();
        ArrayList<Espectador> espectadores = new ArrayList();
        Pelicula peliculaActual = null;
        Espectador espectadorActual = null;
        int opc;
        System.out.println(BIENVENIDA);

        do {
            quiereVer = 'N';
            System.out.println(MOSTRAR_OPCIONES);
            System.out.print(PEDIR_OPCION);
            opc = leer.nextInt();

            if (opc <= 0 || opc >= 6) {
                if (opc == 6) {
                    System.out.println(SALIR);
                } else {
                    System.out.println(OPCION_INVALIDA);
                }
                continue;
            }

            if (opc != 1 && espectadores.isEmpty()) {
                    System.out.println("Primero debe registrarse.");
                    espectadorActual = ServEsp.crearEspectador(espectadores);
         
            }
            
            while (opc > 2 && espectadorActual == null) {
                System.out.println("Debe indicar quién quiere ver la película.");
                espectadorActual = cambiarDeEspectador(espectadores);
            }
            
            switch (opc) {
                case 1: //Añadir nuevo espectador
                    espectadorActual = ServEsp.crearEspectador(espectadores);
                    break;

                case 2: //Cambiar de espectador
                    espectadorActual = cambiarDeEspectador(espectadores);
                    break;

                case 3: //Mostrar el catálogo de películas
                    System.out.println(MOSTRAR_PELICULAS);
                    mostrarCatalogo(peliculasCine);
                    break;

                case 4: //Ver disponibilidad de una película
                    peliculaActual = elegirPelicula(peliculasCine);

                    if (peliculaActual != null) {
                        System.out.println(MOSTRAR_ASIENTOS);
                        ServSala.mostrarSala(peliculasCine.get(peliculaActual).getAsientos());

                        System.out.print(QUIERE_VER);
                        quiereVer = leer.next().toUpperCase().charAt(0);
                    }
                    if (quiereVer != 'Y') {
                        break;
                    }

                case 5: //Elegir una película
                    if (quiereVer != 'Y') {
                        peliculaActual = elegirPelicula(peliculasCine);
                    }
                    if (peliculaActual != null) {
                        colocarEspectador(peliculaActual, espectadorActual, peliculasCine.get(peliculaActual));
                    }
                    break;
            }
            esperarTecla();
        } while (opc != 6);
    }

    private boolean colocarEspectador(Pelicula peliculaActual, Espectador espectadorActual, Sala salaActual) {
        Integer edadMinima = peliculaActual.getEdadMinima();
        Integer precioEntrada = peliculaActual.getPrecio();
        char[][] asientos = salaActual.getAsientos();
        if (!ServEsp.tieneEdad(espectadorActual.getEdad(), edadMinima)) {
            System.out.println(MENOR_DE_EDAD);
            return false;
        }

        if (!ServEsp.leAlcanza(espectadorActual.getDineroDisponible(), precioEntrada)) {
            System.out.println(DINERO_INSUFICIENTE);
            return false;
        }

        System.out.print("Ingrese la fila donde desea ubicarse (1-8): ");
        int fila = leer.nextInt();
        System.out.print("Y la columna (A-F): ");
        char letraColumna = leer.next().toUpperCase().charAt(0);
        int columna = letraColumna - 'A';
        if (!ServSala.asientoDisponible(asientos, fila, columna)) {
            System.out.println(ASIENTO_NO_DISPONIBLE);
            return false;
        }

        ServEsp.pagarPelicula(espectadorActual, precioEntrada);
        ServSala.ocuparAsiento(salaActual,fila, columna);
        System.out.println(TODO_CORRECTO);
        return true;
    }

    private HashMap<Pelicula, Sala> obtenerPeliculas() {
        HashMap<Pelicula, Sala> todasLasSalas = new HashMap();
        ArrayList<Pelicula> catalogo = ServPeli.obtenerCatalogo();
        Sala salaPelicula = ServSala.crearSala();
        for (Pelicula pelicula : catalogo) {
            todasLasSalas.put(pelicula, salaPelicula);
        }
        return todasLasSalas;
    }

    private Pelicula elegirPelicula(HashMap<Pelicula, Sala> salasCine) {
        System.out.print(PEDIR_PELICULA);
        String titulo = leer.next();
        Pelicula peliElegida = ServPeli.obtenerPelicula(salasCine, titulo);
        if (peliElegida == null) {
            System.out.println(PELICULA_NO_ENCONTRADA);
            return null;
        }
        return peliElegida;
    }

    private void mostrarCatalogo(HashMap<Pelicula, Sala> salasCine) {
        for (Map.Entry<Pelicula, Sala> entry : salasCine.entrySet()) {
            ServPeli.mostrarPelicula(entry.getKey());
        }
    }

    private Espectador cambiarDeEspectador(ArrayList<Espectador> listaEspectadores) {
        System.out.print(PEDIR_NOMBRE);
        String nombre = leer.next();
        Espectador otroEspectador = ServEsp.crearEspectador(listaEspectadores);
        if (otroEspectador == null) {
            System.out.println(NOMBRE_NO_ENCONTRADO);
            return null;
        }
        return otroEspectador;
    }

    private void esperarTecla() {
        System.out.print("Presione Enter para continuar.");
        String pass = leer.next();
    }
}
