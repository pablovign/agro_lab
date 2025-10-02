package com.g6.agro_lab.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @NotBlank
    @Size(min = 7, max = 8)
    @Digits(integer = 8, fraction = 0)
    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @NotBlank
    @Column(name = "nombre_persona", nullable = false)
    private String nombrePersona;

    @NotBlank
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @NotBlank
    @Digits(integer = 12, fraction = 0)
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Email
    @Column(name = "email")
    private String email;
    
    @Column(name = "contrasenia", nullable = true)
    private String contrasenia;

    @Column(name = "calle")
    private String calle;

    @Digits(integer = 5, fraction = 0)
    @Column(name = "numeracion")
    private String numeracion;

    @Digits(integer = 5, fraction = 0)
    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Column(columnDefinition = "geometry(point, 4326)")
    private Point localizacion;

    @ManyToOne
    @JoinColumn(name = "id_distrito")
    private Distrito distrito;

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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
}
