package interfaz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interfaz {
    private Map<String, String> contactos;

    public Interfaz() {
        contactos = new HashMap<>();
    }

    public void procesarEntrada(String entrada) {
        String[] partes = entrada.split(" ");

        if (partes.length > 0) {
            if (partes[0].equals("addnombre") && partes.length == 3) {
                agregarContacto(partes[1], partes[2]);
            } else if (partes[0].equals("list") && partes.length == 1) {
                listarContactos();
            } else {
                System.out.println("Entrada inválida. Use 'addnombre nombre telefono' o 'list'.");
            }
        } else {
            System.out.println("Entrada vacía. Use 'addnombre nombre telefono' o 'list'.");
        }
    }

    private void agregarContacto(String nombre, String telefono) {
        contactos.put(nombre, telefono);
        System.out.println("Contacto agregado: " + nombre + " - " + telefono);
    }

    private void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La libreta de contactos está vacía.");
        } else {
            System.out.println("Lista de contactos:");
            for (Map.Entry<String, String> entry : contactos.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}