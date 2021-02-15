/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jean_
 */
@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "producto.findAll", query = "SELECT p FROM producto p"),})
public class producto {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;
    private String nombre;
    private double precio;
    private int puntos;

    public producto() {
    }

    public producto(String nombre, double precio, int puntos) {
        this.nombre = nombre;
        this.precio = precio;
        this.puntos = puntos;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", precio=" + precio + ", puntos=" + puntos + '}';
    }

}
