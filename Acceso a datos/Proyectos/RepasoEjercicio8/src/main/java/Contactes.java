/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean_
 */
public class Contactes implements Comparable {

    public String nombre;
    public int telefono;

    public Contactes() {

    }

    public Contactes(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return " nombre: " + nombre + ", telefono: " + telefono;
    }

    @Override
    public int compareTo(Object t) {
        Contactes contacto = (Contactes) t;
        if (this.nombre.compareToIgnoreCase(contacto.nombre) == 0) {
            if (contacto.telefono > this.telefono) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return this.nombre.compareToIgnoreCase(contacto.nombre);
        }
    }

}
