CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL UNIQUE ,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE ,
    phone_number VARCHAR(255) NOT NULL UNIQUE ,
    specialty VARCHAR(50) NOT NULL
);