package com.cristianProyectoAD.nonrelational_prd_query.consultas.isbn.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.dto.LibroRegistroDTO;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.repositorio.LibroRepositorioMongo;
import org.springframework.stereotype.Service;

@Service
public class LibroIsbnService {

    private final LibroRepositorioMongo librosRepositorio;

    public LibroIsbnService(LibroRepositorioMongo librosRepositorio) {
        this.librosRepositorio = librosRepositorio;
    }

    public Libros getLibroByIsbn(String isbn) {
        return librosRepositorio.findByIsbn(isbn);
    }
}