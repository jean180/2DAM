
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jean_
 */
public class Ejer8 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Caledari calendari = new Caledari();
        do {

            System.out.println("-----Bienvenido a la guia telefonica-----");
            System.out.println("1-Agregar contacto");
            System.out.println("2-Buscar contacto");
            System.out.println("3-Borrar contacto");
            System.out.println("4-Listar contactos");
            System.out.println("5-Modificar numero");
            System.out.println("6-Salir");
            System.out.println("------------------------------------------");
            System.out.println("Indique que acción quiere realizar:");
            int opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    opcion1(calendari);
                    break;
                case 2:
                    opcion2(calendari);
                    break;
                case 3:
                    opcion3(calendari);
                    break;
                case 4:
                    opcion4(calendari);
                    break;
                case 5:
                    opcion5(calendari);
                    break;

                case 6:
                    System.exit(0);
            }
        } while (true);

    }

    public static void opcion1(Caledari calendari) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre del contacto");
        String nombre = teclado.nextLine();
        System.out.println("Introduce el numero de " + nombre);
        int numero = teclado.nextInt();
        calendari.addContacto(new Contactes(nombre, numero));
        System.out.println("Contacto añadido");
        System.out.println("Nombre: " + nombre + " TLF: " + numero);
    }

    public static void opcion2(Caledari calendari) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica el nombre del contacto a buscar:");
        String nombre = teclado.nextLine();
        calendari.findContacto(nombre);
    }

    public static void opcion3(Caledari calendari) {
        calendari.removeContacto();
    }

    public static void opcion4(Caledari calendari) {
        calendari.listar();
    }

    public static void opcion5(Caledari calendari) {
        calendari.modificarContacto();
    }
}
