package com.g6.agro_lab.repositorios;

import com.g6.agro_lab.entidades.Departamento;
import com.g6.agro_lab.entidades.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioDistrito extends JpaRepository<Distrito, Long> {

    List<Distrito> findByDepartamentoOrderByNombreDistritoAsc(Departamento departamento);
}
