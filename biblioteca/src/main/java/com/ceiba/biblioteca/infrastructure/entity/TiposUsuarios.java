package com.ceiba.biblioteca.infrastructure.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Bi_tipos_usuarios")
public class TiposUsuarios {

    @Id
    @Column(name = "tipocons")
    private Long tipoCons;

    @Column(name = "tipodesc")
    private String tipoDesc;
    @Column(name = "tipocantdiashabiles")
    private Long tipoCantDiasHabiles;


    public Long getTipoCons() {
        return tipoCons;
    }

    public void setTipoCons(Long tipoCons) {
        this.tipoCons = tipoCons;
    }

    public String getTipoDesc() {
        return tipoDesc;
    }

    public void setTipoDesc(String tipoDesc) {
        this.tipoDesc = tipoDesc;
    }

    public Long getTipoCantDiasHabiles() {
        return tipoCantDiasHabiles;
    }

    public void setTipoCantDiasHabiles(Long tipoCantDiasHabiles) {
        this.tipoCantDiasHabiles = tipoCantDiasHabiles;
    }

    public TiposUsuarios(Long tipoCons, String tipoDesc, Long tipoCantDiasHabiles) {
        super();
        this.tipoCons = tipoCons;
        this.tipoDesc = tipoDesc;
        this.tipoCantDiasHabiles =tipoCantDiasHabiles;
    }



    public TiposUsuarios() {
     }
}
