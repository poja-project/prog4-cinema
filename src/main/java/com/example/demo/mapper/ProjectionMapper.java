package com.example.demo.mapper;

import com.example.demo.model.Projection;
import com.example.demo.repository.model.JMovie;
import com.example.demo.repository.model.JProjection;
import com.example.demo.repository.model.JRoom;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProjectionMapper {

  public List<Projection> toModel(List<JProjection> jProjections) {
    return jProjections.stream().map(this::toModel).toList();
  }

  public Projection toModel(JProjection jProjection) {
    return Projection.builder()
        .id(jProjection.getId())
        .movieId(jProjection.getMovie().getId())
        .roomId(jProjection.getRoom().getId())
        .datetime(jProjection.getDatetime())
        .seatPrice(jProjection.getSeatPrice())
        .build();
  }

  public JProjection toEntity(Projection projection, JMovie movie, JRoom room) {
    return JProjection.builder()
        .id(projection.id())
        .movie(movie)
        .room(room)
        .datetime(projection.datetime())
        .seatPrice(projection.seatPrice())
        .build();
  }
}
