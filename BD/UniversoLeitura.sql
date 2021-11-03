CREATE DATABASE UniversoLeitura;

use UniversoLeitura;

CREATE TABLE associados(
	codId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rg char(7),
    nome VARCHAR(50),
    sobrenome varchar(50),
    endereco varchar(150),
    cidade varchar(50),
    estado varchar(2)
);

CREATE TABLE telefones (
	telefoneId INT NOT NULL,
    telefone_socio VARCHAR(100),
    codAssoc INT, 
    PRIMARY KEY (telefoneId),
    CONSTRAINT fk_codAssoc_telefone 
		FOREIGN KEY (codAssoc) REFERENCES associados(codId)
); 

CREATE TABLE autores
(
	codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome_autores VARCHAR(100)
);

create table editoras ( 
	codigo int not null auto_increment primary key,
    razao_social varchar(150),
    telefone varchar(100)
);

create table livros (
	cod_int int not null auto_increment primary key,
    cod_isbn varchar(13),
    titulo varchar(200),
    ano_criacao date,
    cod_autor int,
    ano_publicacao date,
    cod_editora int, 
    constraint fk_livros_autor foreign key (cod_autor) references autores(codigo), 
    constraint fk_livros_editora foreign key (cod_editora) references editoras(codigo)
);

CREATE TABLE emprestimos ( 
	codigo INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    codAssoc INT,
    data DATE,
    prazo_devolucao DATE,
    data_devolucao DATE, 
	CONSTRAINT associados_emprestimo
		FOREIGN KEY (codAssoc) REFERENCES associados(codid) 
); 

CREATE TABLE exemplares(
	codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cod_livro INT NOT NULL,
    sinistro bool,
    CONSTRAINT fk_exemplares
		FOREIGN KEY(cod_livro) REFERENCES livros(cod_int)
);

CREATE TABLE emprestimo_exemplares (
	codigo INT NOT NULL,
    cod_emprestimo INT,
    cod_exemplar INT,
    CONSTRAINT fk_emprestimo_exemplares_emprestimo FOREIGN KEY (cod_emprestimo) REFERENCES emprestimos(codigo),
    CONSTRAINT fk_emprestimo_exemplares_exemplares FOREIGN KEY (cod_exemplar) REFERENCES exemplares(codigo) 
    ); 
 