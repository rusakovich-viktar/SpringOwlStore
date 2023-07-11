-- Это дерьмо создается само даже если схемы нет, но не отображается в базе, пока не запустишь руками строчку 2
CREATE SCHEMA IF NOT EXISTS "online-store";

CREATE TABLE IF NOT EXISTS "online-store".users
(
    id                bigserial PRIMARY KEY,
    username          varchar(255)              NOT NULL UNIQUE,
    email             varchar(255)              NOT NULL UNIQUE,
    password          varchar(255)              NOT NULL,
    name              varchar(255),
    surname           varchar(255),
    gender            varchar(10),
    birthday          date,
    registration_date date DEFAULT current_date NOT NULL,
    cart_id           bigint UNIQUE,
    activation_code   varchar(255),
    active            boolean                   NOT NULL,
    role              varchar(255),
    CONSTRAINT users_role_check CHECK (role IN ('ROLE_USER', 'ROLE_ADMIN'))
);

create table "online-store".cart
(
    id      bigserial primary key,
    user_id bigint unique references "online-store".users
);

ALTER TABLE "online-store".users
    ADD CONSTRAINT fk_cart_id
        FOREIGN KEY (cart_id)
            REFERENCES "online-store".cart (id)
            ON DELETE CASCADE;


create table if not exists "online-store".categories
(
    id   bigserial primary key,
    name varchar(255)
);

CREATE TABLE if not exists "online-store".products
(
    id          bigserial primary key unique,
    name        VARCHAR(255)   NOT NULL,
    description varchar(255),
    price       NUMERIC(10, 2) NOT NULL,
    category_id bigint         NOT NULL,
    FOREIGN KEY (category_id) REFERENCES "online-store".categories (id) ON DELETE CASCADE
);

create table "online-store".card_products
(
    card_id    bigint not null
        references "online-store".cart,
    product_id bigint not null
        references "online-store".products
);

create table "online-store".orders
(
    sum     numeric(38, 2),
    date    timestamp(6),
    id      bigserial
        primary key,
    user_id bigint
        references "online-store".users
);



