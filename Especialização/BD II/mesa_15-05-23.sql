-- 1

DELIMITER $$
	CREATE PROCEDURE sp_list_employee_data()
    BEGIN
		SELECT e.Nome, e.Sobrenome, f_get_age(e.DataNascimento) as Idade 
        from EMarket.Empregados as e 
        ORDER BY e.Nome ASC;
    END;
$$

-- 2

DELIMITER $$
create procedure usp_list_city(city varchar(50))
begin
	select e.Nome, e.Sobrenome from empregados as e
    where e.Cidade = city and  f_get_age(e.DataNascimento) <25;
end;
$$

CALL usp_list_city

-- 3

DELIMITER //

CREATE FUNCTION MinDataNascimento()
RETURNS DATE
DETERMINISTIC
BEGIN
    RETURN (SELECT MIN(DataNascimento) FROM Clientes);
END //

DELIMITER ;

-- 4
Vendas com desconto:
a) SP que lista vendas com desconto:

DELIMITER //

CREATE PROCEDURE VendasComDesconto(descontoPerc DECIMAL(5,2))
BEGIN
    SELECT p.ProdutoNome, c.Nome, c.Sobrenome, (df.PrecoUnitario * (1 + (descontoPerc/100))) AS PrecoComAumento
    FROM Produtos p
    JOIN DetalheFatura df ON p.ProdutoID = df.ProdutoID
    JOIN Faturas f ON df.FaturaId = f.FaturaId
    JOIN Clientes c ON f.ClienteID = c.ClienteID
    WHERE df.Desconto >= (descontoPerc/100);
END //

DELIMITER ;
