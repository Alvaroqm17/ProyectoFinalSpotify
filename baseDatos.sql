drop database if exists FantasyMusic;
create database FantasyMusic;
use FantasyMusic;

create table playlist(
    nombre varchar(40) primary key
);

create table canciones(
nombre VARCHAR(40) PRIMARY KEY
);

create table canciones_añadidas(
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
FOREIGN KEY(nombreCanciones) REFERENCES canciones_añadidas(nombre)
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

#Artic Monkeys

INSERT INTO canciones (nombre)
VALUES ("DO I WANNA KNOW?");
INSERT INTO canciones (nombre)
VALUES ("ARABELLA");
INSERT INTO canciones (nombre)
VALUES ("R U MINE");
INSERT INTO canciones (nombre)
VALUES ("TEDDY PICKER");
INSERT INTO canciones (nombre)
VALUES ("FLUORESCENT ADOLESCENT");
INSERT INTO canciones (nombre)
VALUES ("OLD YELLOW BRICKS");

#Bring me the horizon

INSERT INTO canciones (nombre)
VALUES ("CAN YOU FEEL MY HEART");
INSERT INTO canciones (nombre)
VALUES ("DOOMED");
INSERT INTO canciones (nombre)
VALUES ("THRONE");
INSERT INTO canciones (nombre)
VALUES ("FOLLOW YOU");
INSERT INTO canciones (nombre)
VALUES ("SHADOW MOSES");
INSERT INTO canciones (nombre)
VALUES ("SLEEP WALKING");

#Metalica

INSERT INTO canciones (nombre)
VALUES ("SAD BUT TRUE");
INSERT INTO canciones (nombre)
VALUES ("ENTER SANDMAN");
INSERT INTO canciones (nombre)
VALUES ("THE UNFORGIVEN");
INSERT INTO canciones (nombre)
VALUES ("MASTER OF PUPPETS");
INSERT INTO canciones (nombre)
VALUES ("NOTHING ELSE MATTER");
INSERT INTO canciones (nombre)
VALUES ("WHISKEY IN THE JAR");






