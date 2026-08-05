package com.example.demo.endpoint.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
  private final MovieService service;

  @GetMapping("/")
  public List<Movie> getAllMovies() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public Movie getById(@PathVariable UUID id) {
    return service.getById(id);
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public List<Movie> create(@RequestBody List<Movie> movies) {
    return service.create(movies);
  }
}
