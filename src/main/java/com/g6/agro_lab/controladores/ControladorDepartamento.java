package com.g6.agro_lab.controladores;

import com.g6.agro_lab.entidades.Departamento;
import com.g6.agro_lab.servicios.ServicioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departamentos")
public class ControladorDepartamento {
    private final ServicioDepartamento servicioDepartamento;

    @Autowired
    public ControladorDepartamento(ServicioDepartamento servicioDepartamento){
        this.servicioDepartamento = servicioDepartamento;
    }

    @GetMapping()
    public List<Departamento> obtenerTodosLosDepartamentos(){
        return servicioDepartamento.obtenerTodasLosDepartamentos();
    }
}
