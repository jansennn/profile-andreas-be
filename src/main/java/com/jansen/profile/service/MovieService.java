package com.jansen.profile.service;

import com.jansen.profile.common.movie.MovieResponse;
import com.jansen.profile.dto.Movie;
import com.jansen.profile.dto.tmdb.MovieTmdbResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Autowired
    public RestTemplate restTemplate;

    @Cacheable("ratedMovies")
    public MovieResponse getRatedMovies(){
        MovieResponse movieResponse = new MovieResponse();
        try{
            MovieTmdbResponse movie = restTemplate.getForObject("https://api.themoviedb.org/3/account/9580281/rated/movies?api_key=48b19fa347dc7903d55fda57baa56c09&session_id=e873686f5cd4d5102495442474dccfc4c013f211", MovieTmdbResponse.class);

            movieResponse.setPage(movie.getPage());
            movieResponse.setResults(movie.getResults());
            movieResponse.setTotal_pages(movie.getTotal_pages());
            movieResponse.setTotal_results(movie.getTotal_results());

            System.out.println("log_movie : "+ movie.getTotal_pages());

            movieResponse.setSuccess(true);
        } catch (Exception e){
            movieResponse.setSuccess(false);
        }

        return movieResponse;
    }

}
