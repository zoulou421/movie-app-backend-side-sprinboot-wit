package com.formationkilo.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    private MovieService movieService;
    //1)
    @GetMapping("/v2")
    public String allMovies1() {
        return "All Movies";
    }
    //2)
    @GetMapping("/v3")
    public ResponseEntity<String> allMovies2() {

        return new ResponseEntity<String>("All Movies", HttpStatus.OK);
    }

    //3)
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {

        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
    //4)
    @GetMapping("/{id}/v4")
    public ResponseEntity<Optional<Movie>> getSingleMovie1(@PathVariable ObjectId id) {
        //you don't 've to expose your id Object , see number 5)
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }
    //5)
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        //you don't have to expose your id Object
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieImdbId(imdbId), HttpStatus.OK);
    }
}
