package com.example.mylistaobjetos;

import android.widget.ImageView;

public class Titular {
    String titulo, subtitulo;
    int img;

    public Titular(String titulo, String subtitulo, int img) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "titulo:'" + titulo + ". subtitulo='" + subtitulo;
    }
}

