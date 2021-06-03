/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cristina
 */
public class ListaProfesores {

    //Un atributo que sea una lista de objetos Profesor
    private ArrayList<Profesor> listaProfesores = new ArrayList<>();

    //calcular el importe total de todas las nóminas de los profesores de la lista. 
    public double importeTotal() {
        Scanner teclado = new Scanner(System.in);
        double resultado = 0;
        double totalInterino = 0, totalTitular = 0;
        //Como no sabemos lo que cobra de base un profesor pedimos al usuario que lo meta por pantalla

        for (Profesor prof : listaProfesores) {

            System.out.println("Introduzca el sueldo base del profesor: " + prof.getNombre());
            double sueldoBase = teclado.nextDouble();
            if (prof instanceof ProfesorInterino) {
                double totalInte = prof.importeNomina(sueldoBase);
                totalInterino += totalInte;
            } else {
                double totalTit = prof.importeNomina(sueldoBase);
                totalInterino += totalTit;
            }
            resultado = totalInterino + totalTitular;

        }
        return resultado;
    }

    //Un método que dado un profesorTitular calcule el número de días que lleva en ese puesto de trabajo.
    public int cantidadDiasTrabajando(ProfesorTitular pf) {
        long resultado = 0;
        LocalDate hoy = LocalDate.now();

        resultado = ChronoUnit.DAYS.between(pf.getFechaTomaPosesion(), hoy);

        //hago un casting para que aparezca en número entero y para que se más fácil para trabajar con ello
        return (int) resultado;

    }

    //Imprimir la lista por consola.
    public void imprimirLista() {
        this.getListaProfesores().forEach(System.out::println);
    }

    public ArrayList<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }
}
