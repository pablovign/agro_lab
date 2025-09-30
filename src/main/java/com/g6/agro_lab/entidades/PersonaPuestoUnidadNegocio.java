package com.g6.agro_lab.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "personas_puestos_unidades_negocio")
public class PersonaPuestoUnidadNegocio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona_puesto_unidad_negocio")
    private Long idPersonaPuestoUnidadNegocio;

    @Column(name = "fecha_alta", nullable = false, insertable = false, updatable = false)
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_baja", nullable = true)
    private LocalDateTime fechaBaja;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_puesto", nullable = false)
    private Puesto puesto;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = true)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "establecimiento", nullable = true)
    private Establecimiento establecimiento;

    public Long getIdPersonaPuestoUnidadNegocio() {
        return idPersonaPuestoUnidadNegocio;
    }

    public void setIdPersonaPuestoUnidadNegocio(Long idPersonaPuestoUnidadNegocio) {
        this.idPersonaPuestoUnidadNegocio = idPersonaPuestoUnidadNegocio;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }
}
