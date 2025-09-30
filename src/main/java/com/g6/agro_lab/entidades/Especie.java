package com.g6.agro_lab.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "especies")
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especie")
    private Long idEspecie;

    @NotBlank
    @Column(name = "nombre_especie", nullable = false, unique = true)
    private String nombreEspecie;

    @ManyToMany(mappedBy = "especies")
    private Set<Establecimiento> establecimientos = new HashSet<>();

    public Long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public Set<Establecimiento> getEstablecimientos() {
        return establecimientos;
    }

    public void setEstablecimientos(Set<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }
}
