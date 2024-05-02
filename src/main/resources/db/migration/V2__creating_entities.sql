CREATE TABLE subjects(
        id SERIAL PRIMARY KEY,
        name_of_subject VARCHAR,
        created_at  TIMESTAMP,
        updated_at TIMESTAMP
);

CREATE TABLE questions_answers(
    id SERIAL PRIMARY KEY,
    question VARCHAR[],
    answer VARCHAR,
    subject_id INTEGER,
    FOREIGN KEY (subject_id) REFERENCES subjects(id)

);

CREATE TABLE tests(
    id SERIAL PRIMARY KEY,
    name_of_test VARCHAR
);