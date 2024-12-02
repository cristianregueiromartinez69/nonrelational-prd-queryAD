package com.cristianProyectoAD.nonrelational_prd_query.consultas.fecharegistro.controlador;

import com.cristianProyectoAD.nonrelational_prd_query.consultas.fecharegistro.servicio.LibroFechaRegistroService;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador REST para gestionar las consultas de libros en la base de datos no relacional (MongoDB)
 * según un rango de fechas de registro.
 *
 * Este controlador expone una API para buscar libros registrados entre dos fechas específicas.
 *
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/nonrelational-prd-query/libros/consultas")
public class LibroFechaRegistroRestController {

    private final LibroFechaRegistroService libroFechaRegistroService;

    /**
     * Constructor que inicializa el servicio encargado de gestionar las consultas por fechas de registro.
     *
     * @param libroFechaRegistroService Servicio que proporciona la lógica para consultar libros según las fechas.
     */
    public LibroFechaRegistroRestController(LibroFechaRegistroService libroFechaRegistroService) {
        this.libroFechaRegistroService = libroFechaRegistroService;
    }

    /**
     * Endpoint para obtener una lista de libros registrados entre un rango de fechas.
     *
     * @param fechaInicio Fecha de inicio del rango de búsqueda.
     * @param fechaFin Fecha de fin del rango de búsqueda.
     * @return Una respuesta HTTP con la lista de libros encontrados o un estado adecuado si no hay resultados.
     */
    @GetMapping("/fecharegistro")
    public ResponseEntity<List<Libros>> getLibrosFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Libros> librosList = libroFechaRegistroService.getLibrosFechaRegistro(fechaInicio, fechaFin);
        return ResponseEntity.ok(librosList);
    }

}
