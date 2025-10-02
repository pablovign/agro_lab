package com.g6.agro_lab.servicios;

import com.g6.agro_lab.entidades.Puesto;
import com.g6.agro_lab.repositorios.RepositorioPuesto;
import org.springframework.stereotype.Service;

@Service
public class ServicioPuesto {
    private final RepositorioPuesto repositorioPuesto;

    public ServicioPuesto(RepositorioPuesto repositorioPuesto){
        this.repositorioPuesto = repositorioPuesto;
    }

    public Puesto obtenerPuestoPorNombrePuesto(String nombrePuesto){
        return repositorioPuesto.findByNombrePuesto(nombrePuesto);
    }
}
