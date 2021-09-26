package com.ceiba.biblioteca.infrastructure.repository;

import com.ceiba.biblioteca.domain.ports.repository.GetPortRegistration;
import com.ceiba.biblioteca.infrastructure.entity.Prestamos;
import com.ceiba.biblioteca.infrastructure.entity.TiposUsuarios;
import com.ceiba.biblioteca.infrastructure.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import com.ceiba.biblioteca.infrastructure.mapper.Prestamos.MapperRegistry;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;

@Repository
public class RegistryRepositoryImpl implements GetPortRegistration {
    private List<Prestamos> PrestamosLista = new ArrayList<Prestamos>();
    private List<Usuarios> usuariosLista = new ArrayList<Usuarios>();
    @Autowired
    @Lazy
    private  RegistryRepository registryRepository;

    @Autowired
    @Lazy
    private  UsuarioRepository usuarioRepository;

    @Autowired
    @Lazy
    private  UserTypesRepository  userTypesRepository ;


    @Autowired
    private MapperRegistry mapperRegistry;

    @Override
    public Prestamos save(Prestamos prestamos) {
        return registryRepository.save(prestamos);
    }

    @Override
    public Prestamos findBypresCons(long id) {
        Prestamos registry = null;
        Optional<Prestamos> opcional = registryRepository.findByPresCons(id);
        if (opcional.isPresent()) {
            registry = mapperRegistry.mapToDomain(opcional.get());
        }
        return registry;
    }

    @Override
    public Prestamos findByprespresIsbnAndIdUsuarioLong(Long idLibro, Long idUsuario) {
        Prestamos registry = null;
        Optional<Prestamos> opcional = registryRepository.findByPresIsbnAndPresIdUsuario(idLibro, idUsuario);
        if (opcional.isPresent()) {
            registry = mapperRegistry.mapToDomain(opcional.get());
        }
        return registry;
    }


    @Override
    public Prestamos findByprespresIsbnAndIdUsuario(String id, String cedula) {
        Prestamos registry = null;
        long idconvertido= Long.parseLong(id);
        long cedulaconvertido= Long.parseLong(cedula);
        Optional<Prestamos> opcional = registryRepository.findByPresIsbnAndPresIdUsuario( idconvertido,  cedulaconvertido);
        long idUsuarioConvertido = Long.parseLong(String.valueOf(opcional.get().getPresIdUsuario()));
        if (opcional.isPresent()) {
            Map<String, String> map = new HashMap<>();
            map.put("isbn", String.valueOf(opcional.get().getPresIsbn()));
            registry = mapperRegistry.mapToDomain(opcional.get());
        }
        return registry;
    }


    @Override
    public List<Prestamos> listaLibrosPrestados() {
        return mapperRegistry.mapToDomain(registryRepository.findAll());
    }
}
