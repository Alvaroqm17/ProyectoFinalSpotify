drop database if exists FantasyMusic;
create database FantasyMusic;
use FantasyMusic;

create table playlist(
    nombre varchar(40) primary key
);

create table canciones(
nombre VARCHAR(40) PRIMARY KEY
);

create table playlist_canciones(
nombrePLayList varchar(40),
nombreCanciones varchar(40),
FOREIGN KEY(nombrePlayList) REFERENCES playlist(nombre),
FOREIGN KEY(nombreCanciones) REFERENCES canciones(nombre)
);


