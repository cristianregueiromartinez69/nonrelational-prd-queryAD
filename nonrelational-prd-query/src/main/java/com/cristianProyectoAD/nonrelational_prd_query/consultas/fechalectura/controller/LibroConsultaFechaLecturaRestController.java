package com.cristianProyectoAD.nonrelational_prd_query.consultas.fechalectura.controller;

import com.cristianProyectoAD.nonrelational_prd_query.consultas.fechalectura.servicio.LibroConsultaFechaLecturaService;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Rest controller de consulta de libros entre fechas de lectura
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/nonrelational-prd-query/libros/consultas")
public class LibroConsultaFechaLecturaRestController {

    //variable de servicio de libros consulta fechas de lectura
    private final LibroConsultaFechaLecturaService libroConsultaFechaLecturaService;

    /**
     * Constructor de la clase
     * @param libroConsultaFechaLecturaService el servicio de fecha de lectura
     */
    public LibroConsultaFechaLecturaRestController(LibroConsultaFechaLecturaService libroConsultaFechaLecturaService) {
        this.libroConsultaFechaLecturaService = libroConsultaFechaLecturaService;
    }

    /**
     * Metodo Get para obtener un listado de libros entre fechas de lectura
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha de fin
     * @return la lista de libros
     */
    @GetMapping("/fechalectura")
    public ResponseEntity<List<Libros>> getLibrosByFechaLecturaRestController(@RequestParam("fechaInicio") LocalDate fechaInicio,
                                                                              @RequestParam("fechaFin") LocalDate fechaFin){

        List<Libros> librosList = libroConsultaFechaLecturaService.getLibrosByFechaLecturaService(fechaInicio, fechaFin);
        return ResponseEntity.ok(librosList);
    }
}
