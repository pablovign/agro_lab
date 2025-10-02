package com.g6.agro_lab.servicios;

import com.g6.agro_lab.dto.DTORegistro;
import com.g6.agro_lab.entidades.Empresa;
import com.g6.agro_lab.entidades.Establecimiento;
import com.g6.agro_lab.entidades.Persona;
import com.g6.agro_lab.entidades.Puesto;
import com.g6.agro_lab.excepciones.ReglasNegocioException;
import com.g6.agro_lab.repositorios.RepositorioEmpresa;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioRegistro {
    private final ServicioEmpresa servicioEmpresa;
    private final ServicioEstablecimiento servicioEstablecimiento;
    private final ServicioPersona servicioPersona;
    private final ServicioPuesto servicioPuesto;
    private final ServicioPersonaPuestoUnidadNegocio servicioPersonaPuestoUnidadNegocio;

    @Autowired
    public ServicioRegistro(ServicioEmpresa servicioEmpresa, ServicioEstablecimiento servicioEstablecimiento,
                            ServicioPersona servicioPersona, ServicioPuesto servicioPuesto,
                            ServicioPersonaPuestoUnidadNegocio servicioPersonaPuestoUnidadNegocio){
        this.servicioEmpresa = servicioEmpresa;
        this.servicioEstablecimiento = servicioEstablecimiento;
        this.servicioPersona = servicioPersona;
        this.servicioPuesto = servicioPuesto;
        this.servicioPersonaPuestoUnidadNegocio = servicioPersonaPuestoUnidadNegocio;
    }

    @Transactional
    public void procesarRegistro(DTORegistro dtoRegistro){
        if (dtoRegistro.dtoPersonaEmpresaRegistro() != null && dtoRegistro.dtoPersonaEstablecimientoRegistro() != null &&
                dtoRegistro.dtoPersonaEmpresaRegistro().dni().equals(dtoRegistro.dtoPersonaEstablecimientoRegistro().dni())) {
            throw new ReglasNegocioException("La personas que administran la empresa y el establecimiento no pueden tener el mismo DNI.");
        }

        Empresa empresa = servicioEmpresa.registrarEmpresa(dtoRegistro.dtoEmpresaRegistro());

        Establecimiento establecimiento = servicioEstablecimiento.registrarEstablecimiento(dtoRegistro.dtoEstablecimientoRegistro(), empresa);

        if(dtoRegistro.dtoPersonaEmpresaRegistro() != null){
            Persona personaEmpresa = servicioPersona.registrarPersona(dtoRegistro.dtoPersonaEmpresaRegistro());
            Puesto puestoEmpresa = servicioPuesto.obtenerPuestoPorNombrePuesto("ADMINISTRADOR EMPRESA");

            servicioPersonaPuestoUnidadNegocio.registrarPersonaPuestoUnidadNegocio(personaEmpresa, puestoEmpresa, empresa, null);
        }

        if(dtoRegistro.dtoPersonaEstablecimientoRegistro() != null){
            Persona personaEstablecimiento = servicioPersona.registrarPersona(dtoRegistro.dtoPersonaEstablecimientoRegistro());
            Puesto puestoEstablecimiento = servicioPuesto.obtenerPuestoPorNombrePuesto("ADMINISTRADOR ESTABLECIMIENTO");

            servicioPersonaPuestoUnidadNegocio.registrarPersonaPuestoUnidadNegocio(personaEstablecimiento, puestoEstablecimiento,
                    null, establecimiento);
        }
    }
}
