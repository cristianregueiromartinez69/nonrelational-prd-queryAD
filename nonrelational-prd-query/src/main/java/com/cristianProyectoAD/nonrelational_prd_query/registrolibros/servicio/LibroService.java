package com.cristianProyectoAD.nonrelational_prd_query.registrolibros.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.dto.LibroRegistroDTO;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.excepcion.DuplicateIsbnException;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.repositorio.LibroRepositorioMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase servicio donde llamamos al repositorio de mongo para el registro de libros
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroService {

    //inyección de dependencias en el repositorio de mongo
    @Autowired
    private LibroRepositorioMongo librosRepositorio;

    /**
     * Metodo para guardar libros en el repositorio de mongo
     * @param libro el libro a guardar
     */
    public void saveBook(LibroRegistroDTO libro) {


        if(librosRepositorio.existsByIsbn(libro.getIsbn())) {
            throw new DuplicateIsbnException("el isbn ya existe en la base de datos, por favor, introduce otro");
        }
        else{
            Libros librosGuardar = new Libros(libro.getIsbn(), libro.getAutor(),
                    libro.getNombre(), libro.getFechaLectura(), libro.getFechaRegistro());
            librosRepositorio.save(librosGuardar);
        }
    }
}
