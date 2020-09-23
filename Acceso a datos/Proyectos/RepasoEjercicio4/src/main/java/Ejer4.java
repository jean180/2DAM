
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jeaagu
 */
public class Ejer4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escribe un numero:");
        int numero = teclado.nextInt();
        columnas(numero);
    }

    public static void columnas(int numero) {
        for (int i = 1; i <= numero; i++) {
            System.out.print(i + "\t");
            if (i % 2 == 0) {
                System.out.print(i + "\t");
            } else {
                System.out.print("\t");
            }
            if (i % 3 == 0) {
                System.out.println(i + "\t");
            } else {
                System.out.println("");
            }
        }
    }
}
