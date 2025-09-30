package com.g6.agro_lab.repositorios;

import com.g6.agro_lab.entidades.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstablecimiento extends JpaRepository<Establecimiento, Long> {
    boolean existsByNumeroRenspa(String numeroRenspa);
}
