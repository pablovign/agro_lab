package com.g6.agro_lab.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "puestos")
public class Puesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puesto")
    private Long idPuesto;

    @NotBlank
    @Column(name = "nombre_puesto", nullable = false, unique = true)
    private String nombrePuesto;

    @NotNull
    @Column(name = "es_gestion", nullable = false)
    private Boolean esGestion;

    public Long getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Long idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public Boolean getEsGestion() {
        return esGestion;
    }

    public void setEsGestion(Boolean esGestion) {
        this.esGestion = esGestion;
    }
}
