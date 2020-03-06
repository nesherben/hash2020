package com.company;




import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static Map<Integer,Integer> libroPuntos = new HashMap<>();
    public static void main(String[] args) throws IOException {
        IO io = new IO();
        int b = 0, l = 0, d = 0;
        String problema = "resultado";
        ArrayList<Libreria> librerias = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();


        /********ENTRADA DE DATOS********/
        Scanner sc = new Scanner(new File("inputs/c_incunabula.txt"));
        b = sc.nextInt(); //Primera línea
        l = sc.nextInt();
        d = sc.nextInt();
        ArrayList<Integer> libros = new ArrayList<>();
        int libro = 0;
        int numLibros = 0;
        int process = 0;
        int ship = 0;
        Comparador c = new Comparador();
        sc.nextLine();
        for (int i = 0; i < b; i++) {
            scores.add(sc.nextInt());
            libroPuntos.put(i, scores.get(i));
        } //Segunda línea
        sc.nextLine();
// aqui empieza la fiesta de ordenacion
        ArrayList<Integer> sortedLibros = new ArrayList(libroPuntos.keySet());

        Collections.sort(sortedLibros, Collections.reverseOrder());

        ArrayList<Integer> porValor = new ArrayList(libroPuntos.entrySet());
        Collections.sort(porValor, new Comparator() {
            @Override
            public int compare(Object lib1, Object lib2) {
                return ((Comparable) ((Map.Entry) (lib1)).getValue())
                        .compareTo(((Map.Entry) (lib2)).getValue());
            }
        });

        HashMap sorteados = new LinkedHashMap();
        for (Iterator it = porValor.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sorteados.put(entry.getKey(), entry.getValue());
        }

        ArrayList<Integer> solucionados = new ArrayList<>(sorteados.keySet());
        Iterator<Map.Entry<Integer, Integer>> it = sorteados.entrySet().iterator();
        ArrayList<Integer> puntaje = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = it.next();
            puntaje.add(e.getValue());
        }

        for (int k = 0; k < solucionados.size(); k++) {
            //System.out.println(" libro: "+sorteados.get(k)+ "puntos: "+libroPuntos.get(k));
            System.out.println("puntos : " + puntaje.get(k));
            System.out.println("libro : " + solucionados.get(k));


        }
        Comparador.Libro miLibro = new Comparador.Libro(0, 0);
//aqui acaba la fiesta de ordenacion

        for (int i = 0; i < l; i++) { //Cargar librerías
            libros = new ArrayList<>();
            numLibros = sc.nextInt();
            process = sc.nextInt();
            ship = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < numLibros; j++) {
                libro = sc.nextInt();
                if (!libros.contains(libro)) {
                    //miLibro = new Comparador.Libro(solucionados.get(libro),puntaje.get(libro)); //creo un objeto libro con valores justos
                    libros.add(libro);
                    
                }
            }

            sc.nextLine();

            //libros.add(sortedLibros.get(i));
            librerias.add(new Libreria(i, libros, process, ship, scores));
        }

        /********CÓDIGO********/
        //for (Libreria lib : librerias) lib.ordenarLibros(scores); //Ordena todas las librerías

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
        while (!ratios.isEmpty()) {
            if (copiaRatios.get(i).equals(ratios.get(j))) {
                IDsOrdenados.add(j);
                ratios.remove(j);
                i++;

                j = 0;
            } else j++;
        }
        //aqui ordenamos de nuevo
        // va venga chicos que lo tenemos 10 de 10

        //increible jugada





        //cargarte los libros que ya hay en ratios más altos

        ArrayList<Integer> librosUnicos = new ArrayList<>();
        librosUnicos.addAll(librerias.get(IDsOrdenados.get(0)).getLibros());

        for(int x = 1; x < l; x++){
            int libroX = IDsOrdenados.get(x);
            for(int y = 0; y < librerias.get(libroX).getLibros().size(); y++) {
                if(librosUnicos.contains(librerias.get(libroX).getLibros().get(y))){
                    librerias.get(libroX).getLibros().remove(y);
                } else {
                    librosUnicos.add(librerias.get(libroX).getLibros().get(y));
                }

            }

        }

        //calculas como irá el programa y lo metes en salida

        /********SALIDA********/
	    io.output(problema, librerias, IDsOrdenados);
    }

}
