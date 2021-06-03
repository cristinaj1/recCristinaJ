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

    //único atributo es idProfesor
    private String idProfesor;

    //Constructores
    public Profesor(String idProfesor, String nombre, String apellidos, String dni, String asigantura) {
        super(nombre, apellidos, dni, asigantura);
        this.idProfesor = idProfesor;
    }

    public Profesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    //getters y setters
    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    //ToString
    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + '}' + Profesor.super.toString();
    }

    //método abstracto llamado importeNomina(double sueldoBase) que devuelve un double
    public abstract double importeNomina(double sueldoBase);
}
