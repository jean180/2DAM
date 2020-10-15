
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
public class Ejer6 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float matriz[][] = new float[18][10];
        int opcion;
        System.out.println("BIENVENIDO A MI EMPRESA!");
        do {

            do {
                System.out.println("Escoge una opcion:");
                System.out.println("1- Almacenar ingresos"
                        + "\t2- Total proveedor"
                        + "\t3- Total empresa");
                opcion = teclado.nextInt();
            } while (opcion < 1 || opcion > 3);
            switch (opcion) {
                case 1:
                    opcion1(matriz);
                    break;
                case 2:
                    opcion2(matriz);
                    break;
                case 3:
                    opcion3(matriz);
                    break;
                case 4:
                    System.out.println("Adios");
                    System.exit(0);
            }
        } while (true);
    }

    public static float[][] opcion1(float[][] matriz) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica proveedor 1-18");
        int proveedor = teclado.nextInt() - 1;
        for (int i = 0; i < matriz.length; i++) {
            if (i == proveedor) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j] == 0.0) {
                        System.out.println("Ingresa el valor de las ventas");
                        float ingreso = teclado.nextFloat();
                        matriz[i][j] = ingreso;
                        i = matriz.length;
                        break;
                    }
                }
            }
        }
        return matriz;
    }

    public static void opcion2(float[][] matriz) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica proveedor");
        int proveedor = teclado.nextInt() - 1;
        float suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (i == proveedor) {
                for (int j = 0; j < matriz[0].length; j++) {
                    suma += matriz[i][j];
                }
            }
        }
        System.out.println("La suma de las ventas del proovedor nº " + proveedor + " es de: " + suma);
    }

    public static void opcion3(float[][] matriz) {
        float suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                suma += matriz[i][j];
            }
        }
        System.out.println("la suma total es de " + suma);
    }
}
