/*
// Curso Egg FullStack
 */
package Entidades;

// @author JulianCVidal
public class Espectador {

    private final String nombre;
    private final Integer edad;
    private Integer dineroDisponible;

    public Espectador(String nombre, Integer edad, Integer dineroDisponible) {
        this.nombre = nombre;
        this.edad = edad;
        this.dineroDisponible = dineroDisponible;
    }


    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(Integer dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }
}
