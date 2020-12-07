create table m_users
(
    id         bigserial                                                  not null
        constraint m_users_pk
            primary key,
    username   varchar(200)  default 'DEFAULT_NAME'::character varying    not null,
    surname    varchar(1000) default 'DEFAULT_SURNAME'::character varying not null,
    birth_date date,
    login      varchar(100)                                               not null,
    password   varchar(1000) default '123'::character varying             not null,
    created    timestamp(6),
    changed    timestamp(6),
    is_blocked boolean       default false                                not null,
    weight     double precision,
    gender     varchar(50)   default 'NOT_SELECTED'::character varying    not null
);

alter table m_users
    owner to testuser;

create unique index m_users_login_uindex
    on m_users (login);

create table m_roles
(
    id        bigserial   not null
        constraint m_roles_pk
            primary key,
    role_name varchar(50) not null,
    user_id   bigint      not null
        constraint m_roles_m_users_id_fk
            references m_users
            on update cascade on delete cascade
);

alter table m_roles
    owner to testuser;

create index m_roles_role_name_index
    on m_roles (role_name);

create index m_roles_user_id_index
    on m_roles (user_id desc);

create unique index m_roles_role_name_user_id_uindex
    on m_roles (role_name, user_id);

create table m_auto_dealer
(
    id                 bigserial         not null
        constraint m_auto_dealer_pk
            primary key,
    name               varchar(100)      not null,
    address            varchar(1000)     not null,
    capacity           integer default 3 not null,
    created            timestamp(6)      not null,
    changed            timestamp(6)      not null,
    year_of_foundation date              not null
);

alter table m_auto_dealer
    owner to testuser;

create table m_cars
(
    id                        bigserial        not null
        constraint m_cars_pk
            primary key,
    model                     varchar(100)     not null,
    guarantee_expiration_date timestamp(6)     not null,
    price                     double precision not null,
    dealer_id                 bigint           not null
        constraint m_cars_m_auto_dealer_id_fk
            references m_auto_dealer
            on update cascade on delete cascade,
    user_id                   bigint
        constraint m_cars_m_users_id_fk
            references m_users
            on update cascade on delete set null
);

alter table m_cars
    owner to testuser;

create table m_body
(
    id      bigserial                                       not null
        constraint m_body_pk
            primary key,
    color   varchar(100) default 'BLACK'::character varying not null,
    vin     varchar(200)                                    not null,
    type    varchar(100)                                    not null,
    created timestamp(6)                                    not null,
    changed timestamp(6)                                    not null,
    car_id  bigint                                          not null
        constraint m_body_m_cars_id_fk
            references m_cars
            on update cascade on delete cascade
);

alter table m_body
    owner to testuser;

create unique index m_body_vin_uindex
    on m_body (vin);

create table m_transmission
(
    id      bigserial        not null
        constraint m_transmission_pk
            primary key,
    type    varchar(100)     not null,
    gears   integer          not null,
    weight  double precision not null,
    created timestamp(6)     not null,
    changed timestamp(6)     not null,
    car_id  bigint           not null
        constraint m_transmission_m_cars_id_fk
            references m_cars
            on update cascade on delete cascade
);

alter table m_transmission
    owner to testuser;

create index m_transmission_changed_index
    on m_transmission (changed desc);

create index m_transmission_created_index
    on m_transmission (created desc);

create index m_transmission_type_index
    on m_transmission (type);

create index m_transmission_weight_index
    on m_transmission (weight desc);

create table m_engine
(
    id            bigserial                                        not null
        constraint m_engine_pk
            primary key,
    volume        double precision                                 not null,
    cylinder      integer                                          not null,
    batch         varchar(100)                                     not null,
    fuel_type     varchar(100) default 'PETROL'::character varying not null,
    car_id        bigint                                           not null
        constraint m_engine_m_cars_id_fk
            references m_cars
            on update cascade on delete cascade,
    is_deprecated boolean      default false                       not null
);

alter table m_engine
    owner to testuser;

create index m_engine_type_index
    on m_engine (fuel_type);

create index m_engine_volume_index
    on m_engine (volume desc);

create index m_cars_model_index
    on m_cars (model);

create index m_auto_dealer_address_index
    on m_auto_dealer (address);

create index m_auto_dealer_name_index
    on m_auto_dealer (name);

create table m_good
(
    id        bigserial    not null
        constraint m_good_pk
            primary key,
    good_name varchar(100) not null
);

alter table m_good
    owner to testuser;

create table l_user_goods
(
    id      bigserial    not null
        constraint l_user_goods_pk
            primary key,
    user_id integer      not null
        constraint l_user_goods_m_users_id_fk
            references m_users
            on update cascade on delete cascade,
    good_id integer      not null
        constraint l_user_goods_m_good_id_fk
            references m_good,
    count   integer      not null,
    created timestamp(6) not null,
    changed timestamp(6) not null
);

alter table l_user_goods
    owner to testuser;

create index l_user_goods_count_index
    on l_user_goods (count desc);

create index l_user_goods_created_index
    on l_user_goods (created desc);

