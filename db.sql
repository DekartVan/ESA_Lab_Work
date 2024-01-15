CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE directors
(
    id      SERIAL PRIMARY KEY,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean                  default false                not null,
    name    VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL
);


CREATE TABLE movies
(
    id          SERIAL PRIMARY KEY,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean,
    title       VARCHAR(255) NOT NULL,
    director_id INTEGER REFERENCES directors (id),
    year        INTEGER      NOT NULL,
    rating      INTEGER      NOT NULL
);

CREATE TABLE events_log
(
    id         SERIAL PRIMARY KEY,
    uuid       UUID DEFAULT uuid_generate_v4(),
    created_timestamp    TIMESTAMP DEFAULT statement_timestamp(),
    modified_timestamp   TIMESTAMP DEFAULT statement_timestamp(),
    is_deleted BOOLEAN   DEFAULT FALSE,
    event_type VARCHAR(255) NOT NULL,
    table_name VARCHAR(255) NOT NULL,
    object_id  INTEGER NOT NULL,
    object_uuid UUID NOT NULL
);

create table mail_condition
(
    unique_id              bigserial constraint mail_condition_pkey primary key,
    uuid                   uuid                     default uuid_generate_v4()    not null,
    created_timestamp      timestamp with time zone default statement_timestamp() not null,
    modified_timestamp     timestamp with time zone default statement_timestamp() not null,
    is_deleted             boolean                  default false                 not null,

    address               varchar                                                 not null,
    condition             varchar                                                 not null
);
