package pl.pjatk.demo.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.demo.movie.exceptions.IncorrectDataException;
import pl.pjatk.demo.movie.exceptions.NotFoundException;
import pl.pjatk.demo.movie.model.Movie;
import pl.pjatk.demo.movie.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return this.movieRepository.findAll();
    }

    public Optional<Movie> getById(long id) {
        Optional<Movie> movie = this.movieRepository.findById(id);

        if (movie.isEmpty()) {
            throw new NotFoundException("Movie not found");
        }

        return movie;
    }

    public Movie addMovie(Movie movie) {
        if (movie == null) {
            throw new IncorrectDataException("Incorrect data provided!");
        }

        return this.movieRepository.save(movie);
    }

    public Movie updateMovie(long id, Movie movie) {
        Optional<Movie> movie1 = this.movieRepository.findById(id);

        if (movie1.isEmpty()) {
            throw new NotFoundException("Movie not found");
        }

        if (movie.getName() == null) {
            throw new IncorrectDataException("Incorrect data!");
        }

        return this.movieRepository.save(movie);
    }

    public void deleteMovie(long id) {
        this.movieRepository.deleteById(id);
    }

    public Movie updateIsAvailable(long id, Boolean isAvailable) {
        Optional<Movie> movie = this.movieRepository.findById(id);

        if (movie.isEmpty()) {
            throw new NotFoundException("Movie not found");
        }

        movie.get().setAvailable(isAvailable);
        return this.movieRepository.save(movie.get());
    }
}
