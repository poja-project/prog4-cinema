package com.example.demo.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Projection(
    UUID id, UUID movieId, UUID roomId, Instant datetime, BigDecimal seatPrice) {}
