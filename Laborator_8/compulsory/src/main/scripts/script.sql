create table genre(
    id SERIAL,
    name varchar(100)
);

create table artists(
  id SERIAL,
  name varchar(100)
);

create table albums(
    id SERIAL,
    releaseYear int,
    title varchar(100),
    artist_id int
);

create table albums_genre(
    id_album int,
    id_genre int
)

