package com.example.demo.mapper;

import com.example.demo.model.Room;
import com.example.demo.repository.model.JRoom;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

  public List<Room> toModel(List<JRoom> jRooms) {
    return jRooms.stream().map(this::toModel).toList();
  }

  public Room toModel(JRoom jRoom) {
    return Room.builder()
        .id(jRoom.getId())
        .number(jRoom.getNumber())
        .capacity(jRoom.getCapacity())
        .build();
  }

  public List<JRoom> toEntity(List<Room> rooms) {
    return rooms.stream().map(this::toEntity).toList();
  }

  public JRoom toEntity(Room room) {
    return JRoom.builder().id(room.id()).number(room.number()).capacity(room.capacity()).build();
  }
}
