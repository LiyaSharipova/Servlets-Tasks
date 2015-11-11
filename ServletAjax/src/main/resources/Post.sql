use servlets_db;

create table Posts
(
  `id` int primary key auto_increment,
  `text` VARCHAR(500) not null,
  `date` DATETIME not null,
  `user_id` int NOT NULL,
  FOREIGN KEY (user_id) REFERENCES Users(id)
)