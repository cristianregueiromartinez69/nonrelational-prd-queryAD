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

@RestController
@RequestMapping("/nonrelational-prd-query/libros/consultas")
public class LibroConsultasIsbnRestController {

    private final LibroIsbnService libroIsbnService;

    public LibroConsultasIsbnRestController(LibroIsbnService libroIsbnService) {
        this.libroIsbnService = libroIsbnService;
    }

    @GetMapping("isbn{isbn}")
    public ResponseEntity<Libros> getLibroByIsbn(@PathVariable String isbn) {
        try {
            Libros libro = libroIsbnService.getLibroByIsbn(isbn);
            return ResponseEntity.ok(libro);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
