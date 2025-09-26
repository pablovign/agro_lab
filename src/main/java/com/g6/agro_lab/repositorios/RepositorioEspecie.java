package com.g6.agro_lab.repositorios;

import com.g6.agro_lab.entidades.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEspecie extends JpaRepository<Especie, Long> {
}
