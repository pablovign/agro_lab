package com.g6.agro_lab.repositorios;

import com.g6.agro_lab.entidades.PersonaPuestoUnidadNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPersonaPuestoUnidadNegocio extends JpaRepository<PersonaPuestoUnidadNegocio, Long> {
    List<PersonaPuestoUnidadNegocio> findByPersona_IdPersonaAndFechaBajaIsNull(Long idPersona);
}
