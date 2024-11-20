package com.cristianProyectoAD.nonrelational_prd_query.registrolibros.excepcion;

/**
 * Clase con la excepcion por si hay doble isbn
 * @author cristian
 * @version 1.0
 */
public class DuplicateIsbnException extends RuntimeException {
    public DuplicateIsbnException(String message) {
        super(message);
    }
}
