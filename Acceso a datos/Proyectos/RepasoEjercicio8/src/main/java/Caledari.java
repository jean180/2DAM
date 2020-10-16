
import java.util.ArrayList;
import java.util.Collections;
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
public class Caledari {

    public ArrayList<Contactes> lista;

    public Caledari() {
        lista = new ArrayList<>();
    }

    public ArrayList<Contactes> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Contactes> lista) {
        this.lista = lista;
    }

    public void addContacto(Contactes contacto) {
        lista.add(contacto);
        ordenarLista();
    }

    public void findContacto(String nombre) {
        boolean encontrado = false;
        Iterator<Contactes> ir = lista.iterator();
        while (ir.hasNext()) {
            Contactes next = ir.next();
            if (nombre.equalsIgnoreCase(next.getNombre())) {
                System.out.println(next.toString());
                encontrado = true;
            }
        }
        if (encontrado == false) {
            System.out.println("No se ha encontrado a ningun contacto con el nombre " + nombre);
        }
    }

    public void removeContacto() {
        Scanner teclado = new Scanner(System.in);
        listar();
        System.out.println("indica que numero eliminar mediante el indice");
        int indice = teclado.nextInt();
        teclado.nextLine();
        Iterator<Contactes> it = lista.iterator();
        int contador = 0;
        while (it.hasNext()) {
            contador++;
            Contactes next = it.next();
            if (contador == indice) {
                lista.remove(next);
                break;
            }
        }
    }

    public void modificarContacto() {
        Scanner teclado = new Scanner(System.in);
        listar();
        System.out.println("indica que numero eliminar mediante el indice");
        int indice = teclado.nextInt();
        teclado.nextLine();
        Iterator<Contactes> it = lista.iterator();
        int contador = 0;
        while (it.hasNext()) {
            contador++;
            Contactes next = it.next();
            if (contador == indice) {
                System.out.println("Nuevo numero:");
                int numero = teclado.nextInt();
                teclado.nextLine();
                next.setTelefono(numero);
                break;
            }
        }
    }

    public void ordenarLista() {
        Collections.sort(lista);
    }

    public void listar() {
        Iterator<Contactes> it = lista.iterator();
        int contador = 0;
        while (it.hasNext()) {
            contador++;
            Contactes next = it.next();
            System.out.println(contador + "-> " + next.toString());
        }
    }

}
