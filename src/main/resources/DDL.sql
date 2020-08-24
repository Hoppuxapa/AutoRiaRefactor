drop type if exists role;
create type role as enum ('USER', 'ADMINISTRATOR');

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id            serial,
    user_name     VARCHAR (100),
    first_name    VARCHAR(100) NOT NULL,
    last_name     VARCHAR(100),
    age           int CHECK (age > 0),
    login         VARCHAR(20)  NOT NULL,
    email         VARCHAR(100) NOT NULL,
    password      VARCHAR(60)  NOT NULL,
    register_time date,
    user_status   VARCHAR(25),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(
    id        serial,
    user_id   bigint,
    user_role role,
    CONSTRAINT user_role_pkey PRIMARY KEY (id),
    CONSTRAINT user_fk
        FOREIGN KEY (user_id)
            REFERENCES users (id)
);

