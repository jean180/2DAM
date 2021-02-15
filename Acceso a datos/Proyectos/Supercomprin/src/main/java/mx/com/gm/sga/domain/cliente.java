/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.sql.*;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jean_
 */
@Entity
@Table(name="cliente")
@NamedQueries({
    @NamedQuery(name = "cliente.findAll", query = "SELECT c FROM cliente c"),
    @NamedQuery(name = "cliente.update", query = "UPDATE cliente c SET c.nombre = ?1, c.apellidos = ?2, c.mail = ?3, c.fecha_nacimiento = ?4 WHERE c.DNI = ?5")
})

public class cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id_cliente;
    
    @Column (name = "DNI")
    private String DNI;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "fecha_nacimiento")
    Date fecha_nacimiento;
    
    @Column(name = "mail")
    private String mail;
    
    @Column(name = "puntos")
    private int puntos;
    
    @Column(name = "saldo")
    private double saldo;
    
    @OneToMany(mappedBy = "cliente")
    private List<compra> compras;
    
    @OneToMany(mappedBy = "cliente")
    private List<devolucion> devoluciones;
    
    
    // Constructor por defecto
    public cliente() {
    }
    
    public cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    
    //constructor para insert
    public cliente(String DNI, String nombre, String apellidos, Date fecha, String mail) {
        this.id_cliente = id_cliente;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha;
        this.mail = mail;
        this.puntos = 100;
        this.saldo = 100;
    }
    
    //constructor con todo

    public cliente(int id_cliente, String DNI, String nombre, String apellidos, Date fecha_nacimiento, String mail, int puntos, double saldo) {
        this.id_cliente = id_cliente;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.mail = mail;
        this.puntos = puntos;
        this.saldo = saldo;
    }
    

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha) {
        this.fecha_nacimiento = fecha;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<compra> getCompras() {
        return compras;
    }

    public void setCompras(List<compra> compras) {
        this.compras = compras;
    }

    public List<devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(List<devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }

    @Override
    public String toString() {
        return "" + id_cliente;
    }
}


