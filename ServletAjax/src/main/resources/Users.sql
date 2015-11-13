USE servlets_db;
# CREATE TABLE `Users`(
#   `id` int PRIMARY KEY AUTO_INCREMENT,
#   `email` VARCHAR(100) NOT NULL,
#   `password` VARCHAR (200),
#   `gender` VARCHAR (10),
#   `subscribe` VARCHAR (10),
#   `aboutMe` VARCHAR (50),
#   `rememberMe` VARCHAR(50),
#   CONSTRAINT `UK_USERS_EMAIL` UNIQUE (id, email)
# );
ALTER TABLE users
    drop COLUMN rememberMe;
ALTER TABLE users
add rememberMe VARCHAR(200)