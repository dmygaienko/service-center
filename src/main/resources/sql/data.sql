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
