Create view FATURAS_NACIONAIS as
	Select f.id, f.data_fatura, c.id as idCliente, c.nome, c.sobrenome, f.valor_total
    from faturas as f
    inner join clientes as c
    on f.id_cliente = c.id
    WHERE f.pais_cobranca = "Argentina";
    
SELECT * From FATURAS_NACIONAIS;

Create view LATINOS as
	SELECT a.nome, al.titulo as Album, c.nome as Musica 
    from artistas as a
    inner join albuns as al
    on al.id_artista = a.id
    inner join cancoes as c
    on c.id_album = al.id
    WHERE c.id_genero = (SELECT id FROM generos WHERE nome = "Latin");
    
select * from LATINOS;
    
create view Faturas_Brazil as
	SELECT c.nome, c.sobrenome, f.pais_cobranca, sum(valor_total)
    FROM faturas as f
    INNER JOIN clientes as c
    on c.id = f.id_cliente
    WHERE f.pais_cobranca = "Brazil"
    GROUP BY c.nome, c.sobrenome;
    
SELECT * from Faturas_Brazil;