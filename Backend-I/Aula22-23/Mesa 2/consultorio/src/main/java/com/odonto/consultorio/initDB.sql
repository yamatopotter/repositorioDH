CREATE TABLE IF NOT EXISTS usuario(
    id int auto_increment not null primary key,
    nome varchar(50) not null,
    email varchar(50) not null,
    senha varchar(20) not null,
    nivelAcesso varchar(15) not null
);

