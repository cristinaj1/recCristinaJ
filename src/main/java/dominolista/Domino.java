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
        //número de filas existentes
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

    //Getters y setters para trabajar mejor con la lista
    public ArrayList<FichaDomino> getListaFichas() {
        return listaFichas;
    }

    public void setListaFichas(ArrayList<FichaDomino> listaFichas) {
        this.listaFichas = listaFichas;
    }

    //Mueve las fichas aleatoriamente para que queden "desordenadas" dentro de la estructura
    public void mezclarFichas() {
        //Este método las mezcla aleatoriamente
        Collections.shuffle(listaFichas);
    }

    //Nos ayuda a comprobar si la ficha se encuentra repetida en el arrayList o no
    private boolean comprobarRepeticion(int izq, int der) {
        for (FichaDomino fichaPrueba : listaFichas) {
//            Este if comprueba lo siguiente
//            [2|1] [1|2]
//              X    | |
//            [1|2] [1|2]
//            Comprueba en x y en vertical si son la misma ficha o no(al derecho y a la inversa)
//            
            if (fichaPrueba.getSuperior() == izq && fichaPrueba.getInferior() == der
                    || fichaPrueba.getInferior() == izq && fichaPrueba.getSuperior() == der) {
                return false;
            }
        }
        return true;

    }

    //Devuelve una ficha aleatoria del dominó y la elimina de la estructura. Si no hay fichas por sacar devolverá null.
    public FichaDomino sacarFicha() {
        Random random = new Random();
        int aleatorio = random.nextInt(28);
        try {
            listaFichas.get(aleatorio);
            System.out.println("La ficha " + listaFichas.get(aleatorio).toString() + " es la elegida y se va a eliminar de la lista");
            //Comprobamos primero que se pueda borrar el derecho y al revés
            if ((!comprobarRepeticion(listaFichas.get(aleatorio).getInferior(), listaFichas.get(aleatorio).getSuperior()))) {
                listaFichas.remove(aleatorio);
            }
            return listaFichas.get(aleatorio);

            //Puede dar out of bounds cuando quiere borrar la ficha [ | ] y un null pointer si hacemos que borre todas las fichas(llamándolo muchas veces)
        } catch (Exception npe) {
            System.out.println("Va a ser o ya ha sido elimnada de lista");
            return null;
        }
    }

    //Guarda la ficha f en el dominó. Si esa ficha ya existe en el dominó no se guarda.
    public void meterFicha(FichaDomino f) {
        //Mirar en caso de una ficha a la inversa y eso
        if (comprobarRepeticion(f.getSuperior(), f.getInferior())) {
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

            //He puesto la lista size aleatoria porque así jamás puede dar un out of bounds
            listaRepartida[j] = listaFichas.get(random.nextInt(listaFichas.size()));

            listaFichas.remove(listaRepartida[j]);

        }
        return listaRepartida;
    }

}
