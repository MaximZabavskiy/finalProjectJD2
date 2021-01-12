create table m_users
(
    id  bigserial not null
        constraint m_users_pkey
            primary key,
    name varchar(100) not null,
    surname varchar(100) not null,
    login varchar(100) not null,
    password varchar(100) not null,
    email varchar(100) not null,
    gender varchar(20) default 'NOT_SELECTED'::character varying not null,
    birth_date date,
    height double precision default 170 not null,
    weight double precision default 65 not null,
    fitness_level varchar(20) default 'NOT_SELECTED'::character varying not null,
    goal varchar(20) default 'NOT_SELECTED'::character varying not null,
    max_pullups bigint default 0 not null,
    max_pushups bigint default 0 not null,
    max_squats bigint default 0 not null,
    max_dips bigint default 0 not null,
    photo_link varchar(200),
    created timestamp(6) default CURRENT_TIMESTAMP not null,
    changed timestamp(6) default CURRENT_TIMESTAMP not null,
    is_blocked boolean default false not null
);

alter table m_users owner to maxim;

create table m_programs
(
    id bigserial not null
        constraint m_programs_pk
            primary key,
    user_id bigint not null
        constraint m_programs_m_users_id_fk
            references m_users,
    name varchar(20) default 'NOT_SELECTED'::character varying not null,
    difficulty varchar(20) default 'NOT_SELECTED'::character varying not null,
    duration varchar(20) default 'NOT_SELECTED'::character varying not null,
    type varchar(20) default 'NOT_SELECTED'::character varying not null,
    created timestamp(6) default CURRENT_TIMESTAMP not null,
    changed timestamp(6) default CURRENT_TIMESTAMP not null,
    is_blocked boolean default false not null
);

alter table m_programs owner to maxim;

create table m_equipment
(
    id bigserial not null
        constraint m_equipment_pk
            primary key,
    clothes varchar(20) default 'NOT_SELECTED'::character varying not null,
    shoes varchar(20) default 'NOT_SELECTED'::character varying not null,
    beverage varchar(20) default 'NOT_SELECTED'::character varying not null,
    cleanser varchar(20) default 'NOT_SELECTED'::character varying not null,
    created timestamp(6) default CURRENT_TIMESTAMP not null,
    changed timestamp(6) default CURRENT_TIMESTAMP not null,
    is_blocked boolean default false not null
);

alter table m_equipment owner to maxim;

create table m_workouts
(
    id bigserial not null
        constraint m_workouts_pk
            primary key,
    program_id bigserial not null
        constraint m_workouts_m_programs_id_fk
            references m_programs,
    user_id bigint not null
        constraint m_workouts_m_users_id_fk
            references m_users,
    muscle_group varchar(20) default 'NOT_SELECTED'::character varying not null,
    exercise varchar(20) default 'NOT_SELECTED'::character varying not null,
    rounds bigint default 0 not null,
    reps bigint default 0 not null,
    created timestamp(6) default CURRENT_TIMESTAMP not null,
    changed timestamp(6) default CURRENT_TIMESTAMP not null,
    is_blocked boolean default false not null
);

alter table m_workouts owner to maxim;

create table m_calendar
(
    id bigserial not null
        constraint m_calendar_pk
            primary key,
    user_id bigint not null
        constraint m_calendar_m_users_id_fk
            references m_users,
    program_id bigserial not null
        constraint m_calendar_m_programs_id_fk
            references m_programs,
    workout_id bigserial not null
        constraint m_calendar_m_workouts_id_fk
            references m_workouts,
    equipment_id bigserial not null
        constraint m_calendar_m_equipment_id_fk
            references m_equipment,
    date date,
    created timestamp(6) default CURRENT_TIMESTAMP not null,
    changed timestamp(6) default CURRENT_TIMESTAMP not null,
    is_blocked boolean default false not null
);

alter table m_calendar owner to maxim;

create table m_roles
(
    id bigserial not null
        constraint m_roles_pk
            primary key,
    user_id bigint not null
        constraint m_roles_m_users_id_fk
            references m_users,
    role_name varchar(20) default 'ROLE_USER'::character varying not null,
    created timestamp(6) default CURRENT_TIMESTAMP not null,
    changed timestamp(6) default CURRENT_TIMESTAMP not null,
    is_blocked boolean default false not null
);

alter table m_roles owner to maxim;

create table l_calendar_equipment
(
    id bigserial not null
        constraint l_calendar_equipment_pk
            primary key,
    calendar_id bigint not null
        constraint l_calendar_equipment_m_calendar_id_fk
            references m_calendar
            on update cascade on delete cascade,
    equipment_id bigint not null
        constraint l_calendar_equipment_m_equipment_id_fk
            references m_equipment,
    created timestamp(6) default CURRENT_TIMESTAMP not null,
    changed timestamp(6) default CURRENT_TIMESTAMP not null,
    is_blocked boolean default false not null
);

alter table l_calendar_equipment owner to maxim;

create index l_calendar_equipment_created_index
    on l_calendar_equipment (created desc);

create table l_programs_workouts
(
    id bigserial not null
        constraint l_programs_workouts_pk
            primary key,
    program_id bigint not null
        constraint l_programs_workouts_m_programs_id_fk
            references m_programs
            on update cascade on delete cascade,
    workout_id bigint not null
        constraint l_programs_workouts_m_workouts_id_fk
            references m_workouts,
    created timestamp(6) default CURRENT_TIMESTAMP not null,
    changed timestamp(6) default CURRENT_TIMESTAMP not null,
    is_blocked boolean default false not null
);

alter table l_programs_workouts owner to maxim;

create index l_programs_workouts_created_index
    on l_programs_workouts (created desc);

create unique index m_users_login_uindex
    on m_users (login);
