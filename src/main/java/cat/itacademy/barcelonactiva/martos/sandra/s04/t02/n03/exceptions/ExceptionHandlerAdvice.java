package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;


@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Input not valid \n" + ex.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No element found with id");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handlePrimaryKeyViolation(DataIntegrityViolationException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Element already exists\n" + ex.getMessage());
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<String> handleInvalidInput(HttpMessageConversionException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect data type");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> hadleGeneralException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something unexpected went wrong\n" + ex.getMessage());
    }

}
