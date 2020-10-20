DROP TABLE IF EXISTS planet;
DROP TABLE IF EXISTS weather;

CREATE TABLE planet (
  id BIGINT IDENTITY PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  translation_moviment VARCHAR(100) NOT NULL,
  velocity INTEGER NOT NULL,
  distance_from_sun INTEGER NOT NULL,
  position_x DOUBLE NOT NULL,
  position_y DOUBLE NOT NULL
);

CREATE TABLE weather (
  id BIGINT IDENTITY PRIMARY KEY,
  day INTEGER NOT NULL,
  weather VARCHAR(100) NOT NULL
);

INSERT INTO planet (name, translation_moviment, velocity, distance_from_sun, position_x, position_y)
VALUES ('Ferengi', 'CLOCKWISE', 1, 500, 500.0, 0.0),
       ('Betasoide', 'CLOCKWISE', 3, 2000, 2000.0, 0.0),
       ('Vulcano', 'ANTICLOCKWISE', 5, 1000, 1000.0, 0.0);