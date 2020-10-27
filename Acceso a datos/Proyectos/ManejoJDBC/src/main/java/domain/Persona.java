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
public class Persona {

    private int id_Persona, edad;
    private String nombre, apellidos, email;

    public Persona() {
    }

    public Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

    public Persona(int edad, String nombre, String apellidos, String email) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Persona(int id_Persona, int edad, String nombre, String apellidos, String email) {
        this.id_Persona = id_Persona;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_Persona=" + id_Persona + ", edad=" + edad + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + '}';
    }

}
