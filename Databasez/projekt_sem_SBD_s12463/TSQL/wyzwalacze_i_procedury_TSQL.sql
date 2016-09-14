----------WYZWALACZE


-- 1

CREATE TRIGGER tr_insOgloszenie
ON Ogloszenie
FOR INSERT
AS
DECLARE
@dataAkt Date;
BEGIN
	SET @dataAkt = GETDATE();
	IF ((SELECT Datawaznosci FROM inserted) < @dataAkt)
		BEGIN;
			Rollback;
			Raiserror ('Nie mozna wstawic ogloszenia ktore jest juz nieaktualne!', 1, 2);
		END;
END;



-- test:
INSERT INTO OGLOSZENIE (Idogloszenia, Idpracodawca, Datawaznosci)
	VALUES (68, 1, '20051212');





-- 2



ALTER TRIGGER tr_addKraj
ON Kraj
FOR INSERT
AS
DECLARE
@filter varchar(32);
BEGIN
	SET @filter = 'RUSSIA';
	IF ((SELECT nazwa FROM INSERTED) LIKE @filter)
		BEGIN;
			Rollback;
			Raiserror ('Ofert z tego kraju nie przewiduje siê.', 1, 2);
		END;
END;


--test:

SELECT Nazwa FROM KRAJ;
INSERT INTO Kraj (IdKraj, Nazwa)
	VALUES (68, 'RUSSIA');








-------- PROCEDURY

-- 1 z kursorem

DECLARE kursor_Kandydaci CURSOR FOR SELECT Nazwisko, Imie, Year(Dataurodzenia), Inne FROM Kandydat;

CREATE PROCEDURE showCand
AS
DECLARE @Nazwisko Varchar(64), @Imie VarChar(32), @RokUr INT, @Inne Varchar(64), @RokAkt INT;
BEGIN
	SET @RokAkt = YEAR(GETDATE());
	OPEN kursor_Kandydaci;
	FETCH NEXT FROM kursor_Kandydaci INTO @Nazwisko, @Imie, @RokUr, @Inne;
	WHILE @@FETCH_STATUS = 0
	BEGIN
		IF (@Inne = NULL)
			BEGIN
				PRINT @Imie + ' ' + @Nazwisko + ' ma ' + Cast((@RokAkt - @RokUr) AS Varchar) + ' lat';
			END;
		ELSE
			BEGIN
			PRINT @Imie + ' ' + @Nazwisko + ' ma ' + Cast((@RokAkt - @RokUr) AS Varchar) + ' lat, inne: ' + @Inne;
			END;
		FETCH NEXT FROM kursor_Kandydaci INTO @Nazwisko, @Imie, @RokUr, @Inne;
	END;
	CLOSE kursor_Kandydaci;
END;


--test:

EXEC showCand;




-- 2

CREATE PROCEDURE doesPracodawcaExist @nazwaPracodawcy Varchar(64)
AS
BEGIN
	IF EXISTS (SELECT * FROM Pracodawca WHERE nazwa LIKE @nazwaPracodawcy)
		BEGIN
			PRINT 'Pracodawca ' + @nazwaPracodawcy + ' istnieje w bazie.';
		END;
	ELSE
		BEGIN
			PRINT 'Pracodawcy ' + @nazwaPracodawcy + ' nie znaleziono w bazie.';
		END;
END;


-- test:

EXEC doesPracodawcaExist 'IBM';

