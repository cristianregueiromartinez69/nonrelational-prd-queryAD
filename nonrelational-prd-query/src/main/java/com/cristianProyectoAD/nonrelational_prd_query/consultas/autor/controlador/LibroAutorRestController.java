package com.cristianProyectoAD.nonrelational_prd_query.consultas.autor.controlador;

import com.cristianProyectoAD.nonrelational_prd_query.consultas.autor.servicio.LibroAutorService;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nonrelational-prd-query/libros/consultas/")
public class LibroAutorRestController {

    private final LibroAutorService libroAutorService;

    public LibroAutorRestController(LibroAutorService libroAutorService) {
        this.libroAutorService = libroAutorService;
    }

    @GetMapping("autor{autor}")
    public ResponseEntity<List<Libros>> getLibrosMongoByAutor(@PathVariable String autor) {
        List<Libros> librosAutorList = libroAutorService.getLibrosByAutor(autor);
        return ResponseEntity.ok(librosAutorList);
    }
}
