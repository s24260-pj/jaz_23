package pl.pjatk.demo.movie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.demo.movie.model.Movie;
import pl.pjatk.demo.movie.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(movieService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> add(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable(value = "id") int id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/update_is_available/{id}")
    public ResponseEntity<Movie> update_is_available(@PathVariable(value = "id") int id, @RequestBody Boolean isAvailable) {
        return ResponseEntity.ok(movieService.updateIsAvailable(id, isAvailable));
    }
}
