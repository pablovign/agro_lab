package com.g6.agro_lab.controladores;

import com.g6.agro_lab.dto.DTOPersonaRegistrada;
import com.g6.agro_lab.entidades.Persona;
import com.g6.agro_lab.servicios.ServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class ControladorPersona {
    private final ServicioPersona servicioPersona;

    @Autowired
    public ControladorPersona(ServicioPersona servicioPersona){
        this.servicioPersona = servicioPersona;
    }

    @GetMapping("/persona-registrada/{dni}")
    public DTOPersonaRegistrada obtenerPersonaRegistradaPorDni(@PathVariable String dni){
        return servicioPersona.obtenerPersonaRegistradaPorDni(dni);
    }
}
