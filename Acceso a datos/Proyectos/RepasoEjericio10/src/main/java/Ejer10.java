
import java.util.ArrayList;
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
public class Ejer10 {

    public static void main(String[] args) {
        ArrayList<CuentaCorriente> listacuentas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("1-Rellenar cuenta");
            System.out.println("2-Cambiar saldo");
            System.out.println("3-Salir");
            System.out.println("Elige una opcion: ");
            int opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    opcion1(listacuentas);
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } while (true);

    }

    public static void opcion1(ArrayList lista) {
        Scanner teclado = new Scanner(System.in);
        int numero;
        /*do {
            System.out.println("indica el numero de titulares de la cuenta");
            numero = teclado.nextInt();
            teclado.nextLine();
            if (numero < 1 || numero > 2) {
                System.out.println("deben haber de 1 a 2 titulares");
            }
        } while (numero < 1 || numero > 2);
        Titular titular;
        for (int i = 1; i <= numero; i++) {
            System.out.println("Indica el nombre del cliente");
            String nombre = teclado.nextLine();
            System.out.println("Indica el apellido del cliente " + nombre);
            String apellidos = teclado.nextLine();
            System.out.println("Indica la dirección del cliente " + nombre + " " + apellidos);
            String direccion = teclado.nextLine();
            System.out.println("Indica el DNI del cliete " + nombre + " " + apellidos);
            String DNI = teclado.next();
            titular = new Titular(nombre, apellidos, direccion, DNI);
        }
        long cuenta;
        do {
            System.out.println("Indica el numero de la cuenta (20 numeros)");
            cuenta = teclado.nextLong();
            if (cuenta.size) {
                break;
            }
            System.out.println("El numero de cuenta: " + cuenta + " contiene letras");
        } while (true);
        System.out.println(cuenta);
         */
    }

}
