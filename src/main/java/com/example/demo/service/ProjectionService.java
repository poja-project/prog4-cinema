package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.ProjectionMapper;
import com.example.demo.model.Projection;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ProjectionRepository;
import com.example.demo.repository.RoomRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectionService {
  private final ProjectionRepository repository;
  private final MovieRepository movieRepository;
  private final RoomRepository roomRepository;
  private final ProjectionMapper mapper;

  public Projection getById(UUID id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Projection with id " + id + " not found")));
  }

  public List<Projection> getAll() {
    return mapper.toModel(repository.findAll());
  }

  public List<Projection> create(List<Projection> projections) {
    return projections.stream().map(this::create).toList();
  }

  public Projection create(Projection projection) {
    var movie =
        movieRepository
            .findById(projection.movieId())
            .orElseThrow(
                () ->
                    new NotFoundException("Movie with id " + projection.movieId() + " not found"));
    var room =
        roomRepository
            .findById(projection.roomId())
            .orElseThrow(
                () -> new NotFoundException("Room with id " + projection.roomId() + " not found"));

    var projectionEntity = mapper.toEntity(projection, movie, room);
    return mapper.toModel(repository.save(projectionEntity));
  }
}
