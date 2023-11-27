package dominio;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que representa una libreta de contactos.
 */
public class Libreta implements Serializable {

    private ArrayList<Contacto> contactos;

    /**
     * Constructor para crear una nueva libreta de contactos.
     */
    public Libreta() {
        contactos = new ArrayList<>();
    }

    /**
     * Método para añadir un contacto a la libreta.
     *
     * @param nuevoContacto El nuevo contacto a añadir.
     */
    public void anadirContacto(Contacto nuevoContacto) {
        contactos.add(nuevoContacto);
    }

    /**
     * Método para borrar un contacto de la libreta.
     *
     * @param nombre El nombre del contacto a borrar.
     */
    public void borrarContacto(String nombre) {
        contactos.removeIf(contacto -> contacto.getNombre().equalsIgnoreCase(nombre));
    }

    /**
     * Método para modificar un contacto en la libreta.
     *
     * @param nombre           El nombre del contacto a modificar.
     * @param nuevoTelefono    El nuevo número de teléfono del contacto.
     * @param nuevoCorreo      El nuevo correo electrónico del contacto.
     */
    public void modificarContacto(String nombre, int nuevoTelefono, String nuevoCorreo) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contacto.setNumeroDeTelefono(nuevoTelefono);
                contacto.setCorreoElectronico(nuevoCorreo);
                break;
            }
        }
    }

    /**
     * Método para generar una cadena de caracteres con todos los contactos.
     *
     * @return La cadena de caracteres que contiene todos los contactos.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Libreta de contactos:\n");

        for (Contacto contacto : contactos) {
            result.append(contacto.toString()).append("\n");
        }

        return result.toString();
    }

    /**
     * Método para guardar la libreta en un archivo.
     *
     * @param nombreArchivo El nombre del archivo donde se guardará la libreta.
     */
    public void guardarLibreta(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para cargar la libreta desde un archivo.
     *
     * @param nombreArchivo El nombre del archivo desde donde se cargará la libreta.
     * @return La libreta cargada desde el archivo.
     */
    public static Libreta cargarLibreta(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Libreta) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Método para generar una hoja de cálculo en formato CSV con los contactos.
     *
     * @return La cadena que representa la hoja de cálculo en formato CSV.
     */
    public String generarCSV() {
        StringBuilder csv = new StringBuilder("Nombre,Telefono,Correo\n");

        for (Contacto contacto : contactos) {
            csv.append(contacto.getNombre()).append(",").append(contacto.getNumeroDeTelefono()).append(",")
                    .append(contacto.getCorreoElectronico()).append("\n");
        }

        return csv.toString();
    }
    
}

