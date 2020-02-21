package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IO io = new IO();
        int b = 0, l = 0, d = 0;
        String problema = "resultado";
        ArrayList<Libreria> librerias = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        /********ENTRADA DE DATOS********/
        Scanner sc = new Scanner(new File("D:/Desktop/hash2020/f_libraries_of_the_world.txt"));
        //while (sc.hasNextLine()){
            b = sc.nextInt(); //Primera línea
            l = sc.nextInt();
            d = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < b; i++) scores.add(sc.nextInt()); //Segunda línea
            sc.nextLine();
            for (int i = 0; i < l; i++) { //Cargar librerías
                ArrayList<Integer> libros = new ArrayList<>();
                int numLibros = sc.nextInt();
                int process = sc.nextInt();
                int ship = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < numLibros; j++){
                    int libro = sc.nextInt();
                    if (!libros.contains(libro)) libros.add(libro);
                }
                sc.nextLine();
                librerias.add(new Libreria(i, libros, process, ship));
            }
        //}

        /********CÓDIGO********/
        HashMap<Integer, Float> ratios = new HashMap<>();
        ArrayList<Float> copiaRatios = new ArrayList<>();
        ArrayList<Integer> IDsOrdenados = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            float ratio = librerias.get(i).ratio(scores);
            ratios.put(i, ratio);
            copiaRatios.add(ratio);

        }

        Collections.sort(copiaRatios, Collections.reverseOrder());

        int i = 0, j = 0;
        while (!ratios.isEmpty()){
            if (copiaRatios.get(i).equals(ratios.get(j))){
                IDsOrdenados.add(j);
                ratios.remove(j);
                i++;

                j = 0;
            } else j++;
        }

        //cargarte los libros que ya hay en ratios más altos

        //for(int i = 0; i < l; i++){

        //}

        //calculas como irá el programa y lo metes en salida

        /********SALIDA********/
	    io.output(problema, librerias, IDsOrdenados);
    }
}
