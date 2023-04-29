drop table if exists genres;
create table genres(
    id SERIAL,
    name varchar(100) unique
);

drop table if exists artists;
create table artists(
  id SERIAL,
  name varchar(100) unique
);

drop table if exists albums;
create table albums(
    id SERIAL,
    release_year int,
    title varchar(100) unique,
    artist_id int
);

drop table if exists albums_genre;
create table albums_genre(
    id_album int,
    id_genre int,
    unique (id_album, id_genre)
)


