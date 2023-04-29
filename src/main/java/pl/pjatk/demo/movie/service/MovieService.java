package pl.pjatk.demo.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.demo.movie.exceptions.IncorrectDataException;
import pl.pjatk.demo.movie.exceptions.NotFoundException;
import pl.pjatk.demo.movie.model.Movie;

import java.util.List;

@Service
public class MovieService {
    public List<Movie> getAll() {
        return List.of();
    }

    public Movie getById(int id) {
        Movie movie = null;

        if (movie == null) {
            throw new NotFoundException("Movie not found");
        }

        return movie;
    }

    public Movie addMovie(Movie movie) {
        if (movie == null) {
            throw new IncorrectDataException("Incorrect data provided!");
        }

        return movie;
    }

    public Movie updateMovie(int id, Movie movie) {
//        Movie movie1 = this.getById(id);

        if (movie.getName() == null) {
            throw new IncorrectDataException("Incorrect data!");
        }

        return movie;
    }

    public void deleteMovie(int id) {
        //        Movie movie1 = this.getById(id);
    }
}
