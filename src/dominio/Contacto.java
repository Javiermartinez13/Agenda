package dominio;

import java.io.Serializable;

public class Contacto implements Serializable {

    private String nombre;
    private int numeroDeTelefono;

    // Constructor con parámetros
    public Contacto(String nombre, int numeroDeTelefono) {
        this.nombre = nombre;
        this.numeroDeTelefono = numeroDeTelefono;
    }

    // Constructor sin parámetros
    public Contacto() {
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(int numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", numeroDeTelefono=" + numeroDeTelefono +
                '}';
    }

	public void setCorreoElectronico(String nuevoCorreo) {
	}

	public Object getCorreoElectronico() {
		return null;
	}
}
