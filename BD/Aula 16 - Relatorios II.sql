#Rodrigo Escobar, Matheus Barreto, Glauber Silva, Mateus Praxedes, Lucas Pimenta, Alex Crespo
#1
SELECT c.CategoriaNome, p.ProdutoNome
	FROM Categorias as c
    LEFT JOIN Produtos as p
    ON c.CategoriaID = p.CategoriaID;

#2
SELECT * FROM Clientes
	WHERE ClienteID NOT IN 
		(SELECT DISTINCT ClienteID FROM Faturas);

#3
SELECT p.ProdutoNome, a.Empresa, a.Contato, c.CategoriaNome
	FROM Produtos as p
    INNER JOIN Categorias as c
    on p.CategoriaID = c.CategoriaID
    LEFT JOIN Provedores as a
    on p.ProvedorID = a.ProvedorID;
    
#4
SELECT c.CategoriaID, c.CategoriaNome, c.Descricao, ifnull(round(avg(p.PrecoUnitario),2),0) as Preco_Medio
	FROM Categorias as c
    LEFT JOIN Produtos as p
    ON c.CategoriaID = p.CategoriaID
    GROUP BY c.CategoriaID, c.CategoriaNome, c.Descricao;
    
#5
SELECT c.Empresa, date_format(max(f.DataFatura), "%d/%m/%Y") as "Ultima Compra"
	From Clientes as c
    left join Faturas as f
    on c.ClienteID = f.ClienteID
    group by c.Empresa;
    
#6
SELECT c.*, count(f.faturaID)
	FROM Correios AS c
    RIGHT JOIN Faturas as f
    on c.CorreioID = f.FormaEnvio;
    

 
