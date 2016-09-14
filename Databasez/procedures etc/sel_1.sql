-- SELECT
--ALTER PROCEDURE KAND_select
--AS
--BEGIN
--SELECT k.idKandydat, z.idzawod, jo.idjezykobcy, imie, nazwisko, DataOtwarcia, DataZamkniecia , dataurodzenia, zawod,
--	StazPracy, jezyk, poziom, k.inne
--	FROM Kandydat k
--	JOIN OfertaPracy op ON k.idKandydat = op.idKandydat
--	JOIN Wyksztalcenie w ON k.idKandydat = w.idKandydat
--	JOIN Zawod z ON w.IdZawod = z.idZawod
--	JOIN ZnajomoscJO zjo ON k.idKandydat = zjo.idKandydat
--	JOIN JezykObcy jo ON zjo.idjezykobcy = jo.idJezykObcy
--END


-- INSERT
ALTER PROCEDURE KAND_insert
--@IDkandydat INT,
@idkandydat INT, @imie varchar(64), @nazwisko varchar(64), @dataurodzenia DATE,  @inne varchar(128), @stazpracy varchar(40),
@dataotwarcia DATE, @datazamkniecia DATE,
@jezyk varchar(64), @poziom varchar(64), @zawod varchar(128)

AS
DECLARE
@IDKAND INT,
@IDjezyk INT,
@IDzawod INT
BEGIN
INSERT INTO KANDYDAT (imie, nazwisko, dataurodzenia, inne)
VALUES (@imie, @nazwisko, @dataurodzenia, @inne);
SELECT @IDKAND = idkandydat FROM Kandydat WHERE imie = @imie AND nazwisko = @nazwisko AND dataurodzenia = @dataurodzenia


IF EXISTS (SELECT jezyk FROM jezykobcy WHERE jezyk LIKE @jezyk)
		BEGIN
			SELECT @IDjezyk = idjezykobcy FROM jezykobcy WHERE jezyk LIKE @jezyk;
		END;
	ELSE
		BEGIN
			INSERT INTO JEZYOKOBCY (jezyk)
			VALUES (@jezyk);
			SELECT @IDjezyk = idjezykobcy FROM jezykobcy WHERE jezyk LIKE @jezyk;
		END;

INSERT INTO ZNAJOMOSCJO (IDKANDYDAT, IDJEZYKOBCY, poziom)
VALUES (@IDKAND, @IDjezyk, @poziom)

INSERT INTO OFERTAPRACY (idkandydat, DATAOTWARCIA, DATAZAMKNIECIA)
VALUES (@IDKAND, @dataotwarcia, @datazamkniecia)

IF EXISTS (SELECT zawod FROM ZAWOD WHERE zawod LIKE @zawod)
		BEGIN
			SELECT @IDzawod = idzawod FROM ZAWOD WHERE zawod LIKE @zawod;
		END;
	ELSE
		BEGIN
			INSERT INTO zawod (zawod)
			VALUES (@zawod);
			SELECT @IDzawod = idzawod FROM ZAWOD WHERE zawod LIKE @zawod;
		END;

INSERT INTO WYKSZTALCENIE (IDKANDYDAT, IDZAWOD, stazpracy)
VALUES (@IDkand, @IDzawod, @stazpracy)

END;

--+++
-- UPDATE



--CREATE PROCEDURE KAND_update
--@IDkand INT, @IDzawod INT, @idjezykobcy INT,
--@imie varchar(64), @nazwisko varchar(64), @dataotwarcia DATE, @datazamkniecia DATE,
--@dataurodzenia DATE, @zawod varchar(64), @stazpracy varchar(40), @jezyk varchar(64),
--@poziom varchar (64), @inne varchar(128)

--AS
--BEGIN
--UPDATE KANDYDAT
--	SET imie = @imie, nazwisko = @nazwisko, dataurodzenia = @dataurodzenia, inne = @inne
--	WHERE idkandydat = @IDkand;

--UPDATE ZNAJOMOSCJO
--	SET poziom = @poziom
--	WHERE IDjezykobcy = @idjezykobcy AND idkandydat = @IDkand;

--UPDATE WYKSZTALCENIE
--	SET stazpracy = @stazpracy
--	WHERE idkandydat = @IDkand AND idzawod = @IDzawod;

--UPDATE Zawod
--	SET zawod = @zawod
--	WHERE idzawod = @IDzawod;

--UPDATE Jezykobcy
--	SET jezyk = @jezyk
--	WHERE idjezykobcy = @idjezykobcy;

--UPDATE OFERTAPRACY
--	SET datazamkniecia = @datazamkniecia
--	WHERE idkandydat = @IDkand AND dataotwarcia = @dataotwarcia

--END




--ALTER PROCEDURE KAND_delete
--@IDkand INT, @IDzawod INT, @idjezykobcy INT,
--@imie varchar(64), @nazwisko varchar(64), @dataotwarcia DATE, @datazamkniecia DATE,
--@dataurodzenia DATE, @zawod varchar(64), @stazpracy varchar(40), @jezyk varchar(64),
--@poziom varchar (64), @inne varchar(128)

--AS
--BEGIN
--DELETE FROM Wyksztalcenie WHERE idkandydat = @IDkand;
--DELETE FROM ZnajomoscJO WHERE idkandydat = @IDkand;
--DELETE FROM Ofertapracy WHERE idkandydat = @IDkand;
--DELETE FROM Kandydat WHERE idkandydat = @IDkand;
--END


INSERT INTO ZNAJMOSCJO (IDKANDYDAT, IDJEZYKOBCY, poziom)
VALUES (@IDKANDYDAT, @IDjezykobcy, @poziom)