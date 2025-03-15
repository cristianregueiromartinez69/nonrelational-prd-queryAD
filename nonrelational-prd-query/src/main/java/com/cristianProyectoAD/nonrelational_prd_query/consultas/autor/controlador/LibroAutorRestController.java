package com.cristianProyectoAD.nonrelational_prd_query.consultas.autor.controlador;

import com.cristianProyectoAD.nonrelational_prd_query.consultas.autor.servicio.LibroAutorService;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para gestionar las consultas de libros en la base de datos no relacional (MongoDB) basadas en el autor.
 * Proporciona un endpoint para obtener libros a partir del nombre del autor.
 * La ruta base del controlador es <code>/nonrelational-prd-query/libros/consultas/</code>.
 *
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/nonrelational-prd-query/libros/consultas")
public class LibroAutorRestController {

    private final LibroAutorService libroAutorService;

    /**
     * Constructor que inicializa el servicio de consultas basado en autor.
     *
     * @param libroAutorService Servicio que gestiona las operaciones relacionadas con libros y sus autores.
     */
    public LibroAutorRestController(LibroAutorService libroAutorService) {
        this.libroAutorService = libroAutorService;
    }

    /**
     * Endpoint para obtener una lista de libros según el autor especificado.
     *
     * @param autor Nombre del autor por el cual se desean buscar los libros.
     * @return ResponseEntity que contiene la lista de libros encontrados, o un error si no se encuentran coincidencias.
     */
    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<Libros>> getLibrosMongoByAutor(@PathVariable String autor) {
        List<Libros> librosAutorList = libroAutorService.getLibrosByAutor(autor);
        return ResponseEntity.ok(librosAutorList);
    }
}
