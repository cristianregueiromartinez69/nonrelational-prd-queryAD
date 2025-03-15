package com.cristianProyectoAD.nonrelational_prd_query.consultas.isbn.controlador;

import com.cristianProyectoAD.nonrelational_prd_query.consultas.isbn.servicio.LibroIsbnService;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

/**
 * Controlador encargado de gestionar las consultas de libros por ISBN en la base de datos no relacional.
 * Expone un servicio REST para obtener libros a partir de su ISBN.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/nonrelational-prd-query/libros/consultas")
public class LibroConsultasIsbnRestController {

    private final LibroIsbnService libroIsbnService;

    /**
     * Constructor que inyecta el servicio de consultas de libros por ISBN.
     *
     * @param libroIsbnService El servicio que gestiona la consulta de libros por ISBN.
     */
    public LibroConsultasIsbnRestController(LibroIsbnService libroIsbnService) {
        this.libroIsbnService = libroIsbnService;
    }

    /**
     * Obtiene un libro a partir de su ISBN.
     * Si no se encuentra el libro, devuelve un error 404.
     *
     * @param isbn El ISBN del libro a consultar.
     * @return El libro encontrado o una respuesta 404 si no se encuentra el libro.
     */
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Libros> getLibroByIsbn(@PathVariable String isbn) {
            Libros libro = libroIsbnService.getLibroByIsbn(isbn);
            return ResponseEntity.ok(libro);
    }
}
