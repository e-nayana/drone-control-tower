DROP TABLE IF EXISTS model;
DROP TABLE IF EXISTS drone;
DROP TABLE IF EXISTS medication;

CREATE TABLE model
(
    id          VARCHAR(255) PRIMARY KEY,
    name        VARCHAR(25) UNIQUE,
    weight_limit INT DEFAULT 0,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE fleet
(
    id          VARCHAR(255) PRIMARY KEY,
    name VARCHAR(100) UNIQUE ,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE drone
(
    id          VARCHAR(255) PRIMARY KEY,
    model_id        VARCHAR(250) NOT NULL,
    fleet_id        VARCHAR(250) NOT NULL,
    serial_number        VARCHAR(250) NOT NULL,
    state        VARCHAR(250) NOT NULL,
    battery_capacity INT DEFAULT 0,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE medication
(
    id          VARCHAR(255) PRIMARY KEY,
    drone_id        VARCHAR(250) NOT NULL,
    name        VARCHAR(250) NOT NULL,
    code VARCHAR(250) NOT NULL,
    image_url        VARCHAR(250) NOT NULL,
    weight INT DEFAULT 0,
    is_active BOOLEAN default true,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE drone
    ADD FOREIGN KEY (model_id)
        REFERENCES model(id);
ALTER TABLE drone
    ADD FOREIGN KEY (fleet_id)
        REFERENCES fleet(id);
ALTER TABLE medication
    ADD FOREIGN KEY (drone_id)
        REFERENCES drone(id);