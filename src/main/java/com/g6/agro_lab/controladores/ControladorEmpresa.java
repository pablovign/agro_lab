package com.g6.agro_lab.controladores;

import com.g6.agro_lab.servicios.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/empresas")
public class ControladorEmpresa {
    private final ServicioEmpresa servicioEmpresa;

    @Autowired
    public ControladorEmpresa(ServicioEmpresa servicioEmpresa){
        this.servicioEmpresa = servicioEmpresa;
    }
}
