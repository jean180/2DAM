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
        int contador = 0;
        while (it.hasNext()) {
            Alumne next = it.next();
            if (alumnoAux == next) {
                listaAlumnos.remove(next);
            }
        }
    }

    public Alumne findAlumno(int index, String nombre) {
        Iterator<Alumne> it = listaAlumnos.iterator();
        int contador = 0;
        while (it.hasNext()) {
            contador++;
            Alumne alumnoAux = it.next();
            if (index <= 0 && nombre == alumnoAux.getNom()) {
                return alumnoAux;
            } else if (index == contador) {
                return alumnoAux;
            }
        }
        return null;
    }

    public void listarAlumnos() {
        Iterator<Alumne> it = listaAlumnos.iterator();
        while (it.hasNext()) {
            Alumne next = it.next();
            System.out.println(next.toString());
        }
    }

}
