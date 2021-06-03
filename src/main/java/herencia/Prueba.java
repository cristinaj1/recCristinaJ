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
        ListaProfesores listaProfesores2 = new ListaProfesores();
        //5 profesores interinos
        //Profesor 1
        Profesor profesor1 = new ProfesorInterino(LocalDate.of(2021, Month.MARCH, 1), LocalDate.now(), LocalDate.of(2021, Month.MARCH, 5), "1", "Agustina", "Fernández", "58947206H", "Biología");
        listaProfesores.add(profesor1);

        //profesor 2
        Profesor profesor2 = new ProfesorInterino(LocalDate.of(2021, Month.MARCH, 5), LocalDate.now(), LocalDate.of(2021, Month.MARCH, 7), "2", "Antonio", "Melgar", "98745021F", "Tecnología");
        listaProfesores.add(profesor2);

        //Profesor3
        Profesor profesor3 = new ProfesorInterino(LocalDate.of(2019, Month.AUGUST, 1), LocalDate.now(), LocalDate.of(2020, Month.JULY, 5), "3", "Benito", "Vela", "09117367Q", "Economía");
        listaProfesores.add(profesor3);

        //Profesor4
        Profesor profesor4 = new ProfesorInterino(LocalDate.of(2021, Month.OCTOBER, 1), LocalDate.now(), LocalDate.of(2020, Month.MAY, 5), "4", "Carolina", "Oviedo", "98745023K", "Ciudadania");
        listaProfesores.add(profesor4);

        //Profesor5
        Profesor profesor5 = new ProfesorInterino(LocalDate.of(2021, Month.SEPTEMBER, 1), LocalDate.now(), LocalDate.of(2020, Month.FEBRUARY, 5), "5", "Ingrid", "Caparros", "09117361S", "Matemáticas");
        listaProfesores.add(profesor5);

        //5 profesores titulares
        //Profesor6
        Profesor profesor6 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 1), "7", "Celeste", "Ortíz", "98595113R", "Inglés");
        listaProfesores.add(profesor6);

        //profesor7
        Profesor profesor7 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 8), "8", "Moises", "Carmona", "85073389T", "Lengua");
        listaProfesores.add(profesor7);

        //Profesor8
        Profesor profesor8 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 15), "9", "Juan", "Martos", "63446566P", "Programación");
        listaProfesores.add(profesor8);

        //Profesor9
        Profesor profesor9 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 11), "10", "Andrés", "Galvez", "94039754E", "Entornos");
        listaProfesores.add(profesor9);

        //Profesor10
        Profesor profesor10 = new ProfesorTitular(LocalDate.of(2021, Month.MARCH, 9), "11", "Leonor", "Galan", "02147539Y", "Música");
        listaProfesores.add(profesor10);
        
        System.out.println("SIN ORDENAR----------------");
        listaProfesores2.setListaProfesores(listaProfesores);
        
        Collections.sort(listaProfesores, (x, y) -> x.getDni().compareToIgnoreCase(y.getDni()));
        System.out.println("ORDENADO--------------");
        listaProfesores2.setListaProfesores(listaProfesores);
        listaProfesores2.imprimirLista();
        

    }

}
