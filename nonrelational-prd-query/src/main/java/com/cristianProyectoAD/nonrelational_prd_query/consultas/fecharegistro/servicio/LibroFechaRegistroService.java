package com.cristianProyectoAD.nonrelational_prd_query.consultas.fecharegistro.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.repositorio.LibroRepositorioMongo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio para gestionar las consultas de libros en la base de datos no relacional (MongoDB)
 * basándose en un rango de fechas de registro.
 * Este servicio contiene la lógica de negocio para interactuar con el repositorio de libros
 * y realizar búsquedas basadas en fechas.
 *
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroFechaRegistroService {

    private final LibroRepositorioMongo libroRepositorio;

    /**
     * Constructor que inicializa el repositorio de libros de MongoDB.
     *
     * @param libroRepositorio Repositorio para realizar operaciones CRUD en MongoDB.
     */
    public LibroFechaRegistroService(LibroRepositorioMongo libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    /**
     * Obtiene una lista de libros registrados entre dos fechas específicas.
     *
     * @param fechaInicio Fecha de inicio del rango de búsqueda.
     * @param fechaFin Fecha de fin del rango de búsqueda.
     * @return Una lista de libros registrados entre las fechas proporcionadas.
     */
    public List<Libros> getLibrosFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        return libroRepositorio.findByFechaRegistroBetween(fechaInicio, fechaFin);
    }
}
