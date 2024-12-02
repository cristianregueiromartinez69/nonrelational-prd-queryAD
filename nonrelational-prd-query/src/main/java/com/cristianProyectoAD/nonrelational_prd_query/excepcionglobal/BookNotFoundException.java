package com.cristianProyectoAD.nonrelational_prd_query.excepcionglobal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para manejar casos en los que no se encuentran libros.
 * Esta excepción se lanza cuando una búsqueda en la base de datos no produce resultados.
 * Está anotada con {@link ResponseStatus} para retornar un código de estado HTTP 404 (NOT_FOUND)
 * en las respuestas de las solicitudes REST.
 *
 * @author cristian
 * @version 1.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    /**
     * Constructor de la excepción que acepta un mensaje descriptivo.
     *
     * @param message Mensaje que describe la causa de la excepción.
     */
    public BookNotFoundException(String message) {
        super(message);
    }
}
