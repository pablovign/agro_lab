package com.g6.agro_lab.servicios;

import com.g6.agro_lab.dto.DTOEstablecimientoRegistro;
import com.g6.agro_lab.dto.DTOPoint;
import com.g6.agro_lab.entidades.Distrito;
import com.g6.agro_lab.entidades.Empresa;
import com.g6.agro_lab.entidades.Especie;
import com.g6.agro_lab.entidades.Establecimiento;
import com.g6.agro_lab.excepciones.ReglasNegocioException;
import com.g6.agro_lab.repositorios.RepositorioDistrito;
import com.g6.agro_lab.repositorios.RepositorioEspecie;
import com.g6.agro_lab.repositorios.RepositorioEstablecimiento;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public class ServicioEstablecimiento {
    private final RepositorioEstablecimiento repositorioEstablecimiento;
    private final RepositorioDistrito repositorioDistrito;
    private final RepositorioEspecie repositorioEspecie;

    @Autowired
    public ServicioEstablecimiento(RepositorioEstablecimiento repositorioEstablecimiento, RepositorioDistrito repositorioDistrito,
                                   RepositorioEspecie repositorioEspecie){
        this.repositorioEstablecimiento = repositorioEstablecimiento;
        this.repositorioDistrito = repositorioDistrito;
        this.repositorioEspecie = repositorioEspecie;
    }

    public boolean esRenspaDisponible(String renspa){
        return !repositorioEstablecimiento.existsByNumeroRenspa(renspa);
    }

    public Establecimiento registrarEstablecimiento(DTOEstablecimientoRegistro dtoEstablecimientoRegistro, Empresa empresa){
        if(!esRenspaDisponible(dtoEstablecimientoRegistro.numeroRenspa())){
            throw new ReglasNegocioException("Ya existe un establecimiento registrado con ese número de RENSPA.");
        }

        Distrito distrito = repositorioDistrito.findById(dtoEstablecimientoRegistro.idDistrito())
                .orElseThrow(() -> new ReglasNegocioException("Distrito no válido."));

        List<Especie> especies = repositorioEspecie.findAllById(dtoEstablecimientoRegistro.idEspecies());
        if (especies.isEmpty()) {
            throw new ReglasNegocioException("Debe seleccionar al menos una especie.");
        }

        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setNumeroRenspa(dtoEstablecimientoRegistro.numeroRenspa());
        establecimiento.setNombreEstablecimiento(dtoEstablecimientoRegistro.nombreEstablecimiento());
        establecimiento.setCalle(dtoEstablecimientoRegistro.calle());
        establecimiento.setNumeracion(dtoEstablecimientoRegistro.numeracion());
        establecimiento.setCodigoPostal(dtoEstablecimientoRegistro.codigoPostal());
        establecimiento.setLocalizacion(convertirPointDTO(dtoEstablecimientoRegistro.localizacion()));
        establecimiento.setDistrito(distrito);
        establecimiento.setEmpresa(empresa);
        establecimiento.setEspecies(new HashSet<>(especies));

        return repositorioEstablecimiento.save(establecimiento);
    }

    private Point convertirPointDTO(DTOPoint dto) {
        GeometryFactory geometryFactory = new GeometryFactory();
        return geometryFactory.createPoint(new Coordinate(dto.longitud(), dto.latitud()));
    }
}
