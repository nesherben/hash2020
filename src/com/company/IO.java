package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IO {

    public ArrayList<String> Input(char problema) throws IOException {
        int i = 0;
        Reader in = new FileReader(".txt");
        Reader br = new BufferedReader(in);
        ArrayList<String> sol = new ArrayList<>();
        String linea;
        while((linea = ((BufferedReader) br).readLine())!=null) {
            sol.add(linea);
            i++;
        }
        return sol;
    }

    public void Output(String problema, ArrayList<Libreria> librerias, ArrayList<Integer> IDordenados) throws FileNotFoundException {
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
    }
}
