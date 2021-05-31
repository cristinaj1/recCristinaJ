/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominolista;

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
        Domino lista = new Domino();

        //Muestra la lista completa
        lista.getListaFichas().forEach(System.out::println);

        //Prueba el hecho de sacar fichas del array
        lista.sacarFicha();
        System.out.println("Después de sacar de la lista--------");
        lista.getListaFichas().forEach(System.out::println);

        //Hacemos la prueba de meter la ficha 
        lista.meterFicha(FichaDomino.generaFichaAleatoria());
        System.out.println("Después de meter la ficha nueva------------");
        lista.getListaFichas().forEach(System.out::println);

        //Prueba de mezclar fichas
        lista.mezclarFichas();
        System.out.println("Después de mezclar las fichas------------");
        lista.getListaFichas().forEach(System.out::println);

        //Prueba del reparto del cartas
        System.out.println("Lista de 7 ya repartida----------");
        FichaDomino[] listaReparto = lista.repartir(7);
        for (FichaDomino fichaDomino : listaReparto) {
            System.out.println(fichaDomino);

        }

        //Actualizamos la lista actualizadas
        System.out.println("Lista con las 7 fichas menos----------");
        lista.getListaFichas().forEach(System.out::println);
    }

}
