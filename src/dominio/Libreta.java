package dominio;

import java.io.*;
import java.util.ArrayList;


public class Libreta implements Serializable {

    private ArrayList<Contacto> contactos;

    
    public Libreta() {
        contactos = new ArrayList<>();
    }

  
    public void anadirContacto(Contacto nuevoContacto) {
        contactos.add(nuevoContacto);
    }

   
    public void borrarContacto(String nombre) {
        contactos.removeIf(contacto -> contacto.getNombre().equalsIgnoreCase(nombre));
    }

   
    public void modificarContacto(String nombre, int nuevoTelefono, String nuevoCorreo) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contacto.setNumeroDeTelefono(nuevoTelefono);
                contacto.setCorreoElectronico(nuevoCorreo);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Libreta de contactos:\n");

        for (Contacto contacto : contactos) {
            result.append(contacto.toString()).append("\n");
        }

        return result.toString();
    }

    
    public void guardarLibreta(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    public static Libreta cargarLibreta(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Libreta) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public String generarCSV() {
        StringBuilder csv = new StringBuilder("Nombre,Telefono,Correo\n");

        for (Contacto contacto : contactos) {
            csv.append(contacto.getNombre()).append(",").append(contacto.getNumeroDeTelefono()).append(",")
                    .append(contacto.getCorreoElectronico()).append("\n");
        }

        return csv.toString();
    }
    
}

