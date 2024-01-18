CREATE TABLE users
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    username   VARCHAR(128),
    password   VARCHAR(128)                              NOT NULL,
    is_enabled CHAR(1) CHECK (is_enabled IN ('Y', 'N') ) NOT NULL
);