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
public class ProfesorInterino extends ProfesorTitular {

    private LocalDate fechaIni;
    private LocalDate fechaFin;

    public ProfesorInterino(LocalDate fechaIni, LocalDate fechaFin, LocalDate fechaTomaPosesion, String idProfesor, String nombre, String apellidos, String dni, String asigantura) {
        super(fechaTomaPosesion, idProfesor, nombre, apellidos, dni, asigantura);
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    @Override
    public String toString() {
        return "ProfesorInterino{" + "fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + '}' + " Nombre: " + ProfesorInterino.super.getNombre() + " IdProfesor: " + ProfesorInterino.super.getIdProfesor() + " DNI: " + ProfesorInterino.super.getDni();
    }

    @Override
    public double importeNomina(double sueldoBase) {
        double resultado = (sueldoBase * 0.15) + sueldoBase;
        return resultado;
    }

    //ESTO TENGO QUE MIRARLO
    public int compareTo(ProfesorInterino t) {
        // caso a = b
        int resultadoComparacion = 0;
        // Caso a > b
        if (this.fechaIni.isAfter(t.fechaIni)) {
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
