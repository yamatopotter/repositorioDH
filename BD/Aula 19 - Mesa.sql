#Matheus Barreto, Nicholas Ruas, Gabi Nakasome, Geyson, Maria Rosa Muller, Robelsa Vasconselos

/*Where
1. Exiba os nomes dos produtos que possuem qualquer combinação de
‘spread’.
Tabela: Produtos
Campo: ProdutoNome
2. Mostre os contatos  cujos nomes começam com a letra "Y"
Tabela: clientes
Campo: contato
Order by
3. Mostre cinco produtos mais caros e seus nomes em ordem decrescente
Tabela: produtos
Campos: ProdutoNome, PrecoUnitario
1*/
#1
SELECT ProdutoNome 
	FROM Produtos
    WHERE ProdutoNome LIKE "%spread%";
    
DELIMITER ..
	CREATE PROCEDURE sp_pesquisa_produto(IN pesquisa varchar(30))
    BEGIN
		SELECT ProdutoNome 
			FROM Produtos
			WHERE ProdutoNome LIKE CONCAT("%",pesquisa,"%");
    END ..
DELIMITER ;   

CALL sp_pesquisa_produto("grand");
#2
SELECT Contato FROM Clientes WHERE Contato LIKE "Y%";

DELIMITER capivara
	CREATE PROCEDURE sp_pesquisa_cliente_inicial(IN pesquisa char(1))
    BEGIN
		SELECT Contato
        FROM Clientes 
        WHERE Contato LIKE CONCAT(pesquisa, "%");
    END capivara
DELIMITER ;

CALL sp_pesquisa_cliente_inicial("y");

#3
SELECT ProdutoNome, PrecoUnitario FROM Produtos ORDER BY PrecoUnitario DESC LIMIT 5;

/*Operadores & joins
1. Mostre o contato, o endereço concatenado com a cidade dos clientes
cuja cidade é ‘London’
Tabela: clientes
Campos: Contato, Endereco, Cidade
2. Concatene o nome e o sobrenome dos empregados e mostre a soma
dos valores em Transporte para cada um. Ordene os valores de forma
decrescente.
Tabelas: empregados, faturas
Campos: nome, sobrenome, transporte*/
#1
SELECT Empresa, Contato, concat(Endereco," - ",Cidade) as Endereco 
FROM Clientes 
WHERE Cidade = 'London';

DELIMITER $$
CREATE PROCEDURE sp_dados_clientes(IN endereco_cliente VARCHAR(30))
BEGIN
	SELECT Empresa, Contato, CONCAT(Endereco,' - ',  Cidade) As Endereco
	FROM Clientes
	WHERE Cidade = endereco_cliente;
END $$
DELIMITER ;

#2
SELECT concat(e.nome," ",e.sobrenome) as Nome, round(sum(f.Transporte),2) as TotalTransporte
	FROM Faturas as f
    RIGHT JOIN Empregados as e
    ON e.EmpregadoID = f.EmpregadoID
    GROUP BY e.nome, e.sobrenome
    ORDER BY TotalTransporte;

/*Funções de agregação
1. Mostre a data da fatura mais recente
Tabela: faturas
Campo: DataFatura*/
SELECT max(DataFatura) FROM Faturas;

/*2. Mostre o produto mais barato
Tabelas: produtos
Campos: ProdutoNome, PrecoUnitario*/
SELECT ProdutoNome, PrecoUnitario FROM Produtos ORDER BY PrecoUnitario ASC LIMIT 1;

/*
2
Join e Group by
1. Mostre o nome dos produtos, o valor unitário, a quantidade e o total
vendido por produto.
Tabelas: detalhefaturas e produtos
Campos: ProdutoNome, ValorUnitario e Quantidade*/
SELECT p.ProdutoNome, p.PrecoUnitario, sum(d.Quantidade) as Total
	FROM DetalheFatura as d
	INNER JOIN Produtos as p
    ON d.ProdutoID = p.ProdutoID
    GROUP BY p.ProdutoNome, p.PrecoUnitario;
/*Having
1. Mostre o nome dos produtos, o valor unitário, a quantidade e o total
vendido por produto. Liste apenas os dados dos produtos que venderam
mais de 40 unidades.
Tabelas: detalhefaturas e produtos
Campos: ProdutoNome, ValorUnitario e Quantidade
*/
SELECT p.ProdutoNome, p.PrecoUnitario, sum(d.Quantidade) as TotalVendido
	FROM Produtos as p
    INNER JOIN DetalheFatura as d
    ON p.ProdutoID = d.ProdutoID
    GROUP BY p.ProdutoNome, p.PrecoUnitario
    HAVING TotalVendido > 40;
/*
Índices
1. Exiba os índices existentes na tabela produtos;
*/
SHOW INDEX FROM Produtos;
/*
2. Exclua o índice Produtos_ProdutoNome da tabela Produtos;
*/
DROP INDEX Produtos_ProdutoNome ON Produtos;
/*
3. Crie uma consulta que traga os campos ProdutoNome da tabela
produtos,  ProdutoID, PrecoUnitario e Quantidade da tabela
detalhefatura. Observe o tempo de duração da consulta. 0.00047s*/
select ProdutoId, ProdutoNome, PrecoUnitario, QuantidadePorUnidade FROM Produtos;
/*
4. Crie o índice Produtos_ProdutoNome no campo ProdutoNome da tabela
produtos e repita a consulta do item 3. Observe o tempo de duração da
consulta. Houve alguma diferença? Descreva o que você observou.0.00043s*/
CREATE INDEX Produtos_ProdutoNome ON Produtos(ProdutoNome);
#Houve uma diferença pequena se tratando de uma tabela com 77 linhas, mas caso fosse uma tabela com um numero muito grande de linhas, com certeza isso pouparia
#um bocado de recursos de processamento
