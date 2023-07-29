create table movie
(
    id     serial primary key,
    name   varchar(255) not null,
    year   int2 not null,
    rating numeric(4, 2) default 0.0,
    count  int2         not null
);
create table actor
(
    id       serial primary key,
    name     varchar(255) not null ,
    surname  varchar(255) not null ,
    movie_id integer references movie (id) on delete cascade on update cascade
);
create table director
(
    id       serial primary key,
    name     varchar,
    surname  varchar,
    movie_id integer references movie (id) on delete cascade on update cascade
);
create table comment
(
    id        serial primary key,
    comment   varchar,
    movie_id  integer references movie (id) on delete cascade on update cascade,
    parent_id integer references comment (id) on delete cascade on update cascade
);
create table genre
(
    id   serial primary key,
    name varchar not null
);
create table movie_to_genre
(
    movie_id integer references movie (id) on delete cascade on update cascade,
    genre_id integer references genre (id) on delete cascade on update cascade
);

insert into movie (name, year, count)
VALUES ('fdsfsd', 4323, 45);

insert into comment (comment, movie_id)
values ('dsfdsfsdfdsf', 1);

-- вставка начальных фильм
insert into movie(name, year, rating, count)
values ('Guardians of the Galaxy',
        2014,
        8.1,
        5);
insert into movie(name, year, rating, count)
values ('Prometheus',
        2012,
        7,
        5);
-- вставка жанр
insert into genre(name) values ('Action');
insert into genre(name) values ('Horror');
insert into genre(name) values ('Adventure');
insert into genre(name) values ('Sci-Fi');
insert into genre(name) values ('Thriller');
insert into genre(name) values ('Animation');
insert into genre(name) values ('Comedy');
insert into genre(name) values ('Family');
insert into genre(name) values ('Drama');
insert into genre(name) values ('Music');
insert into genre(name) values ('Fantasy');
insert into genre(name) values ('History');
insert into genre(name) values ('Biography');
insert into genre(name) values ('Crime');
-- вставка актеры
insert into actor(name, surname, movie_id)
values ('Chris',
        'Pratt',
        (select id from movie where name = 'Guardians of the Galaxy'));
insert into actor(name, surname, movie_id)
values ('Vin',
        'Diesel',
        (select id from movie where name = 'Guardians of the Galaxy'));

insert into actor(name, surname, movie_id)
values ('Bradley',
        'Cooper',
        (select id from movie where name = 'Guardians of the Galaxy'));

insert into actor(name, surname, movie_id)
values ('Zoe',
        'Saldana',
        (select id from movie where name = 'Guardians of the Galaxy'));

-- вставка режиссер

insert into director(name, surname, movie_id)
values ('James',
        'Gunn',
        (select id from movie where name = 'Guardians of the Galaxy'));


insert into movie(name, year, rating, count)
values ('Prometheus',
        2012,
        7,
        7);

insert into actor(name, surname, movie_id)
values ('Noomi',
        'Rapace',
        (select id from movie where name = 'Prometheus'));

insert into director(name, surname, movie_id)
values ('Ridley',
        'Scott',
        (select id from movie where name = 'Prometheus'));


insert into movie(name, year, rating, count)
values ('Split',
        2016,
        7.3,
        5);

insert into actor(name, surname, movie_id)
values ('James',
        'McAvoy',
        (select id from movie where name = 'Split'));

insert into director(name, surname, movie_id)
values ('Night',
        'Shyamalan',
        (select id from movie where name = 'Split'));

insert into comment (comment, movie_id, parent_id)
values ('Замечательный фильм', 1, null);

insert into comment (comment, movie_id, parent_id)
values ('Полностью поддерживаю', null, (select id from comment c where c.comment = 'Замечательный фильм'));

insert into comment (comment, movie_id, parent_id)
values ('Хороший фильм, ходил дважды', 1, null);

insert into comment (comment, movie_id, parent_id)
values ('Сходить дважды это сильно', null, (select id from comment c where c.comment = 'Хороший фильм, ходил дважды'));

insert into comment (comment, movie_id, parent_id)
values ('А зачем вы ходили дважды?', null, (select id from comment c where c.comment = 'Хороший фильм, ходил дважды'));

insert into comment (comment, movie_id, parent_id)
values ('Был сонный в первый раз, заснул на середине, хотел досмотреть', null,
        (select id from comment c where c.comment = 'А зачем вы ходили дважды?'));

select *
from comment;
select *
from actor;
select *
from director;
select *
from movie;

select m FROM Movie m inner join Director d on m.id = d.movie_id inner join Actor a on m.id = a.movie_id where 'Guardians of the Galaxy' = m.name and 2014 = m.year and 'James'= d.name and 'Gunn'= d.surname and 'Vin'= a.name and 'Diesel' = a.surname