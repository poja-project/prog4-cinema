package com.example.demo.endpoint.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.example.demo.model.Projection;
import com.example.demo.service.ProjectionService;
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
@RequestMapping("/projections")
@AllArgsConstructor
public class ProjectionController {
  private final ProjectionService service;

  @GetMapping("/")
  public List<Projection> getAllProjections() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public Projection getById(@PathVariable UUID id) {
    return service.getById(id);
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public List<Projection> create(@RequestBody List<Projection> projections) {
    return service.create(projections);
  }
}
