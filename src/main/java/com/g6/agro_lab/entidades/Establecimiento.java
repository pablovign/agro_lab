package com.g6.agro_lab.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "establecimientos")
public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstablecimiento;

    @NotBlank(message = "El número de RENSPA es obligatorio.")
    @Size(min = 11, max = 11, message = "El número de RENSPA debe tener 11 dígitos.")
    @Digits(integer = 11, fraction = 0, message = "El número de RENSPA debe estar compuesto de números.")
    @Column(name = "numero_renspa", nullable = false, unique = true)
    private String numeroRenspa;

    @NotBlank(message = "El nombre del establecimiento es obligatorio.")
    @Column(name = "nombre_establecimiento", nullable = false)
    private String nombreEstablecimiento;

    @Column(name = "fecha_alta", nullable = false, insertable = false, updatable = false)
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_baja", nullable = true)
    private LocalDateTime fechaBaja;

    @NotBlank(message = "La calle es obligatoria.")
    @Column(name = "calle")
    private String calle;

    @NotBlank(message = "La numeración es obligatoria.")
    @Size(max = 5, message = "La numeración debe tener menos de 6 dígitos")
    @Digits(integer = 5, fraction = 0, message = "La numeración debe estar compuesta de números.")
    @Column(name = "numeracion")
    private String numeracion;

    @NotBlank(message = "El código postal es obligatorio.")
    @Size(max = 4, message = "El código postal debe tener menos de 5 dígitos.")
    @Digits(integer = 5, fraction = 0, message = "El código postal debe estar compuesto de números.")
    @Column(name = "codigo_postal")
    private String codigoPostal;

    @NotNull(message = "La localización geográfica es obligatoria.")
    @Column(columnDefinition = "geometry(point, 4326)")
    private Point localizacion;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_distrito")
    private Distrito distrito;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @NotEmpty
    @ManyToMany
    @JoinTable(name = "establecimientos_especies", joinColumns = @JoinColumn(name = "id_establecimiento"),
            inverseJoinColumns = @JoinColumn(name = "id_especie"))
    private Set<Especie> especies = new HashSet<>();

    public Long getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Long idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNumeroRenspa() {
        return numeroRenspa;
    }

    public void setNumeroRenspa(String numeroRenspa) {
        this.numeroRenspa = numeroRenspa;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Point getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Point localizacion) {
        this.localizacion = localizacion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Set<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(Set<Especie> especies) {
        this.especies = especies;
    }
}
