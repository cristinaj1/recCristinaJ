/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizletras;

/**
 *
 * @author Cris
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MatrizLetras matriz = new MatrizLetras();
        matriz.llenarAleatoriamente();
        matriz.imprimir();
        matriz.ordenar();
        System.out.println("Ordenado-----------------");
        matriz.imprimir();
        System.out.println("----------------------------");
        System.out.println("Hay " + matriz.contarCaracter('X') + " X en la matriz");
    }

}
