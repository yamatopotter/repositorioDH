/* Matheus Barreto, Eduardo Gonzales, Pablo Gonçalves, Fabrina Nunes */ 

create database dhtube;

use dhtube;

create table pais( 
	idPais INT NOT NULL AUTO_INCREMENT primary key, 
    nome VARCHAR(100) );
    
CREATE TABLE avatar ( 
	idAvatar INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    urlimagem VARCHAR(100) ); 

create table usuario(
	idUsuario INT NOT NULL auto_increment primary key,
    nome varchar(45),
    email varchar(45),
    senha varchar(45),
    dataNascimento datetime,
    cep varchar(45),
    Pais_idPais int,
    Avatar_idAvatar int,
    constraint fkAvatar
		foreign key (Avatar_idAvatar) references avatar(idAvatar),
	constraint fkPaisUsuario
		foreign key (Pais_idPais) references pais(idPais));
     
CREATE TABLE playlist ( 
	idPlaylist INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	nome VARCHAR(45), 
    data_criacao datetime, 
    privado SMALLINT, 
    Usuario_idUsuario INT, 
    CONSTRAINT fkplaylist_usuario 
		FOREIGN KEY (Usuario_idUsuario) REFERENCES usuario (idUsuario) ); 
    
CREATE TABLE video ( 
	idVideo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100),
    descricao TEXT,
    tamanho DOUBLE,
    nomeArquivo VARCHAR(100),
    duracao DOUBLE,
    imagem VARCHAR(100),
    qtdReproducoes INT,
    qtdLikes INT,
    qtdDislikes INT,
    privado SMALLINT,
    dataPublicacao DATETIME,
    Usuario_idUsuario INT,
    CONSTRAINT fkUsuario 
		FOREIGN KEY (Usuario_idUsuario) REFERENCES usuario(idUsuario) ); 
     
create table canal(
	idCanal int NOT NULL auto_increment primary key,
    nome varchar(45),
    descricao text,
    dataCriacao datetime,
    Usuario_idUsuario int,
    constraint fkUsuarioCanal
		foreign key (Usuario_idUsuario) references usuario(idUsuario));

CREATE TABLE playlist_video ( 
	Video_idVideo INT, 
    Playlist_idPlaylist int, 
    CONSTRAINT fkplaylistvideo_video 
    FOREIGN KEY (Video_idVideo) REFERENCES video (idVideo), 
    CONSTRAINT fkplaylistvideo_play 
    FOREIGN KEY (Playlist_idPlaylist) REFERENCES playlist (idPlaylist) ); 
    
INSERT INTO pais VALUES(null, 'Brasil'),
(null, 'México'),
(null, 'Arngetina');

SELECT * FROM pais;

update pais SET nome = 'Argentina' WHERE idPais = 3;

SELECT * FROM pais;

delete from pais Where idPais = 3;

SELECT * FROM pais;

INSERT INTO pais VALUES(null, 'Uruguai'); 