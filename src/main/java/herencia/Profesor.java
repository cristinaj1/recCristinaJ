/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author cristina
 */
public abstract class Profesor extends Persona {

    private String idProfesor;

    public Profesor(String idProfesor, String nombre, String apellidos, String dni, String asigantura) {
        super(nombre, apellidos, dni, asigantura);
        this.idProfesor = idProfesor;
    }

    public Profesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + '}' + Profesor.super.toString();
    }

    public abstract double importeNomina(double sueldoBase);
}
