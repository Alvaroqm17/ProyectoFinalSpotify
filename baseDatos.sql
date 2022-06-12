drop database if exists FantasyMusic;
create database FantasyMusic;
use FantasyMusic;

create table playlist(
    nombre varchar(40) primary key
);

create table canciones(
nombre VARCHAR(40) PRIMARY KEY
);

create table usuario(
nombre VARCHAR(40) PRIMARY KEY,
contrasenia VARCHAR(40),
email VARCHAR(40)
);

create table playlist_canciones(
nombrePLayList varchar(40),
nombreCanciones varchar(40),
FOREIGN KEY(nombrePlayList) REFERENCES playlist(nombre),
FOREIGN KEY(nombreCanciones) REFERENCES canciones(nombre)
);

#Canciones Joji

INSERT INTO canciones (nombre)
VALUES ("WILL HE");
INSERT INTO canciones (nombre)
VALUES ("WANTED U");
INSERT INTO canciones (nombre)
VALUES ("DEMONS");
INSERT INTO canciones (nombre)
VALUES ("TEST DRIVE");
INSERT INTO canciones (nombre)
VALUES ("RUN");
INSERT INTO canciones (nombre)
VALUES ("YOUR MEN");
INSERT INTO canciones (nombre)
VALUES ("YEAH RIGHT");
INSERT INTO canciones (nombre)
VALUES ("SANCTUARY");
INSERT INTO canciones (nombre)
VALUES ("DAYLIGHT");
INSERT INTO canciones (nombre)
VALUES ("SLOW DANCING IN THE DRAK");

#Canciones Moay

INSERT INTO canciones (nombre)
VALUES ("MONKIMAKER");
INSERT INTO canciones (nombre)
VALUES ("IN THE BACK OF MY CAR");
INSERT INTO canciones (nombre)
VALUES ("NUKISASHI NARANU");
INSERT INTO canciones (nombre)
VALUES ("ROSES FOR MARIA");
INSERT INTO canciones (nombre)
VALUES ("INMUNE TO ME");
INSERT INTO canciones (nombre)
VALUES ("PIRAMIDA");

#Bad bunny

INSERT INTO canciones (nombre)
VALUES ("OJITOS LINDOS");
INSERT INTO canciones (nombre)
VALUES ("MOSCOW MULE");
INSERT INTO canciones (nombre)
VALUES ("TAROT");
INSERT INTO canciones (nombre)
VALUES ("SAFAERA");
INSERT INTO canciones (nombre)
VALUES ("YONAGUNI");
INSERT INTO canciones (nombre)
VALUES ("DAKITI");






