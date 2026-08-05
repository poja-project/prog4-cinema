package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {
  private final MovieRepository repository;
  private final MovieMapper mapper;

  public Movie getById(UUID id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Movie with id " + id + " not found")));
  }

  public List<Movie> getAll() {
    return mapper.toModel(repository.findAll());
  }

  public List<Movie> create(List<Movie> movies) {
    return movies.stream().map(this::create).toList();
  }

  public Movie create(Movie movie) {
    var movieEntity = mapper.toEntity(movie);
    return mapper.toModel(repository.save(movieEntity));
  }
}
