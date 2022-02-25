CREATE TABLE IF NOT EXISTS team (id SERIAL PRIMARY KEY,
name VARCHAR(255),
city VARCHAR(255),
owner VARCHAR(255),
stadium_capacity VARCHAR(255),
tier VARCHAR(255),
competition VARCHAR(255),
player_number INT,
creation_date DATE);