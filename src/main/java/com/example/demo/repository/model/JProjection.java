package com.example.demo.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "projection")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JProjection {

  @Id @GeneratedValue @UuidGenerator private UUID id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "movie_id", nullable = false)
  private JMovie movie;

  @ManyToOne(optional = false)
  @JoinColumn(name = "room_id", nullable = false)
  private JRoom room;

  @Column(nullable = false)
  private Instant datetime;

  @Column(name = "seat_price", nullable = false, precision = 10, scale = 2)
  private BigDecimal seatPrice;
}
