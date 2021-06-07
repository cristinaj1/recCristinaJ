/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import static cursos.LecturaYEscrituraFicheros.leerCursos;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cristina
 */
public class Prueba {

    public static void main(String[] args) throws IOException {
        ArrayList <Cursos> cursos = leerCursos("RegActForCep.csv");
        cursos.forEach(System.out::println);
    }
}
