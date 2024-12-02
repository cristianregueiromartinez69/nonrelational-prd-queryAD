package com.cristianProyectoAD.nonrelational_prd_query.consultas.nombre.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.excepcionglobal.BookNotFoundException;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.repositorio.LibroRepositorioMongo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar las consultas de libros por nombre en MongoDB.
 * Este servicio implementa la lógica de negocio para buscar libros en una base de datos no relacional
 * (MongoDB) utilizando el nombre como criterio de búsqueda.
 *
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroNombreService {

    private final LibroRepositorioMongo libroRepositorio;

    /**
     * Constructor que inicializa el repositorio de libros de MongoDB.
     *
     * @param libroRepositorio Repositorio que permite interactuar con la base de datos MongoDB.
     */
    public LibroNombreService(LibroRepositorioMongo libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    /**
     * Busca libros en la base de datos por su nombre.
     *
     * @param nombre El nombre del libro por el que se desea buscar.
     * @return Una lista de libros que coincidan con el nombre proporcionado.
     * @throws BookNotFoundException Si no se encuentran libros con el nombre dado.
     */
    public List<Libros> getLibrosByNombre(String nombre) {
        List<Libros> libros = libroRepositorio.findByNombre(nombre);
        if(libros.isEmpty()) {
            throw new BookNotFoundException("Lista de libros por nombre inexistente");
        }
        return libros;
    }
}
