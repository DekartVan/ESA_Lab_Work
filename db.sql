CREATE TABLE directors (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL,
  birthdate DATE NOT NULL
);


CREATE TABLE movies (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  director_id INTEGER REFERENCES directors(id),
  year INTEGER NOT NULL,
  rating INTEGER NOT NULL
);