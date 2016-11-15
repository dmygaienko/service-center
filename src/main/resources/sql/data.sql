insert into user
values (    11, 'email11@test.com', 'first_name1', 'surname11', 'address11', 'password', 'contact_number'   ),
values (    12, 'email12@test.com', 'first_name12', 'surname12', 'address12', 'password', 'contact_number'   ),
values (    13, 'email13@test.com', 'first_name13', 'surname13', 'address13', 'password', 'contact_number'   );


insert into user_authorities
values (
    11, 'ROLE_ADMIN'
);
 --<user_authorities user_id="1" authorities="ROLE_CLIENT"/>

 -- <user id="1" email="email@test.com" first_name="FirstName" surname="SurName" address="Address" password="qwerty1234"
 --          contact_number="ContactNumber"/>