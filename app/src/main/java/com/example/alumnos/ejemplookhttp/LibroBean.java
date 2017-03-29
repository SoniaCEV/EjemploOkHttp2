package com.example.alumnos.ejemplookhttp;

import java.io.Serializable;

public class LibroBean implements Serializable{
    private String ISBN;
    private String Titulo;

    public LibroBean() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    @Override
    public String toString() {
        return ISBN + ": "+Titulo;
    }
}
