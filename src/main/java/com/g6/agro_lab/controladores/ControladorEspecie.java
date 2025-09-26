package com.g6.agro_lab.controladores;

import com.g6.agro_lab.entidades.Especie;
import com.g6.agro_lab.servicios.ServicioEspecie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/especies")
public class ControladorEspecie {
    private final ServicioEspecie servicioEspecie;

    @Autowired
    public ControladorEspecie(ServicioEspecie servicioEspecie){
        this.servicioEspecie = servicioEspecie;
    }

    @GetMapping()
    public List<Especie> obtenerTodasLasEspecies(){
        return servicioEspecie.obtenerTodasLasEspecies();
    }
}
