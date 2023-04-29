package pl.pjatk.demo.movie.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String movieNotFound) {
        super(movieNotFound);
    }
}
