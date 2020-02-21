package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IO {

    public void output(String problema, ArrayList<Libreria> librerias, ArrayList<Integer> IDordenados) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(problema + ".txt");
        //ArrayList<String> solucion = new ArrayList<>();

        int idActual = 0;
        int numLibros = 0;

        printWriter.println(librerias.size());

        for (int i = 0; i < librerias.size(); i++){
            idActual = IDordenados.get(i);
            numLibros = librerias.get(idActual).getLibros().size();
            printWriter.println(idActual + " " + numLibros);
            for(int j = 0; j < numLibros; j++){
                printWriter.print(librerias.get(idActual).getLibros().get(j) + " ");

            }
            printWriter.println();
        }
        printWriter.close();
    }
}
