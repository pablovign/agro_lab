package com.g6.agro_lab.controladores;

import com.g6.agro_lab.dto.DTORegistro;
import com.g6.agro_lab.servicios.ServicioRegistro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/registro")
public class ControladorRegistro {
    private final ServicioRegistro servicioRegistro;

    @Autowired
    public ControladorRegistro(ServicioRegistro servicioRegistro){
        this.servicioRegistro = servicioRegistro;
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody DTORegistro dtoRegistro) {
        servicioRegistro.procesarRegistro(dtoRegistro);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Registro realizado con éxito"));
    }
}
