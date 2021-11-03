#Matheus Barreto, Eduardo Gonzales, Vinicius Evandro, Taynan Vitor, Gabriela Lima, Guilherme Carvalho
#1
CREATE VIEW dados_cliente AS
	SELECT ClienteID, Contato, Fax, Telefone
    FROM Clientes;
#2    
SELECT Telefone FROM dados_cliente WHERE Fax = '';
#3
SELECT Telefone FROM Clientes WHERE Fax = '';
#4
CREATE VIEW dados_fornecedor AS
	SELECT ProvedorID, Contato, Empresa, CONCAT(Endereco, ' - ',  Cidade, ' - ', CodigoPostal, ' - ', Pais) as Endereco
    FROM Provedores;
#5
SELECT * FROM Provedores WHERE Endereco LIKE "Av. das Americanas%";
#6    
SELECT * FROM dados_fornecedor WHERE Endereco LIKE "Av. das Americanas%";

#Desafios
CREATE VIEW dados_produtos AS
	SELECT ProdutoID, ProdutoNome, FLOOR(PrecoUnitario) as PrecoUnitario, UnidadesEstoque, UnidadesPedidas,
		CASE
			WHEN UnidadesPedidas = 0 THEN 'BAIXA'
			WHEN UnidadesPedidas < UnidadesEstoque THEN 'MÉDIA'
			WHEN UnidadesPedidas < UnidadesEstoque*2 THEN "URGENTE"
			ELSE "PRIORITARIO"
		END AS Prioridade
		FROM Produtos;
   
SELECT Prioridade, COUNT(*) AS QuantidadeItems, avg(PrecoUnitario) as MediaPrecos FROM dados_produtos
	GROUP BY Prioridade
    HAVING QuantidadeItems > 5;

