use musimundos;
-- 1

alter table empregados add idade tinyint;

DELIMITER $$
	create function f_idade(dataNascimento datetime)
    returns int deterministic
    begin
        return timestampdiff(YEAR, dataNascimento, now());
    end;
$$

DELIMITER $$
	create procedure sp_atualizar_idade()
    begin
		Update empregados SET idade = f_idade(data_nascimento);
    end;
$$

call sp_atualizar_idade();

-- 2

SELECT nome, compositor, ROW_NUMBER() OVER (PARTITION BY compositor ORDER BY nome) AS num_musicas
FROM musicas;

-- 3

SELECT
  id AS id_fatura,
  id_cliente,
  data_fatura AS data_compra,
  LEAD(data_fatura) OVER (PARTITION BY id_cliente ORDER BY data_fatura) AS proxima_data_compra
FROM faturas;