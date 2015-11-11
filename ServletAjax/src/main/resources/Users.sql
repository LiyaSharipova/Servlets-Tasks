USE servlets_db;
CREATE TABLE `Users`(
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR (200),
  `gender` VARCHAR (10),
  `subscribe` VARCHAR (10),
  `aboutMe` VARCHAR (50)
);
