Use EMarket;

#Produtos e Cat

SELECT * From Categorias;
SELECT CategoriaNome, Descricao FROM Categorias;
SELECT * FROM Produtos;
SELECT * FROM Produtos WHERE Descontinuado = 1;
SELECT * FROM Produtos WHERE ProvedorId = 8;
SELECT * FROM Produtos WHERE PrecoUnitario BETWEEN 10 AND 22; 
SELECT * FROM Produtos WHERE UnidadesEstoque < NivelReabastecimento;
SELECT * FROM Produtos WHERE UnidadesEstoque < NivelReabastecimento AND UnidadesPedidas = 0; 

#Clientes
SELECT contato as Nome, Empresa, titulo as Cargo, pais FROM Clientes;
SELECT contato as Nome, titulo as Cargo FROM Clientes WHERE titulo LIKE "Owner";
SELECT contato as Nome FROM Clientes WHERE contato LIKE "C%";

#FATURAS
SELECT * FROM Faturas ORDER BY DataFatura ASC; 
SELECT * FROM Faturas WHERE PaisEnvio = 'USA' AND FormaEnvio < 3 AND FormaEnvio > 3; #não existe 
SELECT * FROM Faturas WHERE ClienteID = 'GOURL'; #sim, ele fez 9 compras 
SELECT * FROM Faturas WHERE EmpregadoID IN (2,3,5,8,9); 

#Produtos
SELECT * FROM Produtos ORDER BY PrecoUnitario DESC;
SELECT * FROM Produtos ORDER BY PrecoUnitario DESC LIMIT 5;
SELECT * FROM Produtos ORDER BY UnidadesEstoque DESC LIMIT 10; 

#DetalheFatura
SELECT FaturaId as Fatura, ProdutoId, Quantidade FROM DetalheFatura;
SELECT FaturaId as Fatura, ProdutoId, Quantidade FROM DetalheFatura ORDER BY Quantidade DESC;
SELECT FaturaId as Fatura, ProdutoId, Quantidade FROM DetalheFatura WHERE Quantidade between 50 and 100 order BY Quantidade DESC;
SELECT FaturaId as 'Numero da Fatura', ProdutoId as Produto, PrecoUnitario*Quantidade as Total FROM DetalheFatura;

#extras
SELECT * FROM Clientes WHERE pais='Brasil' OR pais='México' OR Titulo LIKE 'Sales%'; 
SELECT * FROM Clientes WHERE Empresa LIKE 'A%'; 
SELECT Cidade,Contato AS 'Nome e Sobrenome', Titulo AS Cargo FROM Clientes Where Cidade = 'Madrid'; 
SELECT * FROM Faturas WHERE FaturaId BETWEEN 10.000 AND 10500; 
SELECT * FROM Faturas WHERE FaturaID BETWEEN 10.000 AND 10.500 OR ClienteID LIKE 'B%'; 
SELECT * FROM Faturas WHERE CidadeEnvio='Vancouver' OR FormaEnvio=3; 
SELECT * FROM Empregados WHERE Sobrenome='Buchanan'; 
SELECT * from Faturas WHERE EmpregadoID= 5;