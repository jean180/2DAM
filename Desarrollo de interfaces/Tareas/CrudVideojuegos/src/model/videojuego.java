/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jean_
 */
public class videojuego {

    private int id, min_jugadores, max_jugadores, pegi;
    private String titulo, categoria;

    public videojuego() {
    }

    public videojuego(int id) {
        this.id = id;
    }

    public videojuego(int min_jugadores, int max_jugadores, int pegi, String titulo, String categoria) {
        this.min_jugadores = min_jugadores;
        this.max_jugadores = max_jugadores;
        this.pegi = pegi;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public videojuego(int id, int min_jugadores, int max_jugadores, int pegi, String titulo, String categoria) {
        this.id = id;
        this.min_jugadores = min_jugadores;
        this.max_jugadores = max_jugadores;
        this.pegi = pegi;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMin_jugadores() {
        return min_jugadores;
    }

    public void setMin_jugadores(int min_jugadores) {
        this.min_jugadores = min_jugadores;
    }

    public int getMax_jugadores() {
        return max_jugadores;
    }

    public void setMax_jugadores(int max_jugadores) {
        this.max_jugadores = max_jugadores;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
