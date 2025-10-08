package com.g6.agro_lab.controladores;

import com.g6.agro_lab.config.seguridad.JwtUtil;
import com.g6.agro_lab.dto.DTOAutRespuesta;
import com.g6.agro_lab.dto.DTOAutSolicitud;
import com.g6.agro_lab.servicios.ServicioDetalleUsuarioPersonalizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aut")
public class ControladorAut {
    private final AuthenticationManager authenticationManager;
    private final ServicioDetalleUsuarioPersonalizado servicioDetalleUsuarioPersonalizado;
    private final JwtUtil jwtUtil;

    @Autowired
    public ControladorAut(AuthenticationManager authenticationManager, ServicioDetalleUsuarioPersonalizado servicioDetalleUsuarioPersonalizado,
                          JwtUtil jwtUtil){
        this.authenticationManager = authenticationManager;
        this.servicioDetalleUsuarioPersonalizado = servicioDetalleUsuarioPersonalizado;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<DTOAutRespuesta> login(@RequestBody DTOAutSolicitud solicitud) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(solicitud.dni(), solicitud.contrasenia()));

            UserDetails userDetails = servicioDetalleUsuarioPersonalizado.loadUserByUsername(solicitud.dni());
            String token = jwtUtil.generarToken(userDetails);

            return ResponseEntity.ok(new DTOAutRespuesta(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
