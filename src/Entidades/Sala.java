/*
// Curso Egg FullStack
 */
package Entidades;

// @author JulianCVidal
public class Sala {

    private char[][] asientos; //8 filas, 6 columnas

    public Sala(char[][] asientos) {
        this.asientos = asientos;
    }

    public Sala() {
        this.asientos = new char[8][6];
    }

    public char[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(char[][] asientos) {
        this.asientos = asientos;
    }
    
}
