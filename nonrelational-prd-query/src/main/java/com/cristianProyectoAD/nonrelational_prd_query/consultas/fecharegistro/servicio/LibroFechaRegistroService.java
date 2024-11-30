package com.cristianProyectoAD.nonrelational_prd_query.consultas.fecharegistro.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.repositorio.LibroRepositorioMongo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibroFechaRegistroService {

    private final LibroRepositorioMongo libroRepositorio;

    public LibroFechaRegistroService(LibroRepositorioMongo libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    public List<Libros> getLibrosFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        return libroRepositorio.findByFechaRegistroBetween(fechaInicio, fechaFin);
    }
}
