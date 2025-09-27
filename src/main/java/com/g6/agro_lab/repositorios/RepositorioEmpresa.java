package com.g6.agro_lab.repositorios;

import com.g6.agro_lab.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa, Long> {

    boolean existsByCuit(String cuit);

    boolean existsByRazonSocial(String razonSocial);
}
