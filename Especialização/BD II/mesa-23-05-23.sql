-- 1

DELIMITER $$
CREATE PROCEDURE SP_Cliente_Insert(in rg_cli varchar(10), in nome varchar(100), in sobrenome varchar(45), in data_nascimento date, in idScoring int)
begin
	declare haClienteComRg int default 0;
    set haClienteComRg = (select count(*) from clientes where rg = rg_cli);
	if(haClienteComRg = 0) then
		insert into clientes values (null, rg_cli, sobrenome, nome, data_nascimento, idScoring);
	else 
		select "RG já consta na base";
	end if;
end $$

DELIMITER ;

Call dhemprestimos.SP_Cliente_Insert("123456", "Alberto", "Roberto", date("1966-12-12"),1);

-- 2
DELIMITER $$
CREATE FUNCTION fn_validade(data_nasc date, data_inicio_emprestimo date, qtd_parcelas int)
returns varchar(35)
deterministic
begin
	declare dataFinalEmprestimo date;
    declare idadeFinalEmprestimo int;
    
    set dataFinalEmprestimo = date_add(data_inicio_emprestimo, interval qtd_parcelas month);
    set idadeFinalEmprestimo = timestampdiff(year, data_nasc, dataFinalEmprestimo); 
    
    if idadeFinalEmprestimo > 80 then
		return 'O cliente terá mais que 80 anos.';
	else 
		return 'O cliente terá menos que 80 anos.';
    end if;
end $$