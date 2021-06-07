/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import java.time.LocalDate;

/**
 *
 * @author cristina
 */
public class Cursos {
    private String centro;
    private String codigo;
    private String titulo;
    private String modalidad;
    private String estado;
    private LocalDate fechaIni;
    private LocalDate fechFin;
    private String dirigidoA;

    public Cursos(String centro, String codigo, String titulo, String modalidad, String estado, LocalDate fechaIni, LocalDate fechFin, String dirigidoA) {
        this.centro = centro;
        this.codigo = codigo;
        this.titulo = titulo;
        this.modalidad = modalidad;
        this.estado = estado;
        this.fechaIni = fechaIni;
        this.fechFin = fechFin;
        this.dirigidoA = dirigidoA;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechFin() {
        return fechFin;
    }

    public void setFechFin(LocalDate fechFin) {
        this.fechFin = fechFin;
    }

    public String getDirigidoA() {
        return dirigidoA;
    }

    public void setDirigidoA(String dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    

    
    
    
}
