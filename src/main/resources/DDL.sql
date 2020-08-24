drop table if exists producers cascade;
create table producers(
    id serial primary key,
    name varchar(255)
);


drop table if exists products cascade;
create table products(
    id serial primary key,
    name varchar(255),
    price int,
    producer_id int,
    foreign key (producer_id) references producers(id)
);


drop type if exists user_role;
create type user_role as enum('USER', 'ADMINISTRATOR');


drop table if exists users cascade;
create table users(
    id serial primary key,
    email varchar(255),
    password varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    user_role user_role
);