
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jeaagu
 */
public class Ejer5 {

    public static void main(String[] args) {
        int vector[] = new int[15];
        boolean encontrado;
        Random aleatorio = new Random();
        int numero;
        for (int i = 0; i < vector.length; i++) {
            encontrado = false;
            numero = aleatorio.nextInt(90) + 1;
            for (int j = 0; j < vector.length; j++) {
                if (vector[j] == numero) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado == false) {
                vector[i] = numero;
            } else {
                i--;
            }
        }

        for (int i = 0; i < vector.length; i++) {
            System.out.print("[" + vector[i] + "] ");
        }
    }
}
