package com.cristianProyectoAD.nonrelational_prd_query.consultas.nombre.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.repositorio.LibroRepositorioMongo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroNombreService {

    private final LibroRepositorioMongo libroRepositorio;

    public LibroNombreService(LibroRepositorioMongo libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    public List<Libros> getLibrosByNombre(String nombre) {
        return libroRepositorio.findByNombre(nombre);
    }
}
