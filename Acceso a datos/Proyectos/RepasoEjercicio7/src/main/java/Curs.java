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

    public void removeAlumno() {

    }

}
