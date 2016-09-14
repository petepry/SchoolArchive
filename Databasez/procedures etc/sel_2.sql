-- SELECT
ALTER PROCEDURE KAND_sel_2
AS
BEGIN
SELECT k.idKandydat, imie, nazwisko, idjezykobcy, idzawod, DataOtwarcia, DataZamkniecia , dataurodzenia,
	StazPracy, poziom, k.inne
	FROM Kandydat k
	JOIN OfertaPracy op ON k.idKandydat = op.idKandydat
	JOIN Wyksztalcenie w ON k.idKandydat = w.idKandydat
	JOIN ZnajomoscJO zjo ON k.idKandydat = zjo.idKandydat
END


-- INSERT
--CREATE PROCEDURE KAND_ins_2
--@IDkandydat INT, @imie varchar(64), @nazwisko varchar(64), @dataurodzenia DATE,  @inne varchar(128), @stazpracy varchar(40),
--@dataotwarcia DATE, @datazamkniecia DATE,
--@IDjezykobcy int, @poziom varchar(64), @IDzawod INT

--AS

--BEGIN
--INSERT INTO KANDYDAT (imie, nazwisko, dataurodzenia, inne)
--VALUES (@imie, @nazwisko, @dataurodzenia, @inne);
----SELECT @IDKAND = idkandydat FROM Kandydat WHERE imie = @imie AND nazwisko = @nazwisko AND dataurodzenia = @dataurodzenia

--INSERT INTO OFERTAPRACY (idkandydat, DATAOTWARCIA, DATAZAMKNIECIA)
--VALUES (@IDKANDYDAT, @dataotwarcia, @datazamkniecia)

--INSERT INTO ZNAJMOSCJO (IDKANDYDAT, IDJEZYKOBCY, poziom)
--VALUES (@IDKANDYDAT, @IDjezykobcy, @poziom)

--INSERT INTO WYKSZTALCENIE (IDKANDYDAT, IDZAWOD, stazpracy)
--VALUES (@IDkandydat, @IDzawod, @stazpracy)

--END;

--+++
-- UPDATE



--CREATE PROCEDURE KAND_upd_2
--@IDkand INT, @IDzawod INT, @idjezykobcy INT,
--@imie varchar(64), @nazwisko varchar(64), @dataotwarcia DATE, @datazamkniecia DATE,
--@dataurodzenia DATE, @stazpracy varchar(40),
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

--UPDATE OFERTAPRACY
--	SET datazamkniecia = @datazamkniecia
--	WHERE idkandydat = @IDkand AND dataotwarcia = @dataotwarcia

--END




--CREATE PROCEDURE KAND_del_2
--@IDkand INT, @IDzawod INT, @IDjezykobcy INT

--AS
--BEGIN
--DELETE FROM Kandydat WHERE idkandydat = @IDkand;
--DELETE FROM Ofertapracy WHERE idkandydat = @IDkand;
--DELETE FROM ZnajomoscJO WHERE idkandydat = @IDkand;
--DELETE FROM Wyksztalcenie WHERE idkandydat = @IDkand;
--END
