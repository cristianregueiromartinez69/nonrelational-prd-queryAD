package com.cristianProyectoAD.nonrelational_prd_query.consultas.autor.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.excepcionglobal.BookNotFoundException;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.repositorio.LibroRepositorioMongo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar las consultas de libros en la base de datos no relacional (MongoDB) basadas en el autor.
 * Este servicio interactúa con el repositorio para realizar operaciones de búsqueda.
 *
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroAutorService {

    private final LibroRepositorioMongo libroRepositorio;

    /**
     * Constructor que inicializa el repositorio de libros de MongoDB.
     *
     * @param libroRepositorio Repositorio que proporciona métodos para consultar libros en la base de datos no relacional.
     */
    public LibroAutorService(LibroRepositorioMongo libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    /**
     * Busca libros en la base de datos por el nombre del autor.
     *
     * @param autor Nombre del autor por el cual se desean buscar los libros.
     * @return Lista de libros encontrados que coinciden con el autor proporcionado.
     * @throws BookNotFoundException Si no se encuentran libros que coincidan con el autor proporcionado.
     */
    public List<Libros> getLibrosByAutor(String autor) {
        List<Libros> librosList = libroRepositorio.findByAutor(autor);
        if(librosList.isEmpty()){
            throw new BookNotFoundException("Lista de libros por autor inexistente");
        }
        return librosList;
    }
}
