package com.g6.agro_lab.servicios;

import com.g6.agro_lab.entidades.Departamento;
import com.g6.agro_lab.entidades.Especie;
import com.g6.agro_lab.repositorios.RepositorioDepartamento;
import com.g6.agro_lab.repositorios.RepositorioEspecie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDepartamento {
    private final RepositorioDepartamento repositorioDepartamento;

    @Autowired
    public ServicioDepartamento(RepositorioDepartamento repositorioDepartamento){
        this.repositorioDepartamento = repositorioDepartamento;
    }

    public List<Departamento> obtenerTodasLosDepartamentos(){
        return repositorioDepartamento.findAll(Sort.by("nombreDepartamento"));
    }
}
