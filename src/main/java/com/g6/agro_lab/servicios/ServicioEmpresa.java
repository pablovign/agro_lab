package com.g6.agro_lab.servicios;

import com.g6.agro_lab.dto.DTOEmpresaRegistro;
import com.g6.agro_lab.entidades.Empresa;
import com.g6.agro_lab.excepciones.ReglasNegocioException;
import com.g6.agro_lab.repositorios.RepositorioEmpresa;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEmpresa {
    private final RepositorioEmpresa repositorioEmpresa;

    @Autowired
    public ServicioEmpresa(RepositorioEmpresa repositorioEmpresa){
        this.repositorioEmpresa = repositorioEmpresa;
    }

    public boolean esCuitDisponible(String cuit){
        return !repositorioEmpresa.existsByCuit(cuit);
    }

    public Empresa registrarEmpresa(DTOEmpresaRegistro dtoEmpresaRegistro){
        if(!esCuitDisponible(dtoEmpresaRegistro.cuit())){
            throw new ReglasNegocioException("Ya existe una empresa registrada con ese CUIT.");
        }

        Empresa empresa = new Empresa();
        empresa.setCuit(dtoEmpresaRegistro.cuit());
        empresa.setRazonSocial(dtoEmpresaRegistro.razonSocial());

        return repositorioEmpresa.save(empresa);
    }
}
