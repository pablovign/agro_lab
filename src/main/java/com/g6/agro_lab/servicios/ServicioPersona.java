package com.g6.agro_lab.servicios;

import com.g6.agro_lab.dto.DTOPersonaRegistro;
import com.g6.agro_lab.dto.DTOPersonaRegistrada;
import com.g6.agro_lab.entidades.Persona;
import com.g6.agro_lab.excepciones.RecursoNoEncontradoException;
import com.g6.agro_lab.repositorios.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersona {
    private final RepositorioPersona repositorioPersona;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ServicioPersona(RepositorioPersona repositorioPersona, PasswordEncoder passwordEncoder){
        this.repositorioPersona = repositorioPersona;
        this.passwordEncoder = passwordEncoder;
    }

    private Persona obtenerPersonaPorDni(String dni){
        return repositorioPersona.findByDni(dni);
    }

    public Persona registrarPersona(DTOPersonaRegistro dtoPersonaRegistro){
        if(dtoPersonaRegistro == null){
            return null;
        }

        Persona persona = obtenerPersonaPorDni(dtoPersonaRegistro.dni());

        if(persona == null){
            persona = new Persona();
            persona.setDni(dtoPersonaRegistro.dni());
            persona.setNombrePersona(dtoPersonaRegistro.nombrePersona());
            persona.setApellido(dtoPersonaRegistro.apellido());
            persona.setTelefono(dtoPersonaRegistro.telefono());
            persona.setEmail(dtoPersonaRegistro.email());
            persona.setContrasenia(passwordEncoder.encode(dtoPersonaRegistro.contrasenia()));

            return repositorioPersona.save(persona);
        }
        else{
            return persona;
        }
    }

    public DTOPersonaRegistrada obtenerPersonaRegistradaPorDni(String dni){
        Persona persona = obtenerPersonaPorDni(dni);

        if(persona == null){
            throw new RecursoNoEncontradoException("No se encontró una persona con DNI: " + dni);
        }

        return new DTOPersonaRegistrada(
                persona.getNombrePersona(),
                persona.getApellido(),
                persona.getTelefono(),
                persona.getEmail()
        );
    }
}
