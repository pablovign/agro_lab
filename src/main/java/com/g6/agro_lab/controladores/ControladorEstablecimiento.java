package com.g6.agro_lab.controladores;

import com.g6.agro_lab.servicios.ServicioEstablecimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/establecimientos")
public class ControladorEstablecimiento {
    private final ServicioEstablecimiento servicioEstablecimiento;

    @Autowired
    public ControladorEstablecimiento(ServicioEstablecimiento servicioEstablecimiento){
        this.servicioEstablecimiento = servicioEstablecimiento;
    }

    @GetMapping("/validar-renspa")
    public ResponseEntity<Map<String, Object>> validarRenspa(@RequestParam String numeroRenspa){
        boolean disponible = servicioEstablecimiento.esRenspaDisponible(numeroRenspa);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("número renspa", numeroRenspa);
        respuesta.put("disponible", disponible);

        return ResponseEntity.ok(respuesta);
    }
}
