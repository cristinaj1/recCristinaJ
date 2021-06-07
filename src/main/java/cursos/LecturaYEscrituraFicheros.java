/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cristina
 */
public class LecturaYEscrituraFicheros {

    // Método que se encarga de abrir el fichero de ruta "idFichero"
    // y carga los objetos Persona en una lista, que devuelve
    public static ArrayList<Cursos> leerCursos(String idFichero) throws IOException {

        ArrayList<Cursos> cursos = new ArrayList<>();
        FileInputStream fis;
        Cursos tmp;

        try {
            fis = new FileInputStream(idFichero);

            // A partir del fichero anterior se crea el flujo para leer objetos
            // Estructura try-with-resources
            try ( ObjectInputStream flujo = new ObjectInputStream(fis)) {
                // Devuelve el número estimado de bytes que hay por leer
                // o cero si se ha alcanzado el final del fichero
                while (fis.available() > 0) {
                    // Se hace un casting explícito del objeto devuelto
                    // por readObject()
                    tmp = (Cursos) flujo.readObject();
                    // Añade el objeto a la lista
                    cursos.add(tmp);
                }

            } catch (ClassNotFoundException | IOException e) { // Multicatch
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("EL fichero a leer no existe.");
        }

        return cursos;

    }
}
