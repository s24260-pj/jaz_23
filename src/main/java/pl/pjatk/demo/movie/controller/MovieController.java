package pl.pjatk.demo.movie.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all movies")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Movie.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found movies.",
                    content = @Content
            )
    })
    @GetMapping()
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Movie.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found movie.",
                    content = @Content
            )
    })
    @Operation(summary = "Get by id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.internalServerError().build();
//        return ResponseEntity.ok(movieService.getById(id));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Movie.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found movie.",
                    content = @Content
            )
    })
    @Operation(summary = "Add movie")
    @PostMapping("/add")
    public ResponseEntity<Movie> add(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found movie.",
                    content = @Content
            )
    })
    @Operation(summary = "Update movie")
    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable(value = "id") int id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found movie.",
                    content = @Content
            )
    })
    @Operation(summary = "Delete movie")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(204).build();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found movie.",
                    content = @Content
            )
    })
    @Operation(summary = "Change movie available")
    @PutMapping("/update_is_available/{id}")
    public ResponseEntity<Movie> update_is_available(@PathVariable(value = "id") int id, @RequestBody Boolean isAvailable) {
        return ResponseEntity.ok(movieService.updateIsAvailable(id, isAvailable));
    }
}
