package com.g6.agro_lab.controladores;

import com.g6.agro_lab.entidades.Distrito;
import com.g6.agro_lab.servicios.ServicioDistrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/distritos")
public class ControladorDistrito {

    private final ServicioDistrito servicioDistrito;

    @Autowired
    public ControladorDistrito(ServicioDistrito servicioDistrito) {
        this.servicioDistrito = servicioDistrito;
    }

    @GetMapping("/departamento/{idDepartamento}")
    public List<Distrito> obtenerDistritosPorDepartamento(@PathVariable Long idDepartamento) {
        return servicioDistrito.obtenerDistritosPorDepartamento(idDepartamento);
    }
}
