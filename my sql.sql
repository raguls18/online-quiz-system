CREATE DATABASE quiz_system;

USE quiz_system;

-- Table to store quiz questions and options
CREATE TABLE questions (
    question_id INT AUTO_INCREMENT PRIMARY KEY,
    question TEXT,
    option_a TEXT,
    option_b TEXT,
    option_c TEXT,
    option_d TEXT,
    correct_option CHAR(1)
);
INSERT INTO questions (question, option_a, option_b, option_c, option_d, correct_option)
VALUES
("What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "C"),
("Which planet is known as the Red Planet?", "Earth", "Mars", "Venus", "Jupiter", "B"),
("Who wrote the play 'Romeo and Juliet'?", "Charles Dickens", "Jane Austen", "William Shakespeare", "Mark Twain", "C"),
("What is the largest ocean on Earth?", "Atlantic Ocean", "Indian Ocean", "Southern Ocean", "Pacific Ocean", "D"),
("Who painted the Mona Lisa?", "Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet", "C");


-- Table to store user scores
CREATE TABLE user_scores (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255),
    score INT
);
