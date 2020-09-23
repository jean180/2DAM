
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
public class Ejer2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int a, b, c;
        System.out.println("Indica la longitud del lado A");
        a = teclado.nextInt();
        System.out.println("Indica la longitud del lado B");
        b = teclado.nextInt();
        System.out.println("Indica la longitud del lado C");
        c = teclado.nextInt();
        Triangulo triangulo1 = new Triangulo(a, b, c);
        if (triangulo1.getA() + triangulo1.getB() > triangulo1.getC()) {
            System.out.println("Es un tringulo!");
        } else {
            System.out.println("No es un triangulo");
        }
    }
}
