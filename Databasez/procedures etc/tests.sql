SELECT k.idKandydat, z.idzawod, jo.idjezykobcy, imie, nazwisko, DataOtwarcia, DataZamkniecia , dataurodzenia, zawod,
	StazPracy, jezyk, poziom, k.inne
	FROM Kandydat k
	JOIN OfertaPracy op ON k.idKandydat = op.idKandydat
	JOIN Wyksztalcenie w ON k.idKandydat = w.idKandydat
	JOIN Zawod z ON w.IdZawod = z.idZawod
	JOIN ZnajomoscJO zjo ON k.idKandydat = zjo.idKandydat
	JOIN JezykObcy jo ON zjo.idjezykobcy = jo.idJezykObcy;


SELECT * FROM KANDYDAT;

sp_help 'dbo.ZNAJOMOSCJO'


@imie varchar(64), @nazwisko varchar(64), @dataurodzenia DATE,  @inne varchar(128), @stazpracy varchar(40),
@dataotwarcia DATE, @datazamkniecia DATE,
@IDjezykobcy int, @poziom varchar(64), @IDzawod INT

--EXEC KAND_insert 'Peter', 'Pan', '19991111', 'inne', '0', '19991111', '19991212', 'angielski', 'zaawansowany',


INSERT INTO JezykObcy (Jezyk)
VALUES ('Wêgierski');