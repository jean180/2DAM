/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jean_
 */
@Entity
@Table(name = "compra")
@NamedQueries({
    @NamedQuery(name = "compra.findAll", query = "SELECT c FROM compra c"),
})

public class compra {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_compra;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private cliente cliente;
    private int id_producto;
    private Date fecha;
    private int puntos;
    private double importe;
    
    // Constructor
    public compra() {
    }
    
    // constructor con datos
    public compra(cliente cliente, int id_producto, Date fecha, int puntos, double importe) {
        this.cliente = cliente;
        this.id_producto = id_producto;
        this.fecha = fecha;
        this.puntos = puntos;
        this.importe = importe;
    }
    
    //constructor update
    public compra(int id_compra, int id_cliente, int id_producto, Date fecha, int puntos, double importe){
        this.id_compra = id_compra;
        this.cliente = cliente;
        this.id_producto = id_producto;
        this.fecha = fecha;
        this.puntos = puntos;
        this.importe = importe;
    }
    
    //getter and setters

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "compra{" + "id_compra=" + id_compra + ", cliente=" + cliente + ", id_producto=" + id_producto + ", fecha=" + fecha + ", puntos=" + puntos + ", importe=" + importe + '}';
    }
    
}


