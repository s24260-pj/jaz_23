package pl.pjatk.demo.movie.advise;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.pjatk.demo.movie.exceptions.IncorrectDataException;
import pl.pjatk.demo.movie.exceptions.NotFoundException;

@ControllerAdvice
public class MovieAdvice {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occurrence on request. Exception message: " + exception.getLocalizedMessage());
    }

    @ExceptionHandler(IncorrectDataException.class)
    public ResponseEntity<String> incorrectDataException(IncorrectDataException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Bad request: " + exception.getLocalizedMessage());
    }
}
