package com.cristianProyectoAD.nonrelational_prd_query.consultas.isbn.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.excepcionglobal.BookNotFoundException;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.repositorio.LibroRepositorioMongo;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de gestionar las consultas de libros por ISBN en la base de datos no relacional.
 * Utiliza un repositorio MongoDB para obtener los datos.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroIsbnService {

    private final LibroRepositorioMongo librosRepositorio;

    /**
     * Constructor que inyecta el repositorio de libros MongoDB.
     *
     * @param librosRepositorio El repositorio de libros en MongoDB.
     */
    public LibroIsbnService(LibroRepositorioMongo librosRepositorio) {
        this.librosRepositorio = librosRepositorio;
    }

    /**
     * Obtiene un libro a partir de su ISBN desde la base de datos no relacional.
     *
     * @param isbn El ISBN del libro a consultar.
     * @return El libro correspondiente al ISBN dado.
     */
    public Libros getLibroByIsbn(String isbn) {
        Libros libro = librosRepositorio.findByIsbn(isbn);
        if (libro == null) {
            throw new BookNotFoundException("Este libro con el isbn " + isbn + " no existe");
        }
        return libro;
    }
}