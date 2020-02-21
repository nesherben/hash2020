package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Comparador {

    class Libro {

        private int IDlibro;
        private int puntuacion;

        public Libro(int IDlibro, int puntuacion) {
            this.IDlibro = IDlibro;
            this.puntuacion = puntuacion;
        }

        public int getPuntuacion() {
            return puntuacion;
        }

        public int getIDlibro() {
            return IDlibro;
        }
    }

    public ArrayList<Integer> compareTo(ArrayList<Integer> desordenados, ArrayList<Integer> scores) {
        ArrayList<Libro> orden = new ArrayList<Libro>();
        for (int i = 0; i < scores.size(); i++){
            Libro l = new Libro(i, scores.get(i));
            orden.add(l);
        }

        Collections.sort(orden, new Comparator<Libro>() { //Ordena todos los libros por la puntuación
            @Override
            public int compare(Libro l1, Libro l2) {
                return Integer.valueOf(l2.getPuntuacion()).compareTo(Integer.valueOf(l1.getPuntuacion()));
            }
        });

        /* EXPLICACIÓN DEL BLOQUE SIGUIENTE
        1. Me copio todos los libros existentes, que ya están ordenados por puntuación.
        2. Si el libro no está en los desordenados, se borra y se le resta uno a la i por la redimensión.
        3. Finalmente en librosOrdenados me quedarán los mismo que en desordenados pero en orden (valga la redundancia).
         */
        ArrayList<Integer> librosOrdenados = new ArrayList<>();
        for (int i = 0; i < orden.size(); i++) librosOrdenados.add(orden.get(i).getIDlibro());
        for (int i = 0; i < librosOrdenados.size(); i++){
            if(!desordenados.contains(librosOrdenados.get(i))){
                librosOrdenados.remove(i);
                i--;
            }
        }

        return librosOrdenados;
    }
}
