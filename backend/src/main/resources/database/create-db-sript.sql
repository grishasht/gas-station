CREATE TABLE users
(
    id            serial primary key,
    guid          uuid        not null unique,
    name          varchar(20) not null,
    surname       varchar(20),
    login         varchar(20) not null unique,
    password_hash text        not null,
    email         varchar(40) not null,
    city          varchar(20)
);

CREATE TABLE pumps
(
    id           serial primary key,
    id_local     integer     not null,
    city         varchar(20) not null,
    name_station varchar(30) not null
);

CREATE TABLE fuels
(
    id      serial primary key,
    id_pump integer references pumps (id),
    type    varchar(10) not null,
    name    varchar(10) not null,
    price   float       not null
);

CREATE TABLE refills
(
    id             serial primary key,
    user_guid      uuid        not null,
    id_fuel        integer references fuels (id),
    city           varchar(20) not null,
    name_station   varchar(20) not null,
    date_submitted timestamp   not null,
    volume         float       not null,
    final_price    float       not null
);

CREATE TABLE templates
(
    id        serial primary key,
    user_guid uuid        not null,
    id_fuel   integer references fuels (id),
    name      varchar(20) not null
);
