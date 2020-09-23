
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
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int tipo;
        do {
            System.out.println("Indica el tipo de conductor:");
            tipo = teclado.nextInt();
        } while (tipo != 1 && tipo != 2);
        System.out.println("Indica la tasa de alcohol:");
        double tasa;
        do {
            tasa = teclado.nextDouble();
        } while (tasa < 0);
        conductor conductor1 = new conductor(tipo, tasa);
        if (conductor1.getTipo() == 1) {
            if (conductor1.getTasa() > 0.3) {
                System.out.println("NO PUEDE CONDUCIR!!");
            } else {
                System.out.println("Siga circulando");
            }
        } else if (conductor1.getTipo() == 2) {
            if (conductor1.getTasa() > 0.5) {
                System.out.println("NO PUEDE CONDUCIR!!");
            } else {
                System.out.println("Siga circulando");
            }
        }
    }
}
