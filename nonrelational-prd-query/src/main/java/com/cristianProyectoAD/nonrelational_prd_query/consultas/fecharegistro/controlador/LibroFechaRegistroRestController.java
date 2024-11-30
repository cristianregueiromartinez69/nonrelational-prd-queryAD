package com.cristianProyectoAD.nonrelational_prd_query.consultas.fecharegistro.controlador;

import com.cristianProyectoAD.nonrelational_prd_query.consultas.fecharegistro.servicio.LibroFechaRegistroService;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/nonrelational-prd-query/libros/consultas")
public class LibroFechaRegistroRestController {

    private final LibroFechaRegistroService libroFechaRegistroService;

    public LibroFechaRegistroRestController(LibroFechaRegistroService libroFechaRegistroService) {
        this.libroFechaRegistroService = libroFechaRegistroService;
    }

    @GetMapping("/fecharegistro")
    public ResponseEntity<List<Libros>> getLibrosFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Libros> librosList = libroFechaRegistroService.getLibrosFechaRegistro(fechaInicio, fechaFin);
        return ResponseEntity.ok(librosList);
    }

}
