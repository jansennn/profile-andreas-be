package com.jansen.profile.dto.tmdb;

import com.jansen.profile.dto.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieTmdbResponse {
    private int page;
    private List<Movie> results;
    private int total_pages;
    private int total_results;

}
