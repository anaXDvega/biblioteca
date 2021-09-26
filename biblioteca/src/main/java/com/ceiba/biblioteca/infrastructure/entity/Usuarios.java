package com.ceiba.biblioteca.infrastructure.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Bi_Usuarios")
public class Usuarios {

    @Id
    @Column(name = "usuacons")
    private Long usuaCons;


    @Column(name = "usuaid")
    private Long usuaId;


    @Column(name = "usuanomb")
    private String usuaNomb;


    @Column(name = "usuatipo")
    private Long usuaTipo;


    @Column(name = "usuaestado")
    private Long usuaEstado;

    public Long getUsuaCons() {
        return usuaCons;
    }

    public void setUsuaCons(Long usuaCons) {
        this.usuaCons = usuaCons;
    }

    public Long getUsuaId() {
        return usuaId;
    }

    public void setUsuaId(Long usuaId) {
        this.usuaId = usuaId;
    }

    public String getUsuaNomb() {
        return usuaNomb;
    }

    public void setUsuaNomb(String usuaNomb) {
        this.usuaNomb = usuaNomb;
    }

    public Long getUsuaTipo() {
        return usuaTipo;
    }

    public void setUsuaTipo(Long usuaTipo) {
        this.usuaTipo = usuaTipo;
    }

    public Long getUsuaEstado() {
        return usuaEstado;
    }

    public void setUsuaEstado(Long usuaEstado) {
        this.usuaEstado = usuaEstado;
    }

    public Usuarios(Long usuaCons, Long usuaId, String usuaNomb, Long usuaTipo, Long usuaEstado) {
      super();
        this.usuaCons = usuaCons;
        this.usuaId = usuaId;
        this.usuaNomb = usuaNomb;
        this.usuaTipo = usuaTipo;
        this.usuaEstado = usuaEstado;
    }

    public Usuarios() {
    }
}
