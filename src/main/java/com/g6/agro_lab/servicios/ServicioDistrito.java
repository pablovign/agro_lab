package com.g6.agro_lab.servicios;

import com.g6.agro_lab.entidades.Departamento;
import com.g6.agro_lab.entidades.Distrito;
import com.g6.agro_lab.repositorios.RepositorioDepartamento;
import com.g6.agro_lab.repositorios.RepositorioDistrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioDistrito {
    private final RepositorioDistrito repositorioDistrito;
    private final RepositorioDepartamento repositorioDepartamento;

    @Autowired
    public ServicioDistrito(RepositorioDistrito repositorioDistrito, RepositorioDepartamento repositorioDepartamento){
        this.repositorioDistrito = repositorioDistrito;
        this.repositorioDepartamento = repositorioDepartamento;
    }

    public List<Distrito> obtenerDistritosPorDepartamento(Long idDepartamento){
        Departamento departamento = repositorioDepartamento.findById(idDepartamento)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + idDepartamento));

        return repositorioDistrito.findByDepartamentoOrderByNombreDistritoAsc(departamento);
    }
}
