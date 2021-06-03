/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Objects;

/**
 *
 * @author cristina
 */
public class Persona {

    //atributos básicos de una persona
    private String nombre;
    private String apellidos;
    private String dni;
    //Como son profesores les puse asignatura, pero en otro caso se pondría null o ""
    private String asignatura;

    //constructores
    public Persona(String nombre, String apellidos, String dni, String asigantura) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.asignatura = asigantura;
    }

    public Persona() {
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAsigantura() {
        return asignatura;
    }

    public void setAsigantura(String asigantura) {
        this.asignatura = asigantura;
    }

    //toString
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", asigantura=" + asignatura + '}';
    }

    //equals y hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.apellidos);
        hash = 67 * hash + Objects.hashCode(this.dni);
        hash = 67 * hash + Objects.hashCode(this.asignatura);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.asignatura, other.asignatura)) {
            return false;
        }
        return true;
    }

}
