package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.domain.exception.Exception;
import com.ceiba.biblioteca.domain.ports.repository.GetBooks;
import com.ceiba.biblioteca.domain.ports.repository.GetPortRegistration;
import com.ceiba.biblioteca.domain.ports.repository.GetTypes;
import com.ceiba.biblioteca.domain.ports.repository.GetDatosUser;
import com.ceiba.biblioteca.infrastructure.entity.Libros;
import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;
import com.ceiba.biblioteca.infrastructure.entity.Usuarios;
import com.ceiba.biblioteca.infrastructure.entity.Prestamos;

import java.util.Date;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;
import java.time.format.DateTimeFormatter;

public class RulesLibraryImpl  {
    public static final String SMS_ERROR_REGISTRO_NO_EXISTE = "El prestamo que estas buscando no existe";

    private GetTypes getTypes;

    private GetDatosUser getDatosUser;

    private GetPortRegistration getPortRegistration;

    private GetBooks getBooks;

    public RulesLibraryImpl(GetTypes getTypes, GetDatosUser getDatosUser,GetPortRegistration getPortRegistration, GetBooks getBooks) {
    super();
    this.getTypes =getTypes;
    this.getDatosUser =getDatosUser;
    this.getPortRegistration = getPortRegistration;
    this.getBooks = getBooks;
    }


    public Boolean validarSiExisteTipoUsuario(Long tipoUsuario) {
        TiposUsuarios consultaDeTipos = getTypes.findByTipoCons(tipoUsuario);
        return consultaDeTipos==null ;
          }

    public Boolean validarSiExisteUsuario(Long idUsuario) {
        Usuarios consultaDeUsuario = getDatosUser.findByusuaId(idUsuario);
        return consultaDeUsuario==null ;
    }
    public Boolean validarSiRegistroDelPrestamo(Long id, Long idUsuario) {
        Usuarios consultaDeUsuario = getDatosUser.findByusuaId(idUsuario);
        Prestamos consultaDePrestamo = getPortRegistration.findByprespresIsbnAndIdUsuarioLong(id, consultaDeUsuario.getUsuaCons());
        return consultaDePrestamo==null ;
    }

    public Date validacionDiasHabiles( Long tipoUsuario){
        Date input = new Date();
        LocalDate fechaLocal = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        TiposUsuarios consultaDeTipos = getTypes.findByTipoCons(tipoUsuario);
        Long DiasHabiles= consultaDeTipos.getTipoCantDiasHabiles();
        int contadorDiasAgregados = 0;
        while (contadorDiasAgregados < DiasHabiles) {
            fechaLocal = fechaLocal.plusDays(1);
            if (!(fechaLocal.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    fechaLocal.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++contadorDiasAgregados;
            }
        }
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(fechaLocal.atStartOfDay(defaultZoneId).toInstant());
        return date;
    }

    public Map<String, String> BusquedaDePrestamo(long id) {
        Map<String, String> map = new HashMap<>();
        Prestamos prestamo = getPortRegistration.findBypresCons(id);
        if (prestamo==null){
            throw new Exception(SMS_ERROR_REGISTRO_NO_EXISTE);
        }else {
        Libros libros = getBooks.findBylibCons(prestamo.getPresIsbn());
        Usuarios consultaDeUsuario = getDatosUser.findByusuaCons(prestamo.getPresIdUsuario());
        String sDate1 = String.valueOf(prestamo.getPresFechaEntrega());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(sDate1, formatter);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = date.format(formatters);
        map.put("id", String.valueOf(prestamo.getPresCons()));
        map.put("isbn", String.valueOf(libros.getLibCons()));
        map.put("identificacionUsuario", String.valueOf(consultaDeUsuario.getUsuaId()));
        map.put("TipoDeUsuario", String.valueOf(consultaDeUsuario.getUsuaTipo()));
        map.put("fechaMaximaDeDevolucion", text);
        }
        return map;
    }
}
