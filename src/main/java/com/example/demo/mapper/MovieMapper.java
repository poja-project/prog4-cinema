package com.example.demo.mapper;

import com.example.demo.model.Movie;
import com.example.demo.repository.model.JMovie;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

  public List<Movie> toModel(List<JMovie> jMovies) {
    return jMovies.stream().map(this::toModel).toList();
  }

  public Movie toModel(JMovie jMovie) {
    return Movie.builder()
        .id(jMovie.getId())
        .title(jMovie.getTitle())
        .genres(jMovie.getGenres())
        .description(jMovie.getDescription())
        .duration(jMovie.getDuration())
        .build();
  }

  public List<JMovie> toEntity(List<Movie> movies) {
    return movies.stream().map(this::toEntity).toList();
  }

  public JMovie toEntity(Movie movie) {
    return JMovie.builder()
        .id(movie.id())
        .title(movie.title())
        .genres(movie.genres())
        .description(movie.description())
        .duration(movie.duration())
        .build();
  }
}
