/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean_
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Curs {

    ArrayList<Alumne> listaAlumnos;

    public Curs() {
        listaAlumnos = new ArrayList();
    }

    public ArrayList<Alumne> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumne> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public void addAlumno(Alumne NuevoAlumno) {
        listaAlumnos.add(NuevoAlumno);
    }

    public void removeAlumno(int index, String nombre) {
        Alumne alumnoAux = findAlumno(index, nombre);
        Iterator<Alumne> it = listaAlumnos.iterator();
        while (it.hasNext()) {
            Alumne next = it.next();
            if (alumnoAux == next) {
                it.remove();
            }
        }
    }

    public Alumne findAlumno(int index, String nombre) {
        Iterator<Alumne> it = listaAlumnos.iterator();
        int contador = 0;
        while (it.hasNext()) {
            contador++;
            Alumne alumnoAux = it.next();
            if (index == contador) {
                return alumnoAux;
            } else if (index < 0 && alumnoAux.getNom().equalsIgnoreCase(nombre)) {
                return alumnoAux;
            }
        }
        System.out.println("No se ha encontrado al alumno");
        return null;
    }

    public void listarAlumnos() {
        Iterator<Alumne> it = listaAlumnos.iterator();
        int contador = 1;
        while (it.hasNext()) {
            Alumne next = it.next();
            System.out.print("Alumno nº: " + contador);
            System.out.println(next.toString());
            contador++;
        }
    }

}
