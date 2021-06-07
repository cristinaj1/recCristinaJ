/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cristina
 */
public class LecturaYEscrituraFicheros {

    // Método que se encarga de abrir el fichero de ruta "idFichero"
    // y carga los objetos Persona en una lista, que devuelve
    public static ArrayList<Cursos> leerCursos(String idFichero) throws IOException {

        String[] tokens;
        ArrayList<Cursos> cursos = new ArrayList<>();
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

    //Hace que se inserte elemento por elemento en el txt
    public static void insertCurso(Cursos curso) {

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter("cursosAcabados.txt", true))) {

            flujo.write(curso.stringTxt());
            flujo.newLine();
            flujo.flush();

        } catch (IOException e) {
            System.out.println("No se ha podido introducir");
        }

    }

    //Lee el archivo txt
    public static List<Cursos> leerTxt() {

        List<Cursos> lista = new ArrayList<>();
        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new FileReader("cursosAcabados.txt"))) {

            // Mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine(); //Se lee la línea
                tokens = linea.split("\t ");

                Cursos objetoCursos = new Cursos();

                //Comenzamos a introducir los datos en los atributos del objeto
                objetoCursos.setTitulo(tokens[0]);
                objetoCursos.setFechFin(LocalDate.parse(tokens[1]));
                if (objetoCursos.getCentro() == null
                        || objetoCursos.getCodigo() == null
                        || objetoCursos.getDirigidoA() == null
                        || objetoCursos.getEstado() == null
                        || objetoCursos.getFechaIni() == null
                        || objetoCursos.getModalidad() == null) {
                    objetoCursos.setCentro("");
                    objetoCursos.setCodigo("");
                    objetoCursos.setDirigidoA("");
                    objetoCursos.setEstado("");
                    objetoCursos.setFechaIni(null);
                    objetoCursos.setModalidad("");

                }

                lista.add(objetoCursos);

            }

            return lista;

        } catch (FileNotFoundException e) {
            return lista;
        }
    }

    //Escribe el fichero JSON a partir de un arrayList
    public static void escribirJson(ArrayList<Cursos> listaCursos) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON 
        mapeador.writeValue(new File("CursosAcabados.json"), leerTxt());

    }

    //Lee el JSON creado anteriormente
    public static void leerJSON(ArrayList<Cursos> lista) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();
        mapeador.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        lista = mapeador.readValue(new File("CursosAcabados.json"),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Cursos.class));
        for (Cursos cursosVO : lista) {
            System.out.println(cursosVO);
        }

    }

}
