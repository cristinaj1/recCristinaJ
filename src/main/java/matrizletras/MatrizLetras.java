/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizletras;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Cris
 */
public class MatrizLetras {

    private char matrizLetras[][] = new char[10][10];
    private Random random = new Random();

    //Rellena la matriz con caracteres aleatorios (entre A y Z)
    public void llenarAleatoriamente() {
        for (int i = 0; i < matrizLetras.length; i++) {
            for (int j = 0; j < matrizLetras[i].length; j++) {
                matrizLetras[i][j] = (char) ((char) random.nextInt(90 - 65 + 1) + 65);
            }

        }
    }

    //imprime la matriz por consola. 
    public void imprimir() {
        //Se podría hacer con un for dentro de otro for simplemente, pero como 
        //queremos darle formato en consola usamos sout \t para tabular y 
        //mejorarlo visualmente
        for (int i = 0; i < matrizLetras.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrizLetras[i].length; j++) {
                System.out.print(matrizLetras[i][j]);
                if (j != matrizLetras[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }

    }

    //Ordena cada fila de la matriz alfabéticamente.
    public void ordenar() {

        for (int i = 0; i < matrizLetras.length; i++) {
            //Forma con for
//            for (int j = 0; j < matrizLetras.length - 1; j++) {
//                if (matrizLetras[j].equals(matrizLetras[j + 1])) {
//                    char[] tmp = matrizLetras[j + 1];
//                    matrizLetras[j + 1] = matrizLetras[j];
//                    matrizLetras[j] = tmp;
//                }
//                
//
//            }

            //Con arrays.sort primero lo separamos array por array y los ordenamos a su vez
            Arrays.sort(matrizLetras[i]);
        }

    }

    //Devuelve el número de veces que aparece ‘x’ dentro de la matriz.
    public int contarCaracter(char x) {
        int contador = 0;
        //Recorremos el array
        for (int i = 0; i < matrizLetras.length; i++) {
            for (int j = 0; j < matrizLetras[i].length; j++) {
                //Si la posición es igual al char
                if (matrizLetras[i][j] == x) {
                    //Suma el contador 1
                    contador++;
                }
            }

        }
        return contador;
    }

}
