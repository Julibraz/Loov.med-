ALTER TABLE MEDICOS ADD COLUMN ATIVO INTEGER;

UPDATE MEDICOS SET ATIVO = 1;

ALTER TABLE MEDICOS ALTER COLUMN ATIVO SET NOT NULL;