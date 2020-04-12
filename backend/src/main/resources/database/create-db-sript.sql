CREATE TABLE users
(
    id            serial primary key,
    guid          uuid        not null,
    name          varchar(20) not null,
    surname       varchar(20),
    login         varchar(20) not null unique,
    password_hash text        not null,
    email         varchar(40) not null
);

CREATE TABLE fuels
(
    id   serial primary key,
    type varchar(10) not null,
    name varchar(10) not null
);

CREATE TABLE tariffs
(
    id      serial primary key,
    id_fuel integer references fuels (id),
    price   bigint
);

CREATE TABLE refills
(
    id             serial primary key,
    id_user        integer references users (id),
    id_tariff      integer references tariffs (id),
    date_submitted timestamp not null
);

CREATE TABLE templates
(
    id        serial primary key,
    id_user   integer references users (id),
    id_tariff integer references tariffs (id)
);
