package com.cristianProyectoAD.nonrelational_prd_query.registrolibros.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Clase con la colección de libros de mongo
 * @author cristian
 * @version 1.0
 */
@Document(collection = "libros")
public class Libros {

    //id de la clase
    @Id
    private String isbn;

    /**
     * atributos privados de la clase
     */
    private String autor;
    private String nombre;
    private LocalDate fechaLectura;
    private LocalDate fechaRegistro;

    /**
     * Contructor de la clase
     * @param isbn el isbn del libro
     * @param autor el autor del libro
     * @param nombre el nombre del libro
     * @param fechaLectura la fecha de lectura del libro
     * @param fechaRegistro la fecha de registro del libro
     */
    public Libros(String isbn, String autor, String nombre, LocalDate fechaLectura, LocalDate fechaRegistro) {
        this.isbn = isbn;
        this.autor = autor;
        this.nombre = nombre;
        this.fechaLectura = fechaLectura;
        this.fechaRegistro = fechaRegistro;
    }

    //constructor por defecto
    public Libros() {

    }

    /**
     * getter y setter de la clase
     * @return las variables
     */
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(LocalDate fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
