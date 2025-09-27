package com.g6.agro_lab.servicios;

import com.g6.agro_lab.entidades.Empresa;
import com.g6.agro_lab.repositorios.RepositorioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean esRazonSocialDisponible(String razonSocial){
        return !repositorioEmpresa.existsByRazonSocial(razonSocial);
    }
}
