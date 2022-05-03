/*
// Curso Egg FullStack
 */
package Servicios;

// @author JulianCVidal
import Entidades.Sala;

public class ServiciosSala {

    public Sala crearSala() {
        char[][] salaCine = new char[8][6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                salaCine[i][j] = ' ';
            }
        }
        return new Sala(salaCine);
    }

    public boolean asientoDisponible(char[][] asientos, int fila, int columna) {
        if ((fila < 0 || fila > 8) || (columna < 0 || columna > 6)) {
            return false;
        }
        return asientos[fila][columna] == ' ';
    }

    public void mostrarSala(char[][] asientos) {
        char letraFila;
        for (int i = 0; i < 8; i++) {
            letraFila = 'A';
            for (int j = 0; j < 6; j++) {
                System.out.print((8 - i));
                System.out.print(letraFila + "  ");
                System.out.print(asientos[i][j]);
                System.out.print(" | ");
                letraFila++;
            }
            System.out.println();
            System.out.println("----------------------------------------------");
        }
    }

    public boolean ocuparAsiento(Sala salaCine, int fila, int columna) {
        if ((fila<0 || fila>7) && (columna<0 || columna>5)){
            return false;
        }
        
        char[][] asientos = salaCine.getAsientos();
        asientos[fila][columna] = 'X';
        salaCine.setAsientos(asientos);
        return true;
    }
}
