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
public class Coches {

    private int precio;
    private String matricula, marca, DNI;

    public Coches() {
    }

    public Coches(String matricula) {
        this.matricula = matricula;
    }

    public Coches(int precio, String marca, String DNI) {
        this.precio = precio;
        this.marca = marca;
        this.DNI = DNI;
    }

    public Coches(int precio, String matricula, String marca, String DNI) {
        this.precio = precio;
        this.marca = marca;
        this.DNI = DNI;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Coches{" + "precio=" + precio + ", matricula=" + matricula + ", marca=" + marca + ", DNI=" + DNI + '}';
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
