create table movie(
    id serial8,
    name varchar(255) not null ,
    year varchar(255) not null ,
    rating numeric(4,2) default 0.0,
    count int2 not null
);
create table actor(
                      id serial primary key,
                      name varchar,
                      surname varchar,
                      movie_id integer references movie(id) on delete cascade on update cascade
);
create table director(
                         id serial primary key,
                         name varchar,
                         surname varchar,
                         movie_id integer references movie(id) on delete cascade on update cascade
);
create table comment(
                        id serial primary key,
                        comment varchar,
                        movie_id integer references movie(id) on delete cascade on update cascade,
                        parent_id integer references comment(id) on delete cascade on update cascade
);
create table genre(
                      id serial primary key,
                      name varchar not null
);
create table movie_to_genre(
                               id serial primary key,
                               movie_id integer references movie(id) on delete cascade on update cascade,
                               genre_id integer references genre(id) on delete cascade on update cascade
);