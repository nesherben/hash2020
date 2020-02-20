package com.company;

import java.util.ArrayList;

public class Libreria {
    private int ID;
    private ArrayList<Integer> libros = new ArrayList<>();
    private int signup;
    private int ship;

    public ArrayList<Integer> getLibros() {
        return libros;
    }

    public Libreria(int ID, ArrayList<Integer> libros, int signup, int ship) {
        this.ID = ID;
        this.libros = libros;
        this.signup = signup;
        this.ship = ship;
    }

    public float ratio(ArrayList<Integer> scores){
        float librosPorDia;
        int puntuacion = 0;
        for(int i = 0; i < this.libros.size(); i++)
            puntuacion += scores.get(this.libros.get(i));
        librosPorDia = this.libros.size() / this.ship;
        return puntuacion / (signup + librosPorDia);
    }
}
