package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Libreria{
    private int ID;
    private ArrayList<Integer> libros;
    private int signup;
    private int ship;

    public ArrayList<Integer> getLibros() {
        return libros;
    }

    public Libreria(int ID, ArrayList libros, int signup, int ship, ArrayList<Integer> scores) {
        Comparador c = new Comparador();
        //ArrayList<Integer> libretos = new ArrayList<>(libros.getIDlibro());
        this.ID = ID;
        this.libros = libros;//c.compareTo(libros,scores);
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

    /*public void ordenarLibros(ArrayList<Integer> scores){
        this.libros = new Comparador().compareTo(this.libros, scores);
    }*/
}
