package com.ceiba.biblioteca.infrastructure.configuration;

import com.ceiba.biblioteca.domain.GetDatosLibrosPrestadosImpl;
import com.ceiba.biblioteca.domain.LibrosPrestadosImpl;
import com.ceiba.biblioteca.domain.RulesLibraryImpl;
import com.ceiba.biblioteca.domain.ports.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public LibrosPrestadosImpl librosPrestados(GetPortRegistration getPortRegistration) {
        return new LibrosPrestadosImpl(getPortRegistration);
    }

    @Bean
    public GetDatosLibrosPrestadosImpl getDatosLibrosPrestados(GetDatosPrestamo getDatosPrestamo) {
        return new GetDatosLibrosPrestadosImpl(getDatosPrestamo);
    }

    @Bean
    public RulesLibraryImpl rulesLibraryC(GetTypes getTypes, GetDatosUser getDatosUser, GetPortRegistration getPortRegistration, GetBooks getBooks) {
        return new RulesLibraryImpl(getTypes,getDatosUser,getPortRegistration,getBooks);
    }

}

