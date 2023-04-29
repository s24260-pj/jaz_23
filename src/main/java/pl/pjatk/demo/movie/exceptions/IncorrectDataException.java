package pl.pjatk.demo.movie.exceptions;

public class IncorrectDataException extends RuntimeException {
    public IncorrectDataException(String incorrectData) {
        super(incorrectData);
    }
}
