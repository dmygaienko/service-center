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
    authorities varchar(255),
    user_id int,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

--<maker id="1" name="maker1"/>
create table maker
(
    id int NOT NULL PRIMARY KEY,
    name varchar(255)
);

--<product id="1" name="product1" maker_id="1"/>
create table product
(
    id int NOT NULL PRIMARY KEY,
    name varchar(255),
    maker_id int,
    FOREIGN KEY (maker_id) REFERENCES maker(id)
);

--<request id="2" client_id="2" type="REPAIR" status="CREATED" product_id="1" paid="0" date="2008-08-08 20:08:08"/>
create table request
(
    id int NOT NULL PRIMARY KEY,
    type varchar(255),
    status varchar(255),
    product_id int,
    paid int,
    price int,
    datetime timestamp,
    client_id int,
    FOREIGN KEY (client_id) REFERENCES user(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

--<request id="2" client_id="2" type="REPAIR" status="CREATED" product_id="1" paid="0" date="2008-08-08 20:08:08"/>
create table component
(
    id int NOT NULL PRIMARY KEY,
    name varchar(255),
    price int,
    status varchar(255),
    request_id int,
    product_id int,
    FOREIGN KEY (request_id) REFERENCES request(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

create table manual
(
    id int NOT NULL PRIMARY KEY,
    content blob,
    name varchar(255),
    product_id int,
    FOREIGN KEY (product_id) REFERENCES product(id)
);

create table image
(
    id int NOT NULL PRIMARY KEY,
    content blob,
    created timestamp,
    description varchar(255),
    request_id int,
    FOREIGN KEY (request_id) REFERENCES request(id)
);

create table comment
(
    id int NOT NULL PRIMARY KEY,
    content varchar(255),
    user_id int,
    request_id int,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (request_id) REFERENCES request(id)
);