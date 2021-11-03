#Matheus Barreto, Nicolas Ruas, Marcos Fonseca, Guilherme pereira, Pablo Gonçalves, Antonio Henrique

select a.ClienteID, a.Contato, a.Endereco, a.Telefone, min(b.DataFatura) as "Menor data", max(b.DataFatura) as "Maior Data", count(*) as "Quantidade de compras"
	from Clientes AS a
    inner join Faturas as b
    on a.ClienteID = b.ClienteID
    where b.DataFatura between "1996-01-01" and "1996-12-31"
    group by ClienteID, Contato, Endereco, Telefone;
    
SELECT LPAD(f.FaturaId, 8, '0') as Fatura,date_format(f.DataFatura,"%Y-%m-%d") as "Data da Fatura", c.Cidade
    from Faturas as f
    inner join Clientes as c
    on c.ClienteID = f.ClienteID
    WHERE c.Pais = "UK"
		AND c.Cidade <> f.CidadeEnvio;
        
SELECT c.*, round(sum(f.Transporte),2) as "Valor Total dos Transportes"
	FROM Correios as c
	Inner Join Faturas as f
    ON c.CorreioID = f.FormaEnvio
    Group by c.CorreioID;
    
SELECT p.ProdutoNome, c.CategoriaNome
	FROM Produtos as p
    INNER JOIN DetalheFatura as d
    on p.ProdutoID = d.ProdutoID
		INNER JOIN Categorias as c
        on p.CategoriaID = c.CategoriaID
    group by p.ProdutoID;
    
SELECT a.FaturaID, date_format(a.DataFatura, "%d/%m/%Y") as "Data Fatura", c.Empresa, b.Empresa, e.ProdutoNome, 
f.CategoriaNome ,d.PrecoUnitario, d.Quantidade
	FROM Faturas as a
    INNER JOIN Clientes as b
		ON a.ClienteID = b.ClienteID
    INNER JOIN Correios as c
		ON a.FormaEnvio = c.CorreioID
    INNER JOIN DetalheFatura as d
		ON a.FaturaId = d.FaturaID
	INNER JOIN Produtos as e
		ON d.ProdutoID = e.ProdutoID
	INNER JOIN Categorias as f
		ON e.CategoriaID = f.CategoriaID;



    

    