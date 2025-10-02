package com.g6.agro_lab.repositorios;

import com.g6.agro_lab.entidades.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPuesto extends JpaRepository<Puesto, Long> {

    Puesto findByNombrePuesto(String nombrePuesto);
}
