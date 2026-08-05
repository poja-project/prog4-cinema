package com.example.demo.repository.model;

import com.example.demo.model.enums.Genre;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.time.Duration;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JMovie {

  @Id @GeneratedValue @UuidGenerator private UUID id;

  @Column(nullable = false)
  private String title;

  @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"))
  @Enumerated(EnumType.STRING)
  @Column(name = "genre", nullable = false)
  private List<Genre> genres;

  @Column(length = 2000)
  private String description;

  @Convert(converter = DurationSecondsConverter.class)
  @Column(nullable = false)
  private Duration duration;
}
