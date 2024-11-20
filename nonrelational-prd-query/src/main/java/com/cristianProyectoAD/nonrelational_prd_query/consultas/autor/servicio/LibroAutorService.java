package com.cristianProyectoAD.nonrelational_prd_query.consultas.autor.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.repositorio.LibroRepositorioMongo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroAutorService {

    private final LibroRepositorioMongo libroRepositorio;

    public LibroAutorService(LibroRepositorioMongo libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    public List<Libros> getLibrosByAutor(String autor) {
        return libroRepositorio.findByAutor(autor);
    }
}
