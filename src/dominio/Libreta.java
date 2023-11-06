package dominio;

import java.io.Serializable;

public class Libreta implements Serializable {

    private String nombre;
    private int númeroDeTeléfono;

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNúmeroDeTeléfono() {
        return númeroDeTeléfono;
    }

    public void setNúmeroDeTeléfono(int númeroDeTeléfono) {
        this.númeroDeTeléfono = númeroDeTeléfono;
    }

    @Override
    public String toString() {
        return "Libreta [nombre=" + nombre + ", númeroDeTeléfono=" + númeroDeTeléfono +"]";
    }
}
