/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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
        String[] tokens;

        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {

            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();

            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {

                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Cursos objetoCursos = new Cursos();

                //Comenzamos a introducir los datos en los atributos del objeto
                objetoCursos.setCentro(tokens[0]);
                objetoCursos.setCodigo(tokens[1]);
                objetoCursos.setTitulo(tokens[2]);
                objetoCursos.setModalidad(tokens[3]);
                objetoCursos.setEstado(tokens[4]);
                objetoCursos.setFechaIni(LocalDate.parse(tokens[5], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                objetoCursos.setFechFin(LocalDate.parse(tokens[6], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                objetoCursos.setDirigidoA(tokens[7]);
                cursos.add(objetoCursos);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        cursos.stream()
                .sorted((c1, c2) -> c1.getFechaIni().compareTo(c2.getFechaIni()))
                .sorted((d1, d2) -> d1.getTitulo().compareTo(d2.getTitulo()));
        return cursos;
    }

    private static int insertCurso(ArrayList<Cursos> lista) {
        int contador = 0;

        if (!lista.isEmpty()) {
            try ( BufferedWriter flujo = new BufferedWriter(new FileWriter("CursosAcabados.txt", true))) {
                for (Cursos curso : lista) {

                    flujo.write(curso.getTitulo() + "\t" + curso.getFechFin());
                    flujo.newLine();
                    contador++;

                }

                flujo.flush();
            } catch (IOException e) {
                return contador;
            }
        }
        return contador;
    }

    public static ArrayList<Cursos> listaCursosAcabados(ArrayList<Cursos> listaCursos) {
        ArrayList<Cursos> listaAcabada = new ArrayList();
        Cursos prueba = new Cursos();

        for (Cursos objetoCurso : listaCursos) {
            if (objetoCurso.getFechFin().isBefore(LocalDate.of(2020, Month.APRIL, 1))) {

                prueba.setTitulo(objetoCurso.getTitulo());
                prueba.setFechFin(objetoCurso.getFechFin());
                listaAcabada.add(prueba);
            }
        }
        return listaAcabada;

    }

    public static void escribirTxt(ArrayList<Cursos> listaCursos) {
        ArrayList<Cursos> listaAcabada = new ArrayList();
        Cursos prueba = new Cursos();

        for (Cursos objetoCurso : listaCursos) {
            if (objetoCurso.getFechFin().isBefore(LocalDate.of(2020, Month.APRIL, 1))) {

                prueba.setTitulo(objetoCurso.getTitulo());
                prueba.setFechFin(objetoCurso.getFechFin());
                listaAcabada.add(prueba);
            }
        }
        insertCurso(listaAcabada);

    }

    //LEER TXT Y METERLO AQUÍ Y YA MATO 2 PAJAROS DE UN TIRO
    public static void escribirJson(ArrayList<Cursos> listaCursos) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON 
        mapeador.writeValue(new File("CursosAcabados.json"), "cursosAcabados.txt");

    }

}
