/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.time.LocalDate;

/**
 *
 * @author cristina
 */
public class ProfesorTitular extends Profesor implements Comparable<ProfesorTitular> {

    private LocalDate fechaTomaPosesion;

    public ProfesorTitular(LocalDate fechaTomaPosesion, String idProfesor, String nombre, String apellidos, String dni, String asigantura) {
        super(idProfesor, nombre, apellidos, dni, asigantura);
        this.fechaTomaPosesion = fechaTomaPosesion;
    }

    public LocalDate getFechaTomaPosesion() {
        return fechaTomaPosesion;
    }

    public void setFechaTomaPosesion(LocalDate fechaTomaPosesion) {
        this.fechaTomaPosesion = fechaTomaPosesion;
    }

    @Override
    public String toString() {
        return "ProfesorTitular{" + "fechaTomaPosesion=" + fechaTomaPosesion + '}' + " "+ProfesorTitular.super.toString();
    }

    @Override
    public double importeNomina(double sueldoBase) {
        double resultado = (sueldoBase * 0.3) + sueldoBase;
        return resultado;
    }

    @Override
    public int compareTo(ProfesorTitular t) {
        // caso a = b
        int resultadoComparacion = 0;
        // Caso a > b
        if (this.fechaTomaPosesion.isAfter(t.fechaTomaPosesion)) {
            //Si es después sale 1
            resultadoComparacion = 1;
        } else {
            // Caso a < b
            //Si es antes sale '1
            resultadoComparacion = -1;
        }

        return resultadoComparacion;

    }

}
