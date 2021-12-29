--CREATE TABLE USERS(
--    id int not null PRIMARY KEY ,
--    username varchar(45) not null,
--    password varchar(64) not null,
--    enabled boolean not null,
--    role varchar(45) not null
--);
--
--CREATE TABLE ITEMS(
--    id int PRIMARY KEY,
--    name varchar(128),
--    price int
--);

--CREATE TABLE USERS(
--    id int not null PRIMARY KEY ,
--    username varchar(45) not null,
--    password varchar(64) not null,
--    enabled boolean not null,
--    role varchar(45) not null
--);
--
--CREATE TABLE ITEMS(
--    id int PRIMARY KEY,
--    name varchar(128),
--    price int
--);

--INSERT INTO USERS(id, username, password, enabled, role) VALUES (1, 'nirish', 'test', true, 'ROLE_ADMIN');
--INSERT INTO USERS(id, username, password, enabled, role) VALUES (2, 'sai', 'test', true, 'ROLE_USER');
--INSERT INTO USERS(id, username, password, enabled, role) VALUES (3, 'test', 'test', true, 'ROLE_USER');
--INSERT INTO USERS(id, username, password, enabled, role)VALUES (4, 'admin', 'admin', true, 'ROLE_ADMIN');
--INSERT INTO USERS(id, username, password, enabled, role) VALUES (5, 'sia', 'test', true, 'ROLE_ADMIN');
--INSERT INTO USERS(id, username, password, enabled, role) VALUES (6, 'john', 'test', true, 'ROLE_USER');
--INSERT INTO USERS(id, username, password, enabled, role) VALUES (7, 'june', 'test', true, 'ROLE_USER');
--INSERT INTO USERS(id, username, password, enabled, role)VALUES (8, 'joe', 'admin', true, 'ROLE_ADMIN');


INSERT INTO ORDERS(id, booking_date,  payment_mode,  items, feedback_comments , rating,   payment_status) VALUES (1, '2021-08-18', 'CASH', null, 'boo', 5, false);



