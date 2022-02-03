drop table if exists url_shortener;

create table if not exists url_shortener
(
    id  identity not null primary key,
    url_hash varchar not null unique ,
    original_url varchar not null,
    created_time timestamp
);