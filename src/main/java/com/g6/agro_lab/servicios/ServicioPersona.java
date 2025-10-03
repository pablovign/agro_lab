package com.g6.agro_lab.servicios;

import com.g6.agro_lab.dto.DTOPersonaRegistro;
import com.g6.agro_lab.entidades.Persona;
import com.g6.agro_lab.repositorios.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersona {
    private final RepositorioPersona repositorioPersona;

    @Autowired
    public ServicioPersona(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    public Persona obtenerPersonaPorDni(String dni){
        return repositorioPersona.findByDni(dni);
    }

    public Persona registrarPersona(DTOPersonaRegistro dtoPersonaRegistro){
        Persona persona = obtenerPersonaPorDni(dtoPersonaRegistro.dni());

        if(persona == null){
            persona = new Persona();
            persona.setDni(dtoPersonaRegistro.dni());
            persona.setNombrePersona(dtoPersonaRegistro.nombrePersona());
            persona.setApellido(dtoPersonaRegistro.apellido());
            persona.setTelefono(dtoPersonaRegistro.telefono());
            persona.setEmail(dtoPersonaRegistro.email());
            persona.setContrasenia(dtoPersonaRegistro.contrasenia());

            return repositorioPersona.save(persona);
        }
        else{
            return persona;
        }
    }
}
