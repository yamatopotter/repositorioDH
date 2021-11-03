use Projeto_Spotify;

SELECT * FROM cancao WHERE titulo LIKE '%z%';
SELECT * FROM cancao WHERE titulo LIKE '_a%_s';
SELECT idPlaylist as Playlist, idusuario as Usuario, titulo as Titulo, qtdcancoes as `Quantidade de Canções`, idestado as Estado, Datacriacao as 'Data de Criação', Dataexclusao as 'Data de Exclusão' FROM playlist ORDER BY qtdcancoes DESC limit 1;
SELECT * FROM usuario order by Data_nac ASC LIMIT 5 offset 10;
SELECT * from cancao order by qtdreproducao desc limit 5;
SELECT * from album order by titulo ASC;
SELECT * FROM album WHERE imagemcapa IS NULL;
INSERT INTO usuario VALUES (20, 'novousuariodespotify@gmail.com', 'Elmer Santos', '15111991', 'Masculino', 'B4129ATF', 'S4321m', 9, 1);
select * from genero; #9 achei a id do genero
SELECT * from cancao where idCancao in (select idcancao from generoxcancao where idGenero = 9); #listei todas as musicas com o genero
DELETE from generoxcancao where IdGenero = 9; #exclui as músicas do genero POP
UPDATE artista SET imagem = 'Imagem em falta' WHERE imagem is null;