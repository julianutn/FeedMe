package com.example.julia.feedme;

import java.util.ArrayList;

/**
 * Created by julia on 09-Oct-17.
 */

public class Receta {
    String nombre;
    int tiempo;


    public Receta() {
    }

    public Receta(String nombre, int tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}

