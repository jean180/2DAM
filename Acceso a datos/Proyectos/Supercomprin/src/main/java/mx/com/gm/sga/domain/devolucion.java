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
@Table(name = "devolucion")
@NamedQueries({
    @NamedQuery(name = "devolucion.findAll", query = "SELECT d FROM devolucion d")
})
public class devolucion {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_devolucion;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private cliente cliente;
    private int id_producto;
    private int id_compra;
    private Date fecha;
    private int puntos;
    private double Importe;

    //Constructor sin datos
    public devolucion() {
    }

    public devolucion(cliente cliente, int id_producto, int id_compra, Date fecha, int puntos, double Importe) {
        this.cliente = cliente;
        this.id_producto = id_producto;
        this.fecha = fecha;
        this.puntos = puntos;
        this.Importe = Importe;
    }

    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
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
        return Importe;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    @Override
    public String toString() {
        return "devolucion{" + "id_devolucion=" + id_devolucion + ", cliente=" + cliente + ", id_producto=" + id_producto + ", fecha=" + fecha + ", puntos=" + puntos + ", Importe=" + Importe + '}';
    }

}
