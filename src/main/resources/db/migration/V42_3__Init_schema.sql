CREATE TABLE room (
                      id UUID PRIMARY KEY,
                      number VARCHAR(50) NOT NULL,
                      capacity INTEGER NOT NULL,
                      CONSTRAINT uq_room_number UNIQUE (number)
);

CREATE TABLE movie (
                       id UUID PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description VARCHAR(2000),
                       duration BIGINT NOT NULL
);

CREATE TABLE movie_genre (
                             movie_id UUID NOT NULL REFERENCES movie(id) ON DELETE CASCADE,
                             genreVARCHAR(20) NOT NULL,
                             CONSTRAINT pk_movie_genre PRIMARY KEY (movie_id, genre),
                             CONSTRAINT chk_movie_genre CHECK (genre IN (
                                                                         'THRILLER', 'ROMANCE', 'COMEDY', 'DRAMA',
                                                                         'ACTION', 'SCI_FI', 'FANTASY', 'ANIMATION'
                                 ))
);

CREATE TABLE projection (
                            id         UUID          PRIMARY KEY,
                            movie_id   UUID          NOT NULL REFERENCES movie(id) ON DELETE CASCADE,
                            room_id    UUID          NOT NULL REFERENCES room(id) ON DELETE CASCADE,
                            datetime   TIMESTAMPTZ   NOT NULL,
                            seat_price NUMERIC(10,2) NOT NULL CHECK (seat_price >= 0)
);

CREATE INDEX idx_projection_movie ON projection(movie_id);
CREATE INDEX idx_projection_room ON projection(room_id);
