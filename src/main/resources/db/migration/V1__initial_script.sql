CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE ,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL UNIQUE ,
    specialty VARCHAR(50) NOT NULL,
    cefr_level VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL
);