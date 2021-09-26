package com.ceiba.biblioteca.domain;

import com.ceiba.biblioteca.domain.ports.repository.GetPortRegistration;
import com.ceiba.biblioteca.infrastructure.entity.Prestamos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibrosPrestadosImplTest {

    @InjectMocks
    private LibrosPrestadosImpl librosPrestados;

    private GetPortRegistration getPortRegistration;

    @InjectMocks
    private Prestamos prestamos;

    private static final String FECHA_PRESTAMO_LIBRO1 = "22/09/2021 00:00";
    private static final String FECHA_ENTREGA_LIBRO1 = "23/09/2021 01:00";

    private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Before
    public void setup() {
        getPortRegistration = Mockito.mock(GetPortRegistration.class);
    }

    @Test
    public void listarLibrosPrestadosConParametrosDeManeraCorrectaPresIsbn() throws ParseException {
        // arrange
        Date fechaPrestamo = null;
        Date fechaEntrega = null;
        fechaPrestamo = formatoFechaHora.parse(FECHA_PRESTAMO_LIBRO1);
        fechaEntrega = formatoFechaHora.parse(FECHA_ENTREGA_LIBRO1);
        librosPrestados = new LibrosPrestadosImpl(getPortRegistration);
        Prestamos esperado = new Prestamos(1,1,1,fechaPrestamo, fechaEntrega);;
        Mockito.when(getPortRegistration.findByprespresIsbnAndIdUsuario("1","1")).thenReturn(esperado);
        // act
        Prestamos resultado = librosPrestados.listarLibrosPrestadosConParametros("1","1");
        // assertArrayEquals
        Assert.assertEquals(1,resultado.getPresIsbn());
    }

    @Test
    public void listarLibrosPrestadosConParametrosDeManeraIncorrectaPresIsbn() throws ParseException {
        // arrange
        Date fechaPrestamo = null;
        Date fechaEntrega = null;
        fechaPrestamo = formatoFechaHora.parse(FECHA_PRESTAMO_LIBRO1);
        fechaEntrega = formatoFechaHora.parse(FECHA_ENTREGA_LIBRO1);
        librosPrestados = new LibrosPrestadosImpl(getPortRegistration);
        Prestamos esperado = new Prestamos(1,1,1,fechaPrestamo, fechaEntrega);;
        Mockito.when(getPortRegistration.findByprespresIsbnAndIdUsuario("1","1")).thenReturn(esperado);
        // act
        Prestamos resultado = librosPrestados.listarLibrosPrestadosConParametros("1","1");
        // assertArrayEquals
        Assert.assertNotEquals(0,resultado.getPresIsbn());
    }

    @Test
    public void listarLibrosPrestadosConParametrosDeManeraCorrecta() throws ParseException {
        // arrange
        Date fechaPrestamo = null;
        Date fechaEntrega = null;
        fechaPrestamo = formatoFechaHora.parse(FECHA_PRESTAMO_LIBRO1);
        fechaEntrega = formatoFechaHora.parse(FECHA_ENTREGA_LIBRO1);
        librosPrestados = new LibrosPrestadosImpl(getPortRegistration);
        Prestamos esperado = new Prestamos(1,1,1,fechaPrestamo, fechaEntrega);;
        Mockito.when(getPortRegistration.findByprespresIsbnAndIdUsuario("1","1")).thenReturn(esperado);
        // act
        Prestamos resultado = librosPrestados.listarLibrosPrestadosConParametros("1","1");
        // assertArrayEquals
        Assert.assertEquals(esperado,resultado);
    }

    @Test
    public void listarLibrosPrestadosDeManeraCorrecta() throws ParseException {
        // arrange
        Date fechaPrestamo = null;
        Date fechaEntrega = null;
        fechaPrestamo = formatoFechaHora.parse(FECHA_PRESTAMO_LIBRO1);
        fechaEntrega = formatoFechaHora.parse(FECHA_ENTREGA_LIBRO1);
        librosPrestados = new LibrosPrestadosImpl(getPortRegistration);
        List<Prestamos> esperado = new ArrayList<Prestamos>();
        Prestamos esperado1 = new Prestamos(1,1,1,fechaPrestamo, fechaEntrega);;
        esperado.add(esperado1);
        Mockito.when(getPortRegistration.listaLibrosPrestados()).thenReturn(esperado);
        // act
        List<Prestamos> resultado = librosPrestados.listarLibrosPrestados();
        // assertArrayEquals
        Assert.assertEquals(esperado,resultado);
    }


}
