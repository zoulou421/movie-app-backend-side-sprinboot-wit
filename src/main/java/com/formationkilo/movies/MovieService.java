package com.formationkilo.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private  MovieRepository movieRepository;
    public List<Movie> allMovies(){
      return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(ObjectId id){
       return movieRepository.findById(id);
    }
    //you don't 've to expose your id object
    public Optional<Movie> singleMovieImdbId(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }
}
