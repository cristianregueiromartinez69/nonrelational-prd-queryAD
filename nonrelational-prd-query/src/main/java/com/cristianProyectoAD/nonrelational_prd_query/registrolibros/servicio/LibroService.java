package com.cristianProyectoAD.nonrelational_prd_query.registrolibros.servicio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.dto.LibroRegistroDTO;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.repositorio.LibroRepositorioMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibroRepositorioMongo librosRepositorio;

    public void saveBook(LibroRegistroDTO libro) {
        Libros librosGuardar = new Libros(libro.getIsbn(), libro.getAutor(),
                libro.getNombre(), libro.getFechaLectura(), libro.getFechaRegistro());
        librosRepositorio.save(librosGuardar);
    }
}
