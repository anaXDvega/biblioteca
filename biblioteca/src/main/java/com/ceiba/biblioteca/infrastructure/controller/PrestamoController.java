package com.ceiba.biblioteca.infrastructure.controller;


import com.ceiba.biblioteca.aplication.query.QueryAllPrestamos;
import com.ceiba.biblioteca.infrastructure.entity.Prestamos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class PrestamoController {
    @Autowired
    private QueryAllPrestamos allPrestamos;

    /**
    *Busqueda de los datos prestamos con los parametros id del libro y id del usuario
    **/
    @PostMapping("ListarPrestamo")
    public Prestamos listarConParametros(@RequestBody Map<String, Object> json) {
          return allPrestamos.consultarConParametros(obtenerValor(json, "isbn"),
                obtenerValor(json, "identificacionUsuario"));
    }
    /**
     *Busqueda de los datos solicitados api 1
     **/
    @PostMapping("Prestamo")
    public Map<String, String>  RealizarPrestamo(@RequestBody Map<String, Object> json) {
        return allPrestamos.consultarPrestamosConParametros(obtenerValor(json, "isbn"),
                obtenerValor(json, "identificacionUsuario"), obtenerValor(json, "tipoUsuario"));
    }
    @GetMapping("Lista")
    public List<Prestamos> FindAll() {
        return allPrestamos.execute();
    }

    @GetMapping(value = "Prestamo/{id}", produces = {"application/JSON; charset=UTF-8"})
    @ResponseBody
    public Map<String, String> busquedaPrestamo(@PathVariable("id") long id) {
        return allPrestamos.consultarPrestamo(id);
    }

    private String obtenerValor(Map<String, Object> json, String llave) {
        return json.get(llave).toString();
    }

}

