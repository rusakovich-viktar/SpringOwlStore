create table "online-store".order_products
(
    order_id   bigint not null
        constraint order_products_orders_null_fk
            references "online-store".orders
            on update cascade on delete cascade,
    product_id bigint not null
        constraint order_products_products_null_fk
            references "online-store".products
            on update cascade on delete cascade
);

alter table "online-store".cart
    add constraint fkg5uhi8vpsuy0lgloxk2h4w5o6
        foreign key (user_id) references "online-store".users
            on update cascade on delete cascade;

alter table "online-store".cart
    drop constraint fkg5uhi8vpsuy0lgloxk2h4w5o6;

alter table "online-store".cart
    add constraint fkg5uhi8vpsuy0lgloxk2h4w5o6
        foreign key (user_id) references "online-store".users
            on update cascade on delete cascade;