package com.ganesh.resources;


import com.ganesh.bean.MovieAndRating;
import com.ganesh.bean.MoviesAndRatingsList;
import com.ganesh.bean.Rating;
import com.ganesh.service.MovieService;
import com.ganesh.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/catalogs")
public class CatalogResource {

    private RatingService ratingService;
    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    @GetMapping(path = "/{id}", produces = "Application/json")
    MoviesAndRatingsList getMoviesWithRatingsByUserController(@PathVariable("id") int id) {
        List<Rating> ratingsByUser = ratingService.getRatingByUserId(id);
        List<MovieAndRating> moviesAndRatings= new ArrayList<>();
        for (Rating rating: ratingsByUser) {
            moviesAndRatings.add(
                    new MovieAndRating(
                            rating.getId(),
                            rating.getUserId(),
                            rating.getMovieId(),
                            movieService.getMovieById(rating.getMovieId()).getName(),
                            rating.getRating()));
        }
        return new MoviesAndRatingsList(moviesAndRatings);
    }


}