package com.ceiba.biblioteca.infrastructure.mapper.TypesUSer;

import com.ceiba.biblioteca.infrastructure.entity.Prestamos;
import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MapperTypesUserRegistry {
    public static TiposUsuarios mapToEntity(TiposUsuarios tiposUsuarios) {
        return new TiposUsuarios(tiposUsuarios.getTipoCons(), tiposUsuarios.getTipoDesc(), tiposUsuarios.getTipoCantDiasHabiles());
    }
    public TiposUsuarios mapToDomain(TiposUsuarios tiposUsuarios) {
        return new TiposUsuarios(tiposUsuarios.getTipoCons(), tiposUsuarios.getTipoDesc(), tiposUsuarios.getTipoCantDiasHabiles());
    }
    public List<TiposUsuarios> mapToDomain(List<TiposUsuarios> all) {
        List<TiposUsuarios> listaRegistro = new ArrayList<>();
        all.forEach(tiposUsuarios -> {
            TiposUsuarios TiposUsuarios = new TiposUsuarios(tiposUsuarios.getTipoCons(), tiposUsuarios.getTipoDesc(), tiposUsuarios.getTipoCantDiasHabiles());
            listaRegistro.add(TiposUsuarios);

        });
     return listaRegistro;
    }
}
