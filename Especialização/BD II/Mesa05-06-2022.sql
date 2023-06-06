-- 1
create FULLTEXT INDEX idx_ft_productDescription on adventureworks.productdescription(Description);

-- 2
create FULLTEXT INDEX idx_ft_catalogDescription on adventureworks.productmodel(CatalogDescription);

select *, count(*) as qunatidade_matches from productmodel where MATCH(CatalogDescription) AGAINST("Suitable for any type of riding, on or off-road.") group by ProductModelID;
-- 6 registros
-- 0.00042s
-- Nenhum

-- 3 
select *, format(MATCH(CatalogDescription) AGAINST("Suitable for any type of riding, on or off-road."), 2) as porcentagem_pesquisa from productmodel having porcentagem_pesquisa > 0 order by porcentagem_pesquisa;
-- Mountain 500
-- Mountain 100
-- 0.00073s

-- 4
-- primary key (ProductDescriptionID)
-- Fulltext (Description)
-- Int
-- Text

-- 5
-- 77MiB
-- 1.5Mib

-- 6
-- 144KiB

-- 7
-- 762
-- O valor se refere a quantidade de valores unicos dentro do index

-- 8
ALTER TABLE productdescription DROP INDEX idx_ft_productDescription;



