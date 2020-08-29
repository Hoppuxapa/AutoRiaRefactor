drop type if exists user_role;
create type user_role as enum ('USER', 'ADMINISTRATOR');


drop table if exists users cascade;
create table users
(
    id         serial primary key,
    email      varchar(255),
    age        int Check (age > 0),
    username   varchar(255),
    password   varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    user_role  user_role
);