package com.ceiba.biblioteca.infrastructure.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Bi_libros")
public class Libros {
    @Id
    @Column(name = "libcons")
    private Long libCons;


    @Column(name = "libdesc")
    private String libDesc;

    @Column(name = "libcant")
    private String libCant;

    @Column(name = "libesta")
    private Long libEsta;

    public Long getLibCons() {
        return libCons;
    }

    public void setLibCons(Long libCons) {
        this.libCons = libCons;
    }

    public String getLibDesc() {
        return libDesc;
    }

    public void setLibDesc(String libDesc) {
        this.libDesc = libDesc;
    }

    public String getLibCant() {
        return libCant;
    }

    public void setLibCant(String libCant) {
        this.libCant = libCant;
    }

    public Long getLibEsta() {
        return libEsta;
    }

    public void setLibEsta(Long libEsta) {
        this.libEsta = libEsta;
    }

    public Libros(Long libCons, String libDesc, String libCant, Long libEsta) {
    super();
        this.libCons = libCons;
        this.libDesc = libDesc;
        this.libCant = libCant;
        this.libEsta = libEsta;
    }
    public Libros(){

    }
}
