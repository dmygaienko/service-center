create table user
(
    id int NOT NULL PRIMARY KEY,
    email varchar(255),
    first_name varchar(255),
    surname varchar(255),
    address varchar(255),
    password varchar(255),
    contact_number varchar(255)
);

create table user_authorities
(
    id int NOT NULL PRIMARY KEY,
    user_id int,
    authorities varchar(255),
    FOREIGN KEY (user_id) REFERENCES user(id)
);