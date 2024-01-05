package com.formationkilo.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin("*")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping
    public ResponseEntity<Review>createView(@RequestBody Map<String,String>payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    }
}
