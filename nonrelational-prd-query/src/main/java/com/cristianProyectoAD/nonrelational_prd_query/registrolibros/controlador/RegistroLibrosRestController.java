package com.cristianProyectoAD.nonrelational_prd_query.registrolibros.controlador;

import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.dto.LibroRegistroDTO;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.excepcion.DuplicateIsbnException;
import com.cristianProyectoAD.nonrelational_prd_query.registrolibros.servicio.LibroService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Restcontroller donde vienen los datos que se van a guardar en la base de datosa de mongo
 *
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/nonrelational-prd-query/libros/")
public class RegistroLibrosRestController {

    //servicio de registro de libros
    private final LibroService libroService;

    /**
     * Constructor de la clase
     *
     * @param libroService el servicio de mongo
     */
    public RegistroLibrosRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Metodo para guardar libros en la base de mongo
     *
     * @param registro el registro que se hace en la base de datos
     * @return una confirmación delr egistro o no
     */
    @PostMapping("/guardar")
    public ResponseEntity<String> saveBooksMongo(@RequestBody LibroRegistroDTO registro) {
        libroService.saveBook(registro);

        return ResponseEntity.ok("Registro de libro en MongoDB");
    }

    @ExceptionHandler(DuplicateIsbnException.class)
    public ResponseEntity<String> handleDuplicateIsbnException(DuplicateIsbnException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
