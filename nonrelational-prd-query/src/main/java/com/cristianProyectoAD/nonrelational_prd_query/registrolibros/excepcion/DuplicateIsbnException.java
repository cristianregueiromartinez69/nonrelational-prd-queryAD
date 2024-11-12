package com.cristianProyectoAD.nonrelational_prd_query.registrolibros.excepcion;

public class DuplicateIsbnException extends RuntimeException {
    public DuplicateIsbnException(String message) {
        super(message);
    }
}
