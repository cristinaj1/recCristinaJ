/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominolista;

import java.util.Random;

/**
 *
 * @author cristina
 */
public class FichaDomino {

    private int ladoA, ladoB;

    //Constructor sin parametrizado
    public FichaDomino() {
        this.ladoA = 0;
        this.ladoB = 0;
    }

    //Constructor parametrizado
    public FichaDomino(int a, int b) {
        this.ladoA = valorValido(a);
        this.ladoB = valorValido(b);
    }

    //Comprueba si a y b son validos y sustituye si no lo son
    private int valorValido(int a) {
        if (a < 0 || a > 6) {
            if (a % 2 == 0) {
                a = 6;
            } else {
                a = 5;
            }
        }
        return a;
    }

    //Setters y getters
    public int getLadoA() {
        return ladoA;
    }

    public void setLadoA(int ladoA) {
        this.ladoA = valorValido(ladoA);
    }

    public int getLadoB() {
        return ladoB;
    }

    public void setLadoB(int ladoB) {
        this.ladoB = valorValido(ladoB);
    }

    //toString
    @Override
    public String toString() {
        String salida = "[" + ladoA + "|" + ladoB + "]";
        return salida.replaceAll("0", " ");
    }

    //Suma las partes de la ficha
    public byte getValorTotal() {
        return (byte) (ladoA + ladoB);
    }

    //Genera fichas de forma aleatorias
    public static FichaDomino aleatoria() {
        Random random = new Random();
        return new FichaDomino(random.nextInt(6) + 1, random.nextInt(6) + 1);
    }
}
