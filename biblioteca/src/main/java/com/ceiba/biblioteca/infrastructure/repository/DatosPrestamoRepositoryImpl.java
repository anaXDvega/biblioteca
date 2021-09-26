package com.ceiba.biblioteca.infrastructure.repository;

import com.ceiba.biblioteca.domain.RulesLibraryImpl;
import com.ceiba.biblioteca.domain.ports.repository.GetDatosPrestamo;
import com.ceiba.biblioteca.infrastructure.entity.Prestamos;
import com.ceiba.biblioteca.infrastructure.entity.Usuarios;
import com.ceiba.biblioteca.infrastructure.mapper.Prestamos.CommandMapperEntry;
import com.ceiba.biblioteca.infrastructure.mapper.Prestamos.MapperRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import com.ceiba.biblioteca.domain.exception.Exception;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class DatosPrestamoRepositoryImpl implements GetDatosPrestamo {
    public static final String SMS_ERROR_NO_HAY_REGISTRO = "No se encuentra el registro del prestamo";
    public static final String SMS_ERROR_NO_HAY_REGISTRO_USUARIO = "No Tenemos registro del usuario que has registrado";
    public static final String SMS_ERROR_DE_USUARIO = "Tipo de usuario no permitido en la biblioteca";
    public static final String SMS_ERROR_REGISTRO_YA_EXISTE = "Este registro ya existe";

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
    private  UserTypesRepository userTypesRepository;


    @Autowired
    @Lazy
    private CommandMapperEntry commandMapperEntry;

    @Autowired
    private MapperRegistry mapperRegistry;

    @Autowired
    private RulesLibraryImpl rulesLibraryImpl;

    @Override
    public Map<String, String> BuscarDatosPrestamo(String id, String idUsuario, String tipoUsuario) {
        Map<String, String> map = new HashMap<>();
        Optional<Usuarios> consultaDeUsuario = usuarioRepository.findByUsuaId(Long.parseLong(idUsuario));
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (rulesLibraryImpl.validarSiExisteTipoUsuario(Long.parseLong(tipoUsuario))) {
            throw new Exception(SMS_ERROR_DE_USUARIO);
        }
        if (rulesLibraryImpl.validarSiExisteUsuario(Long.parseLong(idUsuario))) {
            throw new Exception(SMS_ERROR_NO_HAY_REGISTRO_USUARIO);
        }
       if (rulesLibraryImpl.validarSiRegistroDelPrestamo(Long.parseLong(id), Long.parseLong(idUsuario))) {
           Date diasHabiles = rulesLibraryImpl.validacionDiasHabiles(Long.parseLong(tipoUsuario));
           Prestamos prestamos = new Prestamos(Long.parseLong(id),
           Long.parseLong(String.valueOf(consultaDeUsuario.get().getUsuaCons())));
           Prestamos registry = commandMapperEntry.mapToRegistry(prestamos);
           registry.setPresFechaPrestamo(new Date());
           registry.setPresFechaEntrega(diasHabiles);
           registryRepository.save(registry);
           map.put("fechaMaximaDevolucion", simpleDateFormat.format(diasHabiles));
           map.put("id", String.valueOf(registry.getPresCons()));
        }else{
           throw new Exception(SMS_ERROR_REGISTRO_YA_EXISTE);
       }
        return map;
    }

    @Override
    public Map<String, String> BuscarDatosPrestamo(long id) {
        return rulesLibraryImpl.BusquedaDePrestamo(id);
    }
}
