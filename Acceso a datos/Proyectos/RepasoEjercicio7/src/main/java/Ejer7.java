
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
public class Ejer7 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Curs curso = new Curs();
        int opcion;
        System.out.println("Bienvenido al sistema de gestion de clases");
        do {
            System.out.println("Escoge una opción");
            System.out.println("1-Agregar alumno");
            System.out.println("2-Suprimir alumno");
            System.out.println("3-Modificar alumno");
            System.out.println("4-Mostrar alumno");
            System.out.println("5-Cambiar nota en letra");
            System.out.println("6-Mostrar total de alumnos dependiendo de la nota");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    opcion1(curso);
                    break;

                case 2:
                    opcion2(curso);
                    break;

                case 3:
                    break;

                case 4:
                    opcion4(curso);
                    break;

                case 5:
                    break;

                case 6:
                    break;
            }

        } while (true);
    }

    public static void opcion1(Curs curso) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre del alumno");
        String nombre = teclado.nextLine();
        System.out.println("Introduce los apellidos del alumno");
        String apellidos = teclado.nextLine();
        System.out.println("Introduce el DNI");
        String DNI = teclado.next();
        int notanum;
        do {
            System.out.println("Introduce la nota (formato numerico)");
            notanum = teclado.nextInt();
        } while (notanum > 10);
        String notaletra = "Sin nota";
        if (notanum < 0) {
            notaletra = "No presentado";
        } else if (notanum < 5) {
            notaletra = "Suspenso";
        } else if (notanum < 7) {
            notaletra = "Aprobado";
        } else if (notanum < 9) {
            notaletra = "Notable";
        } else if (notanum < 10) {
            notaletra = "Sobresaliente";
        } else if (notanum == 10) {
            notaletra = "M.Honor";
        }

        curso.addAlumno(new Alumne(nombre, apellidos, DNI, notanum, notaletra));
    }

    public static void opcion2(Curs curso) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("indica la posición en la lista i/o el nombre del alumno (Separados por un espacio)");
        String dato = teclado.nextLine();
        String Split[] = dato.split(" ");
        int posicion;
        String nombre;
        try {
            posicion = Integer.parseInt(Split[0]);
            try {
                nombre = Split[1];
                curso.removeAlumno(0, nombre);
            } catch (Exception e) {
                curso.removeAlumno(posicion, null);
            }
        } catch (Exception e) {
            nombre = Split[0];
            curso.removeAlumno(0, nombre);
        }
    }

    public static void opcion4(Curs curso) {
        curso.listarAlumnos();
    }
}
