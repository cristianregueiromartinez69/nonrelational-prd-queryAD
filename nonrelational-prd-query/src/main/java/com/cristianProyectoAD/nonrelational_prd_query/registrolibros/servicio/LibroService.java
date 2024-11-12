package com.cristianProyectoAD.nonrelational_prd_query.registrolibros.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.dto.LibroRegistroDTO;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.repositorio.LibroRepositorioMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase servicio donde llamamos al repositorio de mongo para el registro de libros
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroService {

    //inyyección de dependencias en el repositorio de mongo
    @Autowired
    private LibroRepositorioMongo librosRepositorio;

    /**
     * Metodo para guardar libros en el repositorio de mongo
     * @param libro el libro a guardar
     */
    public void saveBook(LibroRegistroDTO libro) {
        //creamos un objeto de tipo libro y lo guardamos en el repositorio de mongo
        Libros librosGuardar = new Libros(libro.getIsbn(), libro.getAutor(),
                libro.getNombre(), libro.getFechaLectura(), libro.getFechaRegistro());
        librosRepositorio.save(librosGuardar);
    }
}
