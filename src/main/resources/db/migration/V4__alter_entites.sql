ALTER TABLE questions_answers
    ADD COLUMN created_at  TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP;

ALTER TABLE tests
    ADD COLUMN created_at  TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP;