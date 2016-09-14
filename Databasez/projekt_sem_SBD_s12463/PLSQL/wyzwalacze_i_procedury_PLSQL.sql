----------WYZWALACZE
-- 1
CREATE OR REPLACE TRIGGER del_Kandydat
BEFORE  DELETE
ON KANDYDAT
BEGIN
Raise_application_error(-20235, 'Nie wolno usuwaæ rekordów z tabeli KANDYDAT!');
END;

DELETE KANDYDAT;

-- 2
CREATE OR REPLACE TRIGGER add_School
BEFORE INSERT
ON Szkola
FOR EACH ROW
DECLARE 
v_true int;
BEGIN
SELECT Count(1) INTO v_true FROM Szkola WHERE Nazwa LIKE :new.nazwa;
  IF (v_true > 0) THEN
    Raise_application_error(-20235, 'Taka nazwa szkoly ju¿ istnieje!');
  END IF;
END;



---- PROCEDURY

-- 1 z kursorem
create or replace PROCEDURE show_StazPracy
AS
BEGIN
  DECLARE
  v_each int;
  v_sum int;
  CURSOR stazSum IS SELECT stazpracy FROM wyksztalcenie;
  BEGIN
    v_sum := 0;
    OPEN stazSum;
    LOOP
      FETCH stazSum INTO v_each;
      EXIT WHEN stazSum%NotFound;
      v_sum := v_sum + v_each;
    END LOOP;
    CLOSE stazSum;
    dbms_output.put_line ('Suma stazu pracy w bazie wynosi: '|| v_sum);
  END;
END;



-- 2

CREATE OR REPLACE PROCEDURE addKandydat
(v_id kandydat.idkandydat%TYPE,
v_imie kandydat.imie%TYPE,
v_nazwisko kandydat.nazwisko%TYPE,
v_dataurodzenia kandydat.dataurodzenia%TYPE,
v_inne kandydat.inne%TYPE DEFAULT 'nic ciekawego')
AS
BEGIN
  INSERT INTO KANDYDAT (Idkandydat, imie, nazwisko, dataurodzenia, inne)
    VALUES (v_id, v_imie, v_nazwisko, v_dataurodzenia, v_inne);
END;

-- test:
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY';
SELECT * FROM KANDYDAT;
CALL  (addKandydat(666, 'Jaroslav', 'Nieslavny', '21/12/2012', v_inne => 'tak')); 
SELECT * FROM KANDYDAT;
