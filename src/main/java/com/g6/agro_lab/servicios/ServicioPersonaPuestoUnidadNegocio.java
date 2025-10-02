package com.g6.agro_lab.servicios;

import com.g6.agro_lab.entidades.*;
import com.g6.agro_lab.repositorios.RepositorioPersonaPuestoUnidadNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersonaPuestoUnidadNegocio {
    private final RepositorioPersonaPuestoUnidadNegocio repositorioPersonaPuestoUnidadNegocio;

    @Autowired
    public ServicioPersonaPuestoUnidadNegocio(RepositorioPersonaPuestoUnidadNegocio repositorioPersonaPuestoUnidadNegocio){
        this.repositorioPersonaPuestoUnidadNegocio = repositorioPersonaPuestoUnidadNegocio;
    }

    public PersonaPuestoUnidadNegocio registrarPersonaPuestoUnidadNegocio(Persona persona, Puesto puesto, Empresa empresa,
                                                                          Establecimiento establecimiento){
        if (persona == null) {
            return null;
        }

        PersonaPuestoUnidadNegocio personaPuestoUnidadNegocio = new PersonaPuestoUnidadNegocio();
        personaPuestoUnidadNegocio.setPersona(persona);
        personaPuestoUnidadNegocio.setPuesto(puesto);

        if (empresa != null) {
            personaPuestoUnidadNegocio.setEmpresa(empresa);
        }

        if (establecimiento != null) {
            personaPuestoUnidadNegocio.setEstablecimiento(establecimiento);
        }

        return repositorioPersonaPuestoUnidadNegocio.save(personaPuestoUnidadNegocio);
    }
}
