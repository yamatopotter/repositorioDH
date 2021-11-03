#Database criado para uso em um sistema de gestão escolar, onde será possivel realizar cadastro de alunos, professores, turmas, disciplinas e responsáveis.
#Através dos relacionamentos existentes será possivel interligar as informações e fazer com que seja possivel esse controle.

Create database escola;

USE escola;

CREATE TABLE aluno(
	alunoId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    matricula INT,
    nome VARCHAR(40),
    sobrenome VARCHAR(40),
    dtNascimento DATE);

CREATE TABLE turma(
	turmaId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    turma INT,
    serie INT,
    sufixo VARCHAR(10),
    ano YEAR,
    ativa BOOLEAN);
    
CREATE TABLE alunoTurma (
	alunoTurmaId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    alunoId INT,
    turmaId INT,
    CONSTRAINT alunoIdAlunoTurma
		FOREIGN KEY (alunoId) REFERENCES aluno(alunoId),
	CONSTRAINT turmaIdAlunoTurma
		FOREIGN KEY (turmaId) REFERENCES turma(turmaId));
        
CREATE TABLE enderecoResponsavel(
	enderecoId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(70),
    numero INT,
    complemento VARCHAR(30),
    bairro VARCHAR(30),
    cidade VARCHAR(30),
    estado CHAR(2));
    
CREATE TABLE responsavel(
	responsavelId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    enderecoId INT,
    nome VARCHAR(40),
    sobrenome VARCHAR(50),
    CONSTRAINT enderecoIdResponsavel
		FOREIGN KEY (enderecoId) REFERENCES enderecoResponsavel(enderecoId)
);

CREATE TABLE contatoResponsavel(
	contatoId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    responsavelId INT,
    telefone  varchar(15),
    CONSTRAINT contatoIdContatoResponsavel
		FOREIGN KEY (responsavelId) REFERENCES responsavel(responsavelId)
);

CREATE TABLE alunoResponsavel(
	alunoResponsavelId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    responsavelId INT,
    alunoId INT,
    CONSTRAINT responsavelIdAlunoResponsavel
		FOREIGN KEY (responsavelId) REFERENCES responsavel(responsavelId),
	CONSTRAINT alunoIdAlunoResponsavel
		FOREIGN KEY (alunoId) REFERENCES aluno(alunoId)
);
    
CREATE TABLE professor(
	professorId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(40),
    sobrenome VARCHAR(50));
    
CREATE TABLE disciplina(
	disciplinaId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    professorId INT,
    nome VARCHAR(40),
    cargaHoraria TIME,
    CONSTRAINT professorIdDisciplina
		FOREIGN KEY (professorId) REFERENCES professor(professorId)
);

CREATE TABLE disciplinaTurma(
	disciplinaTurmaId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    turmaId INT,
    disciplinaId INT,
    CONSTRAINT turmaIdDisciplinaTurma
		FOREIGN KEY (turmaId) REFERENCES turma(turmaId),
	CONSTRAINT disciplinaId
		FOREIGN KEY (disciplinaId) REFERENCES disciplina(disciplinaId)
);

CREATE TABLE presenca(
	presencaId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    alunoId INT,
    disciplinaTurmaId INT,
    dataPresenca DATETIME,
    CONSTRAINT disciplinaTurmaIdPresenca
		FOREIGN KEY (disciplinaTurmaId) REFERENCES disciplinaTurma(disciplinaTurmaId),
	CONSTRAINT alunoIdPresenca
		FOREIGN KEY (alunoId) REFERENCES aluno(alunoId)
);

#INSERTS

INSERT INTO aluno VALUES
	(null, 36586, "Agostinho", "Carrara", "1975/05/01"),
	(null, 36587, "Lineuzinho", "Silva", "1958/02/20"),
	(null, 36588, "Mendonça", "Silva", "1955/10/15");
    
SELECT * FROM aluno;
    
INSERT INTO turma VALUES
	(null, 801, 8, "M", 2021, TRUE),
	(null, 802, 8, "T", 2021, TRUE);
    
INSERT INTO professor VALUES
	(null, "Professor", "Linguiça"),
    (null, "Caio", "Barbosa");
    
INSERT INTO alunoTurma VALUES
	(null, 1, 1),
	(null, 2, 2),
	(null, 3, 2);
    
UPDATE professor 
	SET nome = "Inocencio", sobrenome = "Jirafales" 
    WHERE professorId = 1;
  
#O mysql retorna um erro caso você utilize um select direto no update,
#por isso é preciso fazer essa gambiarra para que seja possivel fazer o update sem saber a ID do aluno diretamente

UPDATE aluno 
	SET nome = "Lineu"
    WHERE alunoId = (SELECT id FROM 
		(SELECT alunoId as id WHERE nome = "Lineuzinho" AND sobrenome = "Silva") AS c);
 
DELETE FROM alunoTurma WHERE alunoTurmaId = 1;

DELETE FROM aluno WHERE alunoId = (SELECT id FROM
	(SELECT alunoId as id where nome="Agostinho" AND sobrenome = "Carrara") as c);
    
SELECT * FROM aluno;

SELECT a.alunoTurmaId as ID, c.nome as NOME, c.sobrenome as SOBRENOME,
	CONCAT(b.turma, b.sufixo)  as TURMA, b.serie as SERIE
	FROM alunoTurma AS a
    INNER JOIN turma as b
    ON a.turmaId = b.turmaId
    INNER JOIN aluno as c
    ON a.alunoId = c.alunoId;

