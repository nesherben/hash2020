package com.company;





import java.io.*;
import java.lang.reflect.Array;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.function.Predicate;

    class SamplePredicate<T> implements Predicate<T> { //para hacer filtritos wapos
        T varc1;
        public boolean test(T varc){
            if(varc1.equals(varc)){
                return true;
            }
            return false;
        }
    }
public class Main {
    static int b = 0, l = 0, d = 0;
    static Map<Integer,Integer> libroPuntos = new HashMap<>();
    public static void main(String[] args) throws IOException {
        IO io = new IO();
        String problema = "resultado";
        ArrayList<Libreria> librerias = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Integer> librosquehay=new ArrayList<>();

        /********ENTRADA DE DATOS********/
        Scanner sc = new Scanner(new File("inputs/a_example.txt"));
        b = sc.nextInt(); //Primera línea
        l = sc.nextInt();
        d = sc.nextInt();
        ArrayList<Integer> libros = new ArrayList<>();
        int libro = 0;
        int numLibros = 0;
        int process = 0;
        int ship = 0;
        sc.nextLine();
        for (int i = 0; i < b; i++) {
            scores.add(sc.nextInt());
            libroPuntos.put(i, scores.get(i));
        } //Segunda línea
        sc.nextLine();
// aqui empieza la fiesta de ordenacion
/*
        ArrayList<Integer> sortedLibros = new ArrayList(libroPuntos.keySet());

        Collections.sort(sortedLibros, Collections.reverseOrder());
*/
        ArrayList<Integer> porValor = new ArrayList(libroPuntos.entrySet());
        //Collections.sort(porValor,Collections.reverseOrder());
        Collections.sort(porValor, new Comparator() {
            @Override
            public int compare(Object lib1, Object lib2) { //aqui se ordenan de mayor a menor
                return ((Comparable) ((Map.Entry) (lib2)).getValue())
                        .compareTo(((Map.Entry) (lib1)).getValue());
            }
        });

        HashMap sorteados = new LinkedHashMap();
        for (Iterator it = porValor.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sorteados.put(entry.getKey(), entry.getValue());
        }

        ArrayList<Integer> solucionados = new ArrayList<>(sorteados.keySet()); //solucionados tiene el orden de los libros por puntos
        Iterator<Map.Entry<Integer, Integer>> it = sorteados.entrySet().iterator();
        ArrayList<Integer> puntaje = new ArrayList<>(); //puntaje tiene los puntos por indice de libro.
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = it.next();
            puntaje.add(e.getValue());
        }


        for (int k = 0; k < solucionados.size(); k++) {
            //System.out.println(" libro: "+sorteados.get(k)+ "puntos: "+libroPuntos.get(k));
            System.out.println("puntos : " + puntaje.get(k));
            System.out.println("libro : " + solucionados.get(k));
            //para mostrar que de mayor a menor los libros y los puntos estan emparejados
        }
//aqui acaba la fiesta de ordenacion


        ArrayList<Integer> auxLibros = new ArrayList<>();
        HashMap<Integer,Integer> copySol = new HashMap<>();
        for(int i = 0; i< solucionados.size();i++){
            copySol.put(i,solucionados.get(i));
        }
        for (int i = 0; i < l; i++) { //Cargar librerías
            auxLibros.clear();
            libros = new ArrayList<>();
            numLibros = sc.nextInt();
            process = sc.nextInt();
            ship = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < numLibros; j++) {
                libro = sc.nextInt();
                if (!auxLibros.contains(libro)) {
                    auxLibros.add(libro);

                    //System.out.println(solucionados.size());


                }

            }
            SamplePredicate<Integer> filtrado = new SamplePredicate<>();


                for(int y=0;y<copySol.size();y++){for(int x=0;x<auxLibros.size();x++){
                    filtrado.varc1 = auxLibros.get(x);
                    if (copySol.get(y).equals(filtrado.varc1)) {

                        libros.add(copySol.get(y)); //revisar

                    }
                }
            }
            //solucionados.removeIf(x -> !auxLibros.contains(x));
/*
            for(int x = 0; x<solucionados.size();x++){
                libros.add(solucionados.get(x));
            }
            solucionados.clear();
            for(int k = 0;k< solucionados.size();k++){
                solucionados.add(copySol.get(k));
            }
*/

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
        librosquehay.addAll(librerias.get(IDsOrdenados.get(0)).getLibros());

        for(int x = 1; x < l; x++){
            int libroX = IDsOrdenados.get(x);
            for(int z=0;z<librosquehay.size();z++){
            for(int y = 0; y < librerias.get(libroX).getLibros().size(); y++) {
                System.out.println(librerias.get(libroX).getLibros());
                if(librosquehay.get(z).equals(librerias.get(libroX).getLibros().get(y))) {
                    librerias.get(libroX).getLibros().remove(y);


                }
            }

            }

        }
        //calculas como irá el programa y lo metes en salida

        /********SALIDA********/
	    io.output(problema, librerias, IDsOrdenados);
    }

}
