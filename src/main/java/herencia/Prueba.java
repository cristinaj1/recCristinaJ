/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author cristina
 */
public class Prueba {

    public static void main(String[] args) {
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        ArrayList<ProfesorTitular> listaProfesoresTit = new ArrayList<>();
        ListaProfesores listaProfesores2 = new ListaProfesores();
        ListaProfesores listaProfesoresTitu = new ListaProfesores();
        // guarda 5 objetos de ambos de tipos de profesores con datos de tu elección
        //5 profesores interinos
        //Profesor 1
        ProfesorInterino profesor1 = new ProfesorInterino(LocalDate.now(), LocalDate.of(2021, Month.MARCH, 5), "1", "Agustina", "Fernández", "58947206H", "Biología");
        listaProfesores.add(profesor1);

        //profesor 2
        ProfesorInterino profesor2 = new ProfesorInterino(LocalDate.now(), LocalDate.of(2021, Month.MARCH, 7), "2", "Antonio", "Melgar", "98745021F", "Tecnología");
        listaProfesores.add(profesor2);

        //Profesor3
        ProfesorInterino profesor3 = new ProfesorInterino(LocalDate.now(), LocalDate.of(2020, Month.JULY, 5), "3", "Benito", "Vela", "09117367Q", "Economía");
        listaProfesores.add(profesor3);

        //Profesor4
        ProfesorInterino profesor4 = new ProfesorInterino(LocalDate.now(), LocalDate.of(2020, Month.MAY, 5), "4", "Carolina", "Oviedo", "98745023K", "Ciudadania");
        listaProfesores.add(profesor4);

        //Profesor5
        ProfesorInterino profesor5 = new ProfesorInterino(LocalDate.now(), LocalDate.of(2020, Month.FEBRUARY, 5), "5", "Ingrid", "Caparros", "09117361S", "Matemáticas");
        listaProfesores.add(profesor5);

        //5 profesores titulares
        //Profesor6
        ProfesorTitular profesor6 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 1), "7", "Celeste", "Ortíz", "98595113R", "Inglés");
        listaProfesores.add(profesor6);

        //profesor7
        ProfesorTitular profesor7 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 8), "8", "Moises", "Carmona", "85073389T", "Lengua");
        listaProfesores.add(profesor7);

        //Profesor8
        ProfesorTitular profesor8 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 15), "9", "Juan", "Martos", "63446566P", "Programación");
        listaProfesores.add(profesor8);

        //Profesor9
        ProfesorTitular profesor9 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 11), "10", "Andrés", "Galvez", "94039754E", "Entornos");
        listaProfesores.add(profesor9);

        //Profesor10
        ProfesorTitular profesor10 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 9), "11", "Leonor", "Galan", "02147539Y", "Música");
        listaProfesores.add(profesor10);

        //Imprime la lista de los 10 objetos.
        System.out.println("SIN ORDENAR----------------");
        for (Profesor listaProfesore : listaProfesores) {
            System.out.println(listaProfesore);
        }

        //Ordena los profesores por DNI usando una expresión lambda y el método Sort().
        Collections.sort(listaProfesores, (x, y) -> x.getDni().compareToIgnoreCase(y.getDni()));
        System.out.println("ORDENADO--------------");

        //Muestra la lista ordenada.
        listaProfesores2.setListaProfesores(listaProfesores);
        listaProfesores2.imprimirLista();

        //Calcula el importe total de las nóminas y muestra por consola esta información.
        System.out.println("CÁLCULO DEL IMPORTE TOTAL---------------");
        System.out.println("El importe total es de: "
                + listaProfesores2.importeTotal()
                + "\n--------------------------------------------------------------");

        //Recorre la lista de profesores
        for (int i = 0; i < listaProfesores.size(); i++) {
            if (listaProfesores.get(i) instanceof ProfesorTitular) {

                //Guarda en una lista de ProfesorTitular los profesores titulares
                listaProfesoresTit.add((ProfesorTitular) listaProfesores.get(i));
                listaProfesoresTitu.setListaProfesores(listaProfesoresTitu.getListaProfesores());

                //llama al método que calcule el número de días en el puesto de 
                //trabajo para aquellos profesores que sean titulares, mostrando
                //esta información por consola
                System.out.println("Cantidad de días trabajados del profesor "
                        + listaProfesores.get(i).getNombre()
                        + "  hasta hoy es de------------ "
                        + listaProfesoresTitu.cantidadDiasTrabajando((ProfesorTitular) listaProfesores.get(i))
                        + " días");
            }
        }

        //ordénalos según su fecha de toma de posesión.
        Collections.sort(listaProfesoresTit);
        System.out.println("LISTA YA ORDENADA POR FECHA DE TOMA DE POSESIÓN "
                + "-----------------------------");

        //Imprime el resultado por consola
        for (ProfesorTitular profesortit : listaProfesoresTit) {
            System.out.println(profesortit);

        }

    }

}
