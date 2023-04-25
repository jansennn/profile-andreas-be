package com.jansen.profile.common.movie;

import com.jansen.profile.dto.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse extends BaseResponse {
    public int page;
    public List<Movie> results;
    public int total_pages;
    public int total_results;
}
