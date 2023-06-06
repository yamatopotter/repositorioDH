DELIMITER $$
CREATE PROCEDURE musimundos.buscarTotalMedia(IN sequencia VARCHAR(200))
BEGIN
 declare total double default 0;
 declare media float;
 SET @contador = 0;
 set @tamanho = cHAR_LENGTH(sequencia);
 loop_simples: Loop
     SET total = total + cast(substring(sequencia, 1, locate(";", sequencia)-1) as double);
     SET sequencia = substring(sequencia, locate(';', sequencia)+1, char_length(sequencia) - locate(';', sequencia));
     SET @contador = @contador + 1;
     if (@contador >= char_length(sequencia)+1) then
        LEAVE loop_simples;
     END IF;
 END LOOP loop_simples;
 SET media = total / @contador;
 SELECT total, media, @contador, sequencia;
END
$$

call musimundos.buscarTotalMedia('10;10;-10;');

 
SELECT cast(substring('10;10;10', 1, locate(";", '10;10;10')) as float);
select substring('10;10;10', locate(';', '10;10;10')+1, char_length('10;10;10') - locate(';', '10;10;10'));
select char_length('10;10;-10;');
SELECT locate(';', '10;10;10;');