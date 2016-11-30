insert into user
( id, email, first_name, surname, address, password, contact_number) values
( 11, 'email11@test.com', 'first_name1', 'surname11', 'address11', '$2a$16$lTyv11iO3BhUq0sjXeLSsegRBb2RFx4B.ElmoEKNfZMwF4vD1nXj2', 'contact_number' ),
( 12, 'email12@test.com', 'first_name12', 'surname12', 'address12', '$2a$16$lTyv11iO3BhUq0sjXeLSsegRBb2RFx4B.ElmoEKNfZMwF4vD1nXj2', 'contact_number' ),
( 13, 'email13@test.com', 'first_name13', 'surname13', 'address13', 'password', 'contact_number' );

insert into user_authorities
(id, user_id, authorities) values
(1, 11, 'ROLE_ADMIN'),
(2, 12, 'ROLE_CLIENT'),
(3, 13, 'ROLE_MASTER');
 --<user_authorities user_id="1" authorities="ROLE_CLIENT"/>

 -- <user id="1" email="email@test.com" first_name="FirstName" surname="SurName" address="Address" password="qwerty1234"
 --          contact_number="ContactNumber"/>


-- <maker id="1" name="maker1"/>
insert into maker
(id, name) values
(1, 'maker1');


insert into product
(id, name, maker_id) values
(1, 'product1', 1);

insert into request
(id, client_id, type, status, product_id, paid) values
(1, 11, 'REPAIR', 'CREATED', 1, 0);

insert into request
(id, client_id, type, status, product_id, paid) values
(2, 12, 'REPAIR', 'CREATED', 1, 0);

insert into request
(id, client_id, type, status, product_id, paid) values
(3, 12, 'REPAIR', 'CREATED', 1, 0);

insert into request
(id, client_id, type, status, product_id, paid) values
(4, 12, 'REPAIR', 'CREATED', 1, 0);

insert into request
(id, client_id, type, status, product_id, paid) values
(5, 12, 'REPAIR', 'CREATED', 1, 0);

insert into request
(id, client_id, type, status, product_id, paid) values
(6, 12, 'REPAIR', 'CREATED', 1, 0);

---------------------
insert into maker
(id, name) values
(2, 'Apple');


insert into product
(id, name, maker_id) values
(2, 'MacBook Pro MD212', 2),
(3, 'MacBook Pro MD213', 2),
(4, 'MacBook Pro MD214', 2),
(5, 'MacBook Pro MD215', 2),
(6, 'MacBook Pro MC975', 2),
(7, 'MacBook Pro MC985', 2),
(8, 'MacBook Pro MGX92', 2),
(9, 'MacBook Pro MF840', 2),
(10, 'MacBook Pro MF841', 2),
(11, 'MacBook Pro MF851', 2);

insert into request
(id, client_id, type, status, product_id, paid) values
(11, 11, 'REPAIR', 'CREATED', 2, 0),
(12, 12, 'REPAIR', 'CREATED', 3, 0),
(13, 12, 'REPAIR', 'CREATED', 3, 0),
(14, 12, 'REPAIR', 'CREATED', 4, 0),
(15, 12, 'REPAIR', 'CREATED', 5, 0),
(16, 12, 'REPAIR', 'CREATED', 6, 0),
(21, 11, 'REPAIR', 'CREATED', 7, 0),
(22, 12, 'REPAIR', 'CREATED', 8, 0),
(23, 12, 'REPAIR', 'CREATED', 9, 0),
(24, 12, 'REPAIR', 'CREATED', 10, 0),
(25, 12, 'REPAIR', 'CREATED', 11, 0),
(31, 11, 'REPAIR', 'CREATED', 2, 0),
(32, 12, 'REPAIR', 'CREATED', 3, 0),
(33, 12, 'REPAIR', 'CREATED', 3, 0),
(34, 12, 'REPAIR', 'CREATED', 4, 0),
(35, 12, 'REPAIR', 'CREATED', 5, 0),
(36, 12, 'REPAIR', 'CREATED', 6, 0),
(41, 11, 'REPAIR', 'CREATED', 7, 0),
(42, 12, 'REPAIR', 'CREATED', 8, 0),
(43, 12, 'REPAIR', 'CREATED', 9, 0),
(44, 12, 'REPAIR', 'CREATED', 10, 0),
(45, 12, 'REPAIR', 'CREATED', 11, 0),
(26, 12, 'REPAIR', 'CREATED', 11, 0);
