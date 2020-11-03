/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import datos.CochesDAO;
import datos.PropietariosDAO;
import domain.Coches;
import domain.Propietarios;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author jeaagu
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("indica que quieres hacer");
            System.out.println("1-Mostrar coches");
            System.out.println("2-Insertar coche");
            System.out.println("3-Borrar coche");
            System.out.println("4-Actualizar coche");
            System.out.println("5-Mostrar personas");
            System.out.println("6-Insertar persona");
            System.out.println("7-Borrar Persona");
            System.out.println("8-Actualizar Persona");
            System.out.println("9-Mostrar coches de un propietario");
            System.out.println("10-Salir");

            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    Opcion1();
                    break;
                case 2:
                    Opcion2();
                    break;
                case 3:
                    Opcion3();
                    break;
                case 4:
                    Opcion4();
                    break;
                case 5:
                    Opcion5();
                    break;
                case 6:
                    Opcion6();
                    break;
                case 7:
                    Opcion7();
                    break;
                case 8:
                    Opcion8();
                    break;
                case 9:
                    Opcion9();
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    public static void Opcion1() throws SQLException {
        CochesDAO cocheDAO = new CochesDAO();
        List<Coches> coches = new CochesDAO().seleccionar();

        coches.forEach(coche -> {
            System.out.println("coche = " + coche);
        });
    }

    public static void Opcion2() throws SQLException {
        Scanner teclado = new Scanner(System.in);

        CochesDAO cochesDAO = new CochesDAO();
        System.out.println("Indica el precio del coche");
        int precio = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Indica la matricula del coche");
        String matricula = teclado.next();
        System.out.println("Indica la marca del coche");
        String marca = teclado.next();
        System.out.println("Indica el dni del propietario");
        String DNI = teclado.next();
        Coches cochenuevo = new Coches(precio, matricula, marca, DNI);
        cochesDAO.insertar(cochenuevo);
    }

    public static void Opcion3() throws SQLException {
        Scanner teclado = new Scanner(System.in);

        CochesDAO cochesDAO = new CochesDAO();
        System.out.println("Indica la matricula del coche");
        String matricula = teclado.next();
        Coches cochenuevo = new Coches(matricula);
        cochesDAO.borrar(cochenuevo);
    }

    public static void Opcion4() throws SQLException {
        Scanner teclado = new Scanner(System.in);

        CochesDAO cochesDAO = new CochesDAO();
        System.out.println("Indica el precio del coche");
        int precio = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Indica la matricula del coche");
        String matricula = teclado.next();
        System.out.println("Indica la marca del coche");
        String marca = teclado.next();
        System.out.println("Indica el dni del propietario");
        String DNI = teclado.next();
        Coches cochenuevo = new Coches(precio, matricula, marca, DNI);
        cochesDAO.actualizar(cochenuevo);
    }

    public static void Opcion5() throws SQLException {
        PropietariosDAO propietarioDAO = new PropietariosDAO();
        List<Propietarios> propietarios = new PropietariosDAO().seleccionar();

        propietarios.forEach(propietario -> {
            System.out.println("Persona = " + propietario);
        });
    }

    public static void Opcion6() throws SQLException {
        Scanner teclado = new Scanner(System.in);
        PropietariosDAO propietarioDAO = new PropietariosDAO();
        System.out.println("Indica el DNI del propietario");
        String DNI = teclado.next();
        System.out.println("Indica el nombre del propietario");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        System.out.println("Indica la edad del propietario");
        int edad = teclado.nextInt();
        teclado.nextLine();
        Propietarios propietario = new Propietarios(edad, DNI, nombre);
        propietarioDAO.insertar(propietario);
    }

    public static void Opcion7() throws SQLException {
        Scanner teclado = new Scanner(System.in);
        PropietariosDAO propietarioDAO = new PropietariosDAO();
        System.out.println("Indica el DNI del propietario");
        String DNI = teclado.next();
        Propietarios propietarioborrar = new Propietarios(DNI);
        propietarioDAO.borrar(propietarioborrar);
    }

    public static void Opcion8() throws SQLException {
        Scanner teclado = new Scanner(System.in);
        PropietariosDAO propietarioDAO = new PropietariosDAO();
        System.out.println("Indica el DNI del propietario");
        String DNI = teclado.next();
        System.out.println("Indica el nombre del propietario");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        System.out.println("Indica la edad del propietario");
        int edad = teclado.nextInt();
        teclado.nextLine();
        Propietarios propietario = new Propietarios(edad, DNI, nombre);
        propietarioDAO.actualizar(propietario);
    }

    public static void Opcion9() throws SQLException {
        CochesDAO cocheDAO = new CochesDAO();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica el DNI del propietario");
        String DNI = teclado.next();
        System.out.println(cocheDAO.seleccionar_general(DNI));
    }
}
