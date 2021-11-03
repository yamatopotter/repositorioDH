#Matheus Barreto, Juliana Ruama, Jonathas Magalhães, Pedro Oliveira
#1
SELECT MAX(valor_total) AS maior_fatura FROM faturas WHERE cidade_cobranca = "Oslo";
#2
SELECT MIN(valor_total) AS menor_fatura FROM faturas;
#3
SELECT AVG(valor_total) AS media_fatura FROM faturas WHERE pais_cobranca = "Canada";
#4
SELECT COUNT(*) AS total_registros FROM faturas WHERE pais_cobranca = "Canada";
#5
SELECT SUM(valor_total) AS soma_faturas FROM faturas; 
#6
SELECT id, data_fatura, valor_total from faturas group by id having valor_total < (SELECT avg(valor_total) FROM faturas);
#7
SELECT max(data_nascimento) from empregados;
#8
SELECT min(data_nascimento) FROM  empregados;
#9
SELECT DATE_FORMAT(data_nascimento, "%d %b %Y") as "Data de Nascimento" from empregados;
#10
SELECT COUNT(*) FROM cancoes WHERE compositor = "AC/DC";
#11
SELECT AVG(duracao_milisegundos) FROM cancoes;
#12
SELECT AVG(bytes) FROM cancoes WHERE `compositor`= 'AC/DC';
#13
SELECT COUNT(*) FROM clientes WHERE cidade = 'São Paulo';
#14
SELECT COUNT(*) FROM clientes WHERE cidade = 'Paris';
#15
SELECT COUNT(*) FROM clientes WHERE email LIKE '%@yahoo%';