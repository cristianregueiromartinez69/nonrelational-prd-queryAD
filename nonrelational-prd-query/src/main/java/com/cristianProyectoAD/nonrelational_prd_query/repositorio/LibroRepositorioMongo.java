package com.cristianProyectoAD.nonrelational_prd_query.repositorio;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo.Libros;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio para la base de datos de mongo
 * @author cristian
 * @version 1.0
 */
@Repository
public interface LibroRepositorioMongo extends MongoRepository<Libros, String> {
    //metodo booleanos para comprobar que existe el isbn que vas a introducit y no introducir otro
    boolean existsByIsbn(String isbn);

    //metodo que devuelve un libro si coincide con el isbn encontrado
    Libros findByIsbn(String isbn);

    //metodo para listar libros por autor
    List<Libros> findByAutor(String autor);

    //metodo para listar libros por nombre
    List<Libros> findByNombre(String nombre);

    //metodo que lista libros por fecha de registro en base a inicio y fin en mongo
    List <Libros> findByFechaRegistroBetween(LocalDate startDate, LocalDate endDate);

    //metodo que lista libros por fecha de lectura en base a inicio y fin en mongo
    List <Libros> findByFechaLecturaBetween(LocalDate startDate, LocalDate endDate);



}
