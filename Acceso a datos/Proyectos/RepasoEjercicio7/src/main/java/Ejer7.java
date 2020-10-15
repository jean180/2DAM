
import java.util.Iterator;
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
            System.out.println("5-Cambiar nota");
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
                    opcion3(curso);
                    break;

                case 4:
                    opcion4(curso);
                    break;

                case 5:
                    opcion5(curso);
                    break;

                case 6:
                    opcion6(curso);
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
            teclado.nextLine();

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
        System.out.println("Indica si quieres introducir numero de la lista o nombre de alumno");
        System.out.println("1-Numero \n2-Nombre");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        opcion4(curso);
        if (opcion == 1) {
            System.out.println("Ingrese el numero de la lista");
            int numerolista = teclado.nextInt();
            teclado.nextLine();
            curso.removeAlumno(numerolista, null);

        } else if (opcion == 2) {
            System.out.println("Ingrese el nombre");
            String nombre = teclado.nextLine();
            curso.removeAlumno(-1, nombre);
        }

    }

    public static void opcion3(Curs curso) {
        System.out.println("¿Que alumno de la lista quiere modificar?");
        opcion4(curso);
        Scanner teclado = new Scanner(System.in);
        int posicion = teclado.nextInt();
        teclado.nextLine();
        Alumne alumnoModoficar = curso.findAlumno(posicion, null);

        System.out.println("Introduce el nombre del alumno(Anterior nombre: " + alumnoModoficar.getNom() + ")");
        String nombre = teclado.nextLine();
        System.out.println("Introduce los apellidos del alumno(Anterior apellidos: " + alumnoModoficar.getCognoms() + ")");
        String apellidos = teclado.nextLine();
        System.out.println("Introduce el DNI(Anterior DNI: " + alumnoModoficar.getDNI() + ")");
        String DNI = teclado.next();
        int notanum;
        do {
            System.out.println("Introduce la nota (formato numerico) (Anterior nota: " + alumnoModoficar.getNotaNum() + ")");
            notanum = teclado.nextInt();
            teclado.nextLine();

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
        System.out.println("Cambio realizado"
                + "\nAnteriores datos: " + alumnoModoficar.toString());
        alumnoModoficar.setNom(nombre);
        alumnoModoficar.setCognoms(apellidos);
        alumnoModoficar.setDNI(DNI);
        alumnoModoficar.setNotaNum(notanum);
        alumnoModoficar.setNotaLetra(notaletra);
        System.out.println("Nuevos datos: " + alumnoModoficar.toString());
    }

    public static void opcion4(Curs curso) {
        curso.listarAlumnos();
    }

    public static void opcion5(Curs curso) {
        Scanner teclado = new Scanner(System.in);
        Iterator<Alumne> it = curso.listaAlumnos.iterator();
        while (it.hasNext()) {
            Alumne next = it.next();
            System.out.println("Ingrese nueva nota del alumno " + next.getNom() + ": (anterior nota: " + next.getNotaNum() + ")");
            System.out.println("Nueva nota:");
            next.setNotaNum(teclado.nextInt());
        }
    }

    public static void opcion6(Curs curso) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica nota en letra:");
        String notaletra = teclado.next();
        if (!notaletra.equalsIgnoreCase("No presentado") && !notaletra.equalsIgnoreCase("Suspenso") && !notaletra.equalsIgnoreCase("Aprobado") && !notaletra.equalsIgnoreCase("Notable") && !notaletra.equalsIgnoreCase("Sobresaliente") && !notaletra.equalsIgnoreCase("M.Honor")) {
            System.out.println("Nota incorrecta");
        } else {

            double total = 0;
            int alumnos = 0;
            int presentados = 0;
            Iterator<Alumne> it = curso.listaAlumnos.iterator();
            while (it.hasNext()) {
                Alumne next = it.next();
                if (!next.getNotaLetra().equalsIgnoreCase("No presentado")) {
                    presentados++;
                }
                if (notaletra.equalsIgnoreCase(next.getNotaLetra())) {
                    total++;
                }
                alumnos++;
            }
            System.out.println("El total de alumnos con esa nota es: " + total + ", su porcentaje respecto al numero de alumnos en la lista es :" + ((total / alumnos) * 100) + "%, y el total respecto al numero de alumnos presentados es: " + ((total / presentados) * 100) + "%");
        }
    }
}
