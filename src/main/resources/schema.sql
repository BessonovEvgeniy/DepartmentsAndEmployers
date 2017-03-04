CREATE TABLE departments (id SERIAL PRIMARY KEY, name VARCHAR(30) NOT NULL UNIQUE);

CREATE TABLE employers (id SERIAL PRIMARY KEY, department_id INT REFERENCES departments(id), name VARCHAR(20), email VARCHAR(20) NOT NULL UNIQUE, birthday DATE, phone INT);