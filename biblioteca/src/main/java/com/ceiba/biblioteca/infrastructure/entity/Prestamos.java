package com.ceiba.biblioteca.infrastructure.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Bi_Prestamos")
public class Prestamos {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "prescons")
    private long presCons;

    @Column(name = "presisbn")
    private long presIsbn;

    @Column(name = "presidusuario")
    private long presIdUsuario;

    @Column(name = "presfechaprestamo")
    private Date presFechaPrestamo;

    @Column(name = "presfechaentrega")
    private Date presFechaEntrega;

    public long getPresCons() {
        return presCons;
    }

    public void setPresCons(long presCons) {
        this.presCons = presCons;
    }

    public long getPresIsbn() {
        return presIsbn;
    }

    public void setPresIsbn(long presIsbn) {
        this.presIsbn = presIsbn;
    }

    public long getPresIdUsuario() {
        return presIdUsuario;
    }

    public void setPresIdUsuario(long presIdUsuario) {
        this.presIdUsuario = presIdUsuario;
    }

    public Date getPresFechaPrestamo() {
        return presFechaPrestamo;
    }

    public void setPresFechaPrestamo(Date presFechaPrestamo) {
        this.presFechaPrestamo = presFechaPrestamo;
    }

    public Date getPresFechaEntrega() {
        return presFechaEntrega;
    }

    public void setPresFechaEntrega(Date presFechaEntrega) {
        this.presFechaEntrega = presFechaEntrega;
    }

    public Prestamos(long presCons, long presIsbn, long presIdUsuario, Date presFechaPrestamo, Date presFechaEntrega) {
        super();
        this.presCons = presCons;
        this.presIsbn = presIsbn;
        this.presIdUsuario = presIdUsuario;
        this.presFechaPrestamo = presFechaPrestamo;
        this.presFechaEntrega = presFechaEntrega;
    }
    public Prestamos( long presIsbn, long presIdUsuario, Date presFechaPrestamo, Date presFechaEntrega) {
        super();
        this.presIsbn = presIsbn;
        this.presIdUsuario = presIdUsuario;
        this.presFechaPrestamo = presFechaPrestamo;
        this.presFechaEntrega = presFechaEntrega;
    }
    public Prestamos( long presIsbn, long presIdUsuario) {
        this.presIsbn = presIsbn;
        this.presIdUsuario = presIdUsuario;
    }

    public Prestamos(){
        }
}
