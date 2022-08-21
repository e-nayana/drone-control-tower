DROP TABLE IF EXISTS model;

CREATE TABLE model
(
    id          VARCHAR(255) PRIMARY KEY,
    name        VARCHAR(250) NOT NULL,
    weight_limit INT DEFAULT 0,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT NULL
);