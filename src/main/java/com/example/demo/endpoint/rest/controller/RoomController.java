package com.example.demo.endpoint.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;
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
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomController {
  private final RoomService service;

  @GetMapping("/")
  public List<Room> getAllRooms() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public Room getById(@PathVariable UUID id) {
    return service.getById(id);
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public List<Room> create(@RequestBody List<Room> rooms) {
    return service.create(rooms);
  }
}
