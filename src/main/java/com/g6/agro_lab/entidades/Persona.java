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

    @NotBlank(message = "El DNI es obligatorio.")
    @Size(min = 7, max = 8, message = "El DNI debe tener 7 u 8 dígitos.")
    @Digits(integer = 8, fraction = 0, message = "El DNI debe estar compuesto de números.")
    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @NotBlank(message = "El nombre de la persona es obligatorio.")
    @Column(name = "nombre_persona", nullable = false)
    private String nombrePersona;

    @NotBlank(message = "El apellido es obligatorio.")
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @NotBlank(message = "El número de teléfono es obligatorio.")
    @Digits(integer = 12, fraction = 0, message = "El número de telefono debe estar compuesto de números.")
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Email(message = "El e-mail debe estar formado correctamente.")
    @Column(name = "email")
    private String email;

    @Size(min = 6, max = 60, message = "La contraseña debe tener menos de 60 caracteres.")
    @Column(name = "contrasenia", nullable = true)
    private String contrasenia;

    @Column(name = "calle")
    private String calle;

    @Size(max = 5, message = "La numeración debe tener menos de 6 dígitos")
    @Digits(integer = 5, fraction = 0, message = "La numeración debe estar compuesta de números.")
    @Column(name = "numeracion")
    private String numeracion;

    @Size(max = 4, message = "El código postal debe tener menos de 5 dígitos.")
    @Digits(integer = 5, fraction = 0, message = "El código postal debe estar compuesto de números.")
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
