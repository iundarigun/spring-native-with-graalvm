CREATE TABLE person(
    id serial PRIMARY KEY,
    name  VARCHAR (150) UNIQUE NOT NULL,
    last_name VARCHAR (100),
    version integer,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);