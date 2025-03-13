package com.cristianProyectoAD.nonrelational_prd_query.consultas.fechalectura.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.repositorio.LibroRepositorioMongo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio de consulta de libros por fecha de lectura
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroConsultaFechaLecturaService {

    //variable del repositorio de mongo
    private final LibroRepositorioMongo libroRepositorioMongo;

    /**
     * Constructor de la clase
     * @param libroRepositorioMongo el repositorio de mongo
     */
    public LibroConsultaFechaLecturaService(LibroRepositorioMongo libroRepositorioMongo) {
        this.libroRepositorioMongo = libroRepositorioMongo;
    }

    /**
     * Metodo para devolver un libro entre fechas de lectura
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha de fin
     * @return la lista de libros
     */
    public List<Libros> getLibrosByFechaLecturaService(LocalDate fechaInicio, LocalDate fechaFin) {
        return libroRepositorioMongo.findByFechaLecturaBetween(fechaInicio, fechaFin);
    }
}
