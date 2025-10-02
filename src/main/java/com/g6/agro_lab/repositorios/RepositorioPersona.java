package com.g6.agro_lab.repositorios;

import com.g6.agro_lab.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Long> {

    Persona findByDni(String dni);
}
