select c.*, g.nome
	from cancoes as c
    inner join generos as g    
    on c.id_genero = g.id     
    where compositor = "Willie Dixon" and     
    c.id_genero = (SELECT id from generos WHERE nome = "Blues");

select c.*, g.nome
	from cancoes as c
    inner join generos as g
    on c.id_genero = g.id
    where c.id_genero = (SELECT id FROM generos WHERE nome = "Rock");
    
select a.titulo, ar.nome  
	from albuns as a
    inner join artistas as ar
    on a.id_artista = ar.id;
    
select c.*
	from cancoes as c
    inner join tipos_de_arquivo as t
    on c.id_tipo_de_arquivo = t.id
    where t.nome = "MPEG audio file";
    
select distinct titulo
	from empregados;
    
select distinct c.nome as TituloMusica,  p.nome as Playlist
	from cancoes_playlists as cp
    inner join cancoes as c
    on c.id = cp.id_cancao
    inner join playlists as p
    on p.id = cp.id_playlist;
    
select concat("A música ", c.nome, " foi composta por ", c.compositor)
	from cancoes as c;
    
select * 
	from faturas
    where estado_cobranca is not null;
    
select floor(datediff(data_contratacao, data_nascimento)/365)
	from empregados;
    
select * from faturas where id_cliente=2 order by data_fatura;
    