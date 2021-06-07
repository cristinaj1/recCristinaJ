/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import static cursos.LecturaYEscrituraFicheros.escribirJson;
import static cursos.LecturaYEscrituraFicheros.insertCurso;
import static cursos.LecturaYEscrituraFicheros.leerCursos;
import static cursos.LecturaYEscrituraFicheros.leerJSON;
import static cursos.LecturaYEscrituraFicheros.leerTxt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author cristina
 */
public class Prueba {

    public static void main(String[] args) throws IOException {
        ArrayList<Cursos> cursos = leerCursos("RegActForCep.csv");

        System.out.println("Lista ya ordenada directamente");
        cursos.forEach(System.out::println);
        for (Cursos curso : cursos) {
            if (curso.getFechFin().isBefore(LocalDate.of(2020, 5, 1))) {
                insertCurso(curso);
            }
        }
        System.out.println("Se ha hecho el fichero txt");
        System.out.println("Leer txt--------------" + leerTxt().toString());
        System.out.println("----------------------------------------------------------------");
        escribirJson((ArrayList<Cursos>) leerTxt());
        System.out.println("Se ha escrito el JSON");

        System.out.println("Leyendo el JSON--------------------------------------");
        leerJSON(cursos);

    }
}
