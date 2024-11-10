package com.cristianProyectoAD.nonrelational_prd_query.registrolibros.controlador;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.dto.LibroRegistroDTO;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.servicio.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nonrelational-prd-query/libros")
public class RegistroLibrosRestController {

    private final LibroService libroService;

    public RegistroLibrosRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> saveBooksPostgres(@RequestBody LibroRegistroDTO registro) {
        libroService.saveBook(registro);
        return ResponseEntity.ok("Registro de libro en MongoDB");
    }

}
