package com.g6.agro_lab.servicios;

import com.g6.agro_lab.entidades.Especie;
import com.g6.agro_lab.repositorios.RepositorioEspecie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEspecie {
    private final RepositorioEspecie repositorioEspecie;

    @Autowired
    public ServicioEspecie(RepositorioEspecie repositorioEspecie){
        this.repositorioEspecie = repositorioEspecie;
    }

    public List<Especie> obtenerTodasLasEspecies(){
        return repositorioEspecie.findAll(Sort.by("nombreEspecie"));
    }
}
