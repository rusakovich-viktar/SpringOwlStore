create table cart
(
    id      bigserial
        primary key,
    user_id bigint
        unique
);

alter table cart
    owner to postgres;

create table categories
(
    id         bigserial
        primary key,
    image_path varchar(255),
    name       varchar(255)
);

alter table categories
    owner to postgres;

create table products
(
    price       numeric(38, 2),
    category_id bigint
        constraint fkog2rp4qthbtt2lfyhfo32lsw9
            references categories,
    id          bigserial
        primary key,
    description varchar(255),
    image_path  varchar(255),
    name        varchar(255)
);

alter table products
    owner to postgres;

create table card_products
(
    card_id    bigint not null
        constraint fk9iaqaqykpr2so76sbfe78t54w
            references cart,
    product_id bigint not null
        constraint fkmj307lib307lc6juj1jrao9mx
            references products
);

alter table card_products
    owner to postgres;

create table users
(
    registration_date date,
    cart_id           bigint
        unique
        constraint fkqmifheg6lnigfifvlmpjnuny8
            references cart,
    id                bigserial
        primary key,
    birthday          varchar(255),
    email             varchar(255),
    gender            varchar(255),
    name              varchar(255),
    password          varchar(255),
    surname           varchar(255),
    username          varchar(255)
);

alter table users
    owner to postgres;

alter table cart
    add constraint fkg5uhi8vpsuy0lgloxk2h4w5o6
        foreign key (user_id) references users;

create table orders
(
    sum     numeric(38, 2),
    date    timestamp(6),
    id      bigserial
        primary key,
    user_id bigint
        constraint fk32ql8ubntj5uh44ph9659tiih
            references users
);

alter table orders
    owner to postgres;

