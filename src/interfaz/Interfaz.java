package interfaz;

import dominio.*;


public class Interfaz {

    private static Libreta libreta;

    
    public static void main(String[] args) {
        libreta = Libreta.cargarLibreta("libreta.dat");

        if (args.length == 0 || args[0].equals("help")) {
            mostrarAyuda();
        } else if (args[0].equals("add")) {
            if (args.length != 4) {
                System.out.println("Formato incorrecto para añadir contacto. Uso: java -jar libreta.jar add <nombre> <teléfono> <correo>");
            } else {
                String nombre = args[1];
                int telefono = Integer.parseInt(args[2]);
                String correo = args[3];
                agregarContacto(nombre, telefono, correo);
            }
        } else if (args[0].equals("delete")) {
            if (args.length != 2) {
                System.out.println("Formato incorrecto para borrar contacto. Uso: java -jar libreta.jar delete <nombre>");
            } else {
                String nombre = args[1];
                borrarContacto(nombre);
            }
        } else if (args[0].equals("modify")) {
            if (args.length != 4) {
                System.out.println("Formato incorrecto para modificar contacto. Uso: java -jar libreta.jar modify <nombre> <teléfono> <correo>");
            } else {
                String nombre = args[1];
                int nuevoTelefono = Integer.parseInt(args[2]);
                String nuevoCorreo = args[3];
                modificarContacto(nombre, nuevoTelefono, nuevoCorreo);
            }
        } else if (args[0].equals("list")) {
            listarContactos();
        } else if (args[0].equals("csv")) {
            generarCSV();
        } else {
            System.out.println("Comando no reconocido. Use 'java -jar libreta.jar help' para obtener ayuda.");
        }

        libreta.guardarLibreta("libreta.dat");
    }

    

    private static void mostrarAyuda() {
        // Implementación de mostrarAyuda
    }

    private static void agregarContacto(String nombre, int telefono, String correo) {
        Contacto nuevoContacto = new Contacto(nombre, telefono);
        nuevoContacto.setCorreoElectronico(correo);
        libreta.anadirContacto(nuevoContacto);
    }

    private static void borrarContacto(String nombre) {
        libreta.borrarContacto(nombre);
    }

    private static void modificarContacto(String nombre, int nuevoTelefono, String nuevoCorreo) {
        libreta.modificarContacto(nombre, nuevoTelefono, nuevoCorreo);
    }

    private static void listarContactos() {
        System.out.println(libreta.toString());
    }

    private static void generarCSV() {
        System.out.println(libreta.generarCSV());
    }
}
