package pl.pjatk.demo.movie.advise;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.pjatk.demo.movie.exceptions.IncorrectDataException;
import pl.pjatk.demo.movie.exceptions.NotFoundException;

import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Set<ValidationError>> stringResponseEntity(ConstraintViolationException exception) {
        Set<ValidationError> validationErrors = exception.getConstraintViolations().stream()
                .map(constraintViolation -> {
                    return new ValidationError(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
                })
                .collect(Collectors.toSet());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
    }
    public class ValidationError {
        private final String property;
        private final String validationError;

        public ValidationError(String property, String validationError) {
            this.property = property;
            this.validationError = validationError;
        }

        public String getProperty() {
            return property;
        }

        public String getValidationError() {
            return validationError;
        }
    }
}
