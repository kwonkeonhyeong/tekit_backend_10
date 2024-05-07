CREATE DATABASE liondb;

SHOW DATABASES ;


CREATE USER 'lion'@'localhost' IDENTIFIED BY 'like';
CREATE USER 'lion'@'%' IDENTIFIED BY 'like';

GRANT ALL PRIVILEGES ON liondb.* TO 'lion'@'%';
GRANT ALL PRIVILEGES ON liondb.* TO 'lion'@'localhost';

FLUSH PRIVILEGES;

CREATE TABLE user(
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE NOT NULL ,
    name VARCHAR(50) NOT NULL ,
    password VARCHAR(500) NOT NULL ,
    regdate TIMESTAMP DEFAULT NOW()
);

CREATE TABLE role (
    role_id INT PRIMARY KEY ,
    name VARCHAR(20)
);

CREATE TABLE user_role (
    user_id INT,
    role_id INT,
    primary key(user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

CREATE TABLE board (
    board_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    content TEXT NULL,
    user_id INT NOT NULL,
    regdate TIMESTAMP DEFAULT NOW(),
    view_cnt INT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

DESC user;
DESC role;
DESC user_role;
DESC board;

INSERT INTO ROLE(role_id, name) values (1, 'ROLE_USER');
INSERT INTO ROLE(role_id, name) values (2, 'ROLE_ADMIN');

SELECT * FROM role;

INSERT INTO user values (null,'rjsgud1956@gmail.com','권뭉치','1234',default);
INSERT INTO user values (null,'ninido@gmail.com','나미리','1234',default);
SELECT * FROM user;

UPDATE user SET name='나뭉치' WHERE email = 'ninido@gmail.com';
SELECT * FROM user;

DELETE FROM user WHERE name='나뭉치';
SELECT * FROM user;
