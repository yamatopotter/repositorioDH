CREATE DATABASE spotify;

use spotify;

create table usuario(
	idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeusuario varchar(45),
    data_nac date,
    sexo varchar(1),
    email varchar(150),
    senha varchar(45)
);

CREATE TABLE playlist (
	idplaylist INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idusuario INT NOT NULL,
    CONSTRAINT fk_usuario 
		FOREIGN KEY (idusuario) REFERENCES usuario(idUsuario),
	titulo VARCHAR (45),
    qtdcancoes INT,
    datacriacao DATETIME );
    
CREATE TABLE genero (
	idGenero INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    genero VARCHAR (45)
); 
    
CREATE TABLE artista
(
	idArtista INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	albuns VARCHAR (40),
	nome VARCHAR (30),
	sobrenome VARCHAR (30)
); 

CREATE TABLE album
(
	idAlbum INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(45),
    idArtista INT,
	CONSTRAINT fk_idArtista
		FOREIGN KEY (idArtista)
		REFERENCES artista(idArtista)
) ;

CREATE TABLE cancoes
(
	idCancao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(45),
	duracao DOUBLE,
	qtdreproducao INT,
	qtdlikes INT,
	idAlbum int,
	constraint fkAlbumCancoes
		foreign key(idAlbum) references album(idAlbum)
); 

CREATE TABLE playlist_cancao( 
	idPlaylist_Cancao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idCancao INT,
    IdPlaylist INT,
    CONSTRAINT FKPlaylistCancaoCancao
    FOREIGN KEY (idCancao) REFERENCES cancoes(idCancao),
    CONSTRAINT FKPlaylistCancaoPlaylist
    FOREIGN KEY (idPlaylist) REFERENCES playlist(idPlaylist)  ); 

CREATE TABLE generocancao ( 
	idGeneroCancao INT NOT NULL PRIMARY KEY,
    idCancoes INT,
    idGenero INT,
    CONSTRAINT FKCancoes 
    FOREIGN KEY (idCancoes) REFERENCES cancoes(idCancao),
    CONSTRAINT FKGenero 
    FOREIGN KEY (idGenero) REFERENCES genero(idGenero)
); 
 
 INSERT INTO usuario VALUES (
 