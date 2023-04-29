package com.jansen.profile.controller;

import com.jansen.profile.common.movie.MovieResponse;
import com.jansen.profile.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @CrossOrigin()
    @GetMapping("/rated")
    public MovieResponse getRatedMovies(){
        return movieService.getRatedMovies();
    }
}
