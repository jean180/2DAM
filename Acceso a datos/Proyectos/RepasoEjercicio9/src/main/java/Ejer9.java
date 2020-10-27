
import java.util.ArrayList;
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
public class Ejer9 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int eleccion;
        ArrayList<Triangle> lista = new ArrayList<>();

        do {
            System.out.println("1-Crear triangulo");
            System.out.println("2-Mostrar coordenadas");
            System.out.println("3-Cambiar coordenadas");
            System.out.println("4-Distancia entre puntos");
            System.out.println("5-Escribir datos de triangulo");
            System.out.println("6-Perimetro del triangulo");
            eleccion = teclado.nextInt();
            teclado.nextLine();
            switch (eleccion) {
                case 1:
                    opcion1(lista);
                    break;
                case 2:
                    opcion2(lista);
                    break;
                case 3:
                    opcion3(lista);
                    break;
                case 4:
                    opcion4(lista);
                    break;
                case 5:
                    opcion5(lista);
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        } while (true);

    }

    public static void opcion1(ArrayList lista) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe las coordenadas del primer punto separados por espacios");
        int X = teclado.nextInt();
        int Y = teclado.nextInt();
        Punt A = new Punt(X, Y);
        System.out.println("Escribe las coordenadas del segundo punto separados por espacios");
        X = teclado.nextInt();
        Y = teclado.nextInt();
        Punt B = new Punt(X, Y);
        System.out.println("Escribe las coordenadas del tercer punto separados por espacios");
        X = teclado.nextInt();
        Y = teclado.nextInt();
        Punt C = new Punt(X, Y);

        teclado.nextLine();
        Triangle triangulo = new Triangle(A, B, C);
        lista.add(triangulo);
    }

    public static void opcion2(ArrayList lista) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Seleccione un numero del 1-" + lista.size() + " indicando el triangulo");
        int triangulo = teclado.nextInt();
        Iterator<Triangle> it = lista.iterator();
        int contador = 0;
        while (it.hasNext()) {
            contador++;
            Triangle next = it.next();
            if (contador == triangulo) {
                System.out.println("Seleccion un punto(A,B o C):");

                char letra = teclado.next().toUpperCase().charAt(0);

                switch (letra) {
                    case 'A':
                        System.out.println(next.getA().toString());
                        break;
                    case 'B':
                        System.out.println(next.getB().toString());
                        break;
                    case 'C':
                        System.out.println(next.getC().toString());
                        break;
                }
                break;
            }
        }

    }

    public static void opcion3(ArrayList lista) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Seleccione un numero del 1-" + lista.size() + " indicando el triangulo");
        int triangulo = teclado.nextInt();
        Iterator<Triangle> it = lista.iterator();
        int contador = 0;
        while (it.hasNext()) {
            contador++;
            Triangle next = it.next();
            if (contador == triangulo) {
                System.out.println("Seleccion un punto(A,B o C):");

                char letra = teclado.next().toUpperCase().charAt(0);
                int X, Y;
                switch (letra) {
                    case 'A':
                        System.out.println("Escribe las coordenadas del punto A separas por espacio");
                        X = teclado.nextInt();
                        Y = teclado.nextInt();
                        next.getA().setX(X);
                        next.getA().setY(Y);
                        break;
                    case 'B':
                        System.out.println("Escribe las coordenadas del punto B separas por espacio");
                        X = teclado.nextInt();
                        Y = teclado.nextInt();
                        next.getB().setX(X);
                        next.getB().setY(Y);
                        break;
                    case 'C':
                        System.out.println("Escribe las coordenadas del punto C separas por espacio");
                        X = teclado.nextInt();
                        Y = teclado.nextInt();
                        next.getC().setX(X);
                        next.getC().setY(Y);
                        break;
                }
                System.out.println("Nuevas coordenadas: " + next.toString());
                break;
            }
        }
    }

    public static void opcion4(ArrayList lista) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Seleccione un numero del 1-" + lista.size() + " indicando el triangulo");
        int triangulo = teclado.nextInt();
        Iterator<Triangle> it = lista.iterator();
        int contador = 0;
        while (it.hasNext()) {
            contador++;
            Triangle next = it.next();
            if (contador == triangulo) {
                System.out.println("Seleccion un punto(A,B o C):");

                char letra1 = teclado.next().toUpperCase().charAt(0);
                System.out.println("Seleccion otro punto diferente al anterior:");
                char letra2 = teclado.next().toUpperCase().charAt(0);
                if (letra1 != letra2) {
                    if (letra1 == 'A') {
                        if (letra2 == 'B') {
                            System.out.println("La distancia entre la coordenada X de A y B es " + (next.getA().getX() - next.getB().getX()) + " y la coordenada Y es " + (next.getA().getY() - next.getB().getY()));
                        } else if (letra2 == 'C') {
                            System.out.println("La distancia entre la coordenada X de A y C es " + (next.getA().getX() - next.getC().getX()) + " y la coordenada Y es " + (next.getA().getY() - next.getC().getY()));
                        }
                    } else if (letra1 == 'B') {
                        if (letra2 == 'A') {
                            System.out.println("La distancia entre la coordenada X de B y A es " + (next.getB().getX() - next.getA().getX()) + " y la coordenada Y es " + (next.getB().getY() - next.getA().getY()));

                        } else if (letra2 == 'C') {
                            System.out.println("La distancia entre la coordenada X de B y C es " + (next.getB().getX() - next.getC().getX()) + " y la coordenada Y es " + (next.getB().getY() - next.getC().getY()));
                        }
                    } else if (letra1 == 'C') {
                        if (letra2 == 'A') {
                            System.out.println("La distancia entre la coordenada X de C y A es " + (next.getC().getX() - next.getA().getX()) + " y la coordenada Y es " + (next.getC().getY() - next.getA().getY()));
                        } else if (letra2 == 'B') {
                            System.out.println("La distancia entre la coordenada X de C y B es " + (next.getC().getX() - next.getB().getX()) + " y la coordenada Y es " + (next.getC().getY() - next.getB().getY()));
                        }
                    }
                } else {
                    System.out.println("Tienen que ser puntos diferentes");
                }
            }
        }
    }

    public static void opcion5(ArrayList lista) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Seleccione un numero del 1-" + lista.size() + " indicando el triangulo");
        int triangulo = teclado.nextInt();
        Iterator<Triangle> it = lista.iterator();
        int contador = 0;
        while (it.hasNext()) {
            contador++;
            Triangle next = it.next();
            if (contador == triangulo) {
                System.out.println(next.toString());
            }
        }
    }

    public static void listarTriangulos(ArrayList lista) {
        Iterator<Triangle> it = lista.iterator();
        while (it.hasNext()) {
            Triangle next = it.next();
            System.out.println("1." + next.toString());
        }
    }

}
