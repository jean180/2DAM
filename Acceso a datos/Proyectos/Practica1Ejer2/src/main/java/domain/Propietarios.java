/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jeaagu
 */
public class Propietarios {

    private int edad;
    private String DNI, Nombre;

    public Propietarios() {
    }

    public Propietarios(String dni) {
        this.DNI = dni;
    }

    public Propietarios(int edad, String Nombre) {
        this.edad = edad;
        this.Nombre = Nombre;
    }

    public Propietarios(int edad, String dni, String Nombre) {
        this.edad = edad;
        this.Nombre = Nombre;
        this.DNI = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Propietarios{" + "edad=" + edad + ", DNI=" + DNI + ", Nombre=" + Nombre + '}';
    }
}
