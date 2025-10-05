package com.g6.agro_lab.servicios;

import com.g6.agro_lab.entidades.Persona;
import com.g6.agro_lab.repositorios.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDetalleUsuarioPersonalizado implements UserDetailsService {
    private final RepositorioPersona repositorioPersona;

    @Autowired
    public ServicioDetalleUsuarioPersonalizado(RepositorioPersona repositorioPersona){
        this.repositorioPersona = repositorioPersona;
    }

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        Persona persona = repositorioPersona.findByDni(dni);

        if(persona == null){
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }

        List<GrantedAuthority> authorities = persona.getPersonasPuestosUnidadesNegocio().stream()
                .map(rel -> (GrantedAuthority) new SimpleGrantedAuthority(rel.getPuesto().getNombrePuesto())).distinct().toList();

        return new org.springframework.security.core.userdetails.User(
                persona.getDni(),
                persona.getContrasenia(),
                authorities
        );
    }
}
