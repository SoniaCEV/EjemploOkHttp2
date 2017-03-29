package com.example.alumnos.ejemplookhttp;


import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultadoBean implements Serializable{
    private int resultado;
    private ArrayList<LibroBean> libros;

    public ResultadoBean() {
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public ArrayList<LibroBean> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<LibroBean> libros) {
        this.libros = libros;
    }

    public static ResultadoBean fromJson(String json){
        if(json!=null && !json.isEmpty()) {
            Gson gson = new Gson();
            ResultadoBean resultadoBean = gson.fromJson(json, ResultadoBean.class);
            return resultadoBean;
        }else{
            return new ResultadoBean();
        }

    }
}
