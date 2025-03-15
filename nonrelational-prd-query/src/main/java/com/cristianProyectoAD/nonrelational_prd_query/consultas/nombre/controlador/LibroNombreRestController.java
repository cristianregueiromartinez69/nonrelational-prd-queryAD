package com.cristianProyectoAD.nonrelational_prd_query.consultas.nombre.controlador;

import com.cristianProyectoAD.nonrelational_prd_query.consultas.nombre.servicio.LibroNombreService;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Controlador REST para gestionar las consultas de libros en MongoDB basadas en el nombre del libro.
 * Este controlador expone un endpoint para buscar libros almacenados en la base de datos no relacional
 * (MongoDB) según su nombre.
 *
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/nonrelational-prd-query/libros/consultas")
public class LibroNombreRestController {

    private final LibroNombreService libroNombreService;

    /**
     * Constructor que inicializa el servicio de libros por nombre.
     *
     * @param libroNombreService Servicio que contiene la lógica de negocio para consultas por nombre.
     */
    public LibroNombreRestController(LibroNombreService libroNombreService) {
        this.libroNombreService = libroNombreService;
    }

    /**
     * Endpoint para obtener una lista de libros almacenados en MongoDB según su nombre.
     *
     * @param nombre El nombre del libro por el que se desea buscar.
     * @return Una lista de libros que coincidan con el nombre proporcionado, dentro de una
     *         respuesta HTTP con estado 200 OK.
     */
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Libros>> getLibrosByNombreMongo(@PathVariable String nombre) {
        List<Libros> libros = libroNombreService.getLibrosByNombre(nombre);
        return ResponseEntity.ok(libros);
    }
}
