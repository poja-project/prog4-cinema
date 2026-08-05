package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomService {
  private final RoomRepository repository;
  private final RoomMapper mapper;

  public Room getById(UUID id) {
    return mapper.toModel(
        repository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Room with id " + id + " not found")));
  }

  public List<Room> getAll() {
    return mapper.toModel(repository.findAll());
  }

  public List<Room> create(List<Room> rooms) {
    return rooms.stream().map(this::create).toList();
  }

  public Room create(Room room) {
    var roomEntity = mapper.toEntity(room);
    return mapper.toModel(repository.save(roomEntity));
  }
}
