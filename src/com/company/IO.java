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
        int libvacias =0;
        for(int x = 0; x< librerias.size();x++){
            if(librerias.get(x).getLibros().size() == 0){
                libvacias++;
            }
        }
        printWriter.println(librerias.size()-libvacias);

        for (int i = 0; i < librerias.size()-libvacias; i++){
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
