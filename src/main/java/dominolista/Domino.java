/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominolista;

import static dominolista.FichaDomino.generaFichaAleatoria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author cristina
 */
public class Domino {

    private ArrayList<FichaDomino> listaFichas;

    //Constructor sin parámetros, que crea la lista y la rellena con todas las
    //fichas, sin fichas repetidas (la ficha 2:1 es igual a la 1:2).
    public Domino() {
        listaFichas = new ArrayList<>();
        rellenarLista(listaFichas);
    }

    //Este método rellena la lista con todas las posibles fichas únicas de un dominó 
    private void rellenarLista(ArrayList<FichaDomino> listaFichas) {
        //nº de filas existentes
        int j = 6;
        //En este for controlamos las columnas
        for (int i = 6; i >= 0; i--) {
            //En este for se controla las filas
            for (int k = 0; k <= j; k++) {
                listaFichas.add(new FichaDomino(i, k));
            }
            //Quitamos una fila
            j--;
        }
    }

    //Getters y setters para trabajar mejor
    public ArrayList<FichaDomino> getListaFichas() {
        return listaFichas;
    }

    public void setListaFichas(ArrayList<FichaDomino> listaFichas) {
        this.listaFichas = listaFichas;
    }

    //Mueve las fichas aleatoriamente para que queden "desordenadas" dentro de la estructura
    public void mezclarFichas() {
        Collections.shuffle(listaFichas);
    }

    //Devuelve una ficha aleatoria del dominó y la elimina de la estructura. Si no hay fichas por sacar devolverá null.
    public FichaDomino sacarFicha() {
        Random random = new Random();
        int aleatorio = random.nextInt(28);
        try {
            listaFichas.get(aleatorio);
            System.out.println("La ficha " + listaFichas.get(aleatorio).toString() + " es la elegida y se va a eliminar de la lista");
            listaFichas.remove(aleatorio);
            return listaFichas.get(aleatorio);

        } catch (NullPointerException npe) {
            System.out.println("No hay fichas en la lista");
            return null;
        }
    }

    //Guarda la ficha f en el dominó. Si esa ficha ya existe en el dominó no se guarda.
    public void meterFicha(FichaDomino f) {
        if (!listaFichas.contains(f)) {
            listaFichas.add(f);
        } else {
            System.out.println("La lista ya contiene la ficha");
        }
    }

    //Que saca "n" fichas del dominó, devolviendo un array de "n" objetos FichaDomino
    public FichaDomino[] repartir(int n) {
        FichaDomino[] listaRepartida = new FichaDomino[n];
        Random random = new Random();
        for (int j = 0; j < n; j++) {

            listaRepartida[j] = listaFichas.get(random.nextInt(listaFichas.size()));

            listaFichas.remove(listaRepartida[j]);

        }
        return listaRepartida;
    }

}
