-- Это дерьмо создается само даже если схемы нет, но не отображается в базе, пока не запустишь руками строчку 2
CREATE SCHEMA IF NOT EXISTS "online-store";

create table if not exists "online-store".categories
(
    id         integer primary key generated always as identity,
    name       text,
    image_path text
);

CREATE TABLE if not exists "online-store".users
(
    id                integer generated always as identity primary key ,
    username          varchar(20) not null unique,
    password          text        not null,
    name              varchar(30),
    surname           varchar(30),
    birthday          date,
    gender            varchar(10),
    email             text        not null unique,
    registration_date date        NOT NULL DEFAULT now()
);

CREATE TABLE if not exists "online-store".products
(
    id          integer primary key generated always as identity unique,
    image_path  VARCHAR(255),
    name        VARCHAR(255)   NOT NULL,
    description TEXT,
    price       NUMERIC(10, 2) NOT NULL,
    category_id INTEGER        NOT NULL,
    FOREIGN KEY (category_id) REFERENCES "online-store".categories (id) ON DELETE CASCADE
);
