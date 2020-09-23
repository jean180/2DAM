/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.Scanner;

/**
 *
 * @author jeaagu
 */
public class Ejer2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int a, b, c;
        System.out.println("Indica la longitud del lado A");
        a = teclado.nextInt();
        b = teclado.nextInt();
        c = teclado.nextInt();
        triangulo triangulo1 = new triangulo(a, b, c);
        if (triangulo1.getA() + triangulo1.getB() > triangulo1.getC()) {
            System.out.println("Es un tringulo!");
        } else {
            System.out.println("No es un triangulo");
        }
    }
}
