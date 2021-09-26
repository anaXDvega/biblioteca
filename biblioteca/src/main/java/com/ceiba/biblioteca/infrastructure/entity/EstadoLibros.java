package com.ceiba.biblioteca.infrastructure.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Bi_EstadoLibros")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
class EstadoLibros {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long estaId;

    @Getter
    @Setter
    @Column(name = "estaDescripcion")
    private String estaDescripcion;


}
