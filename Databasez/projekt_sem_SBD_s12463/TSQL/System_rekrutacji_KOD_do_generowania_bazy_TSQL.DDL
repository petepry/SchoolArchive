-- Create new table ZAWOD.
-- ZAWOD : Table of Zawod
-- 	IDZAWOD : IdZawod identifies Zawod
-- 	ZAWOD : Zawod is of Zawod  
create table ZAWOD (
	IDZAWOD int not null IDENTITY(1,1),
	ZAWOD varchar(128) null, constraint ZAWOD_PK primary key (IDZAWOD) ); 

-- Create new table MIEJSCEPRACY.
-- MIEJSCEPRACY : Table of MiejscePracy
-- 	IDOGLOSZENIA : IdOgloszenia partly identifies MiejscePracy
-- 	IDMIASTO : IdMiasto partly identifies MiejscePracy  
create table MIEJSCEPRACY (
	IDOGLOSZENIA int not null,
	IDMIASTO int not null, constraint MIEJSCEPRACY_PK primary key (IDOGLOSZENIA, IDMIASTO) ); 

-- Create new table WYMAGANEWYKSZT.
-- WYMAGANEWYKSZT : Table of WymaganeWykszt
-- 	IDOGLOSZENIA : IdOgloszenia partly identifies WymaganeWykszt
-- 	IDZAWOD : IdZawod partly identifies WymaganeWykszt
-- 	IDJEZYKOBCY : IdJezykObcy is of WymaganeWykszt
-- 	LICZBA : Liczba is of WymaganeWykszt  
create table WYMAGANEWYKSZT (
	IDOGLOSZENIA int not null,
	IDZAWOD int not null,
	IDJEZYKOBCY int null,
	LICZBA varchar(64) null, constraint WYMAGANEWYKSZT_PK primary key (IDOGLOSZENIA, IDZAWOD) ); 

-- Create new table OGLOSZENIE.
-- OGLOSZENIE : Table of Ogloszenie
-- 	IDOGLOSZENIA : IdOgloszenia identifies Ogloszenie
-- 	IDPRACODAWCA : IdPracodawca identifies Ogloszenie
-- 	DATAWAZNOSCI : DataWaznosci is of Ogloszenie  
create table OGLOSZENIE (
	IDOGLOSZENIA int not null IDENTITY(1,1),
	IDPRACODAWCA int not null,
	DATAWAZNOSCI DATE not null, constraint OGLOSZENIE_PK primary key (IDOGLOSZENIA) ); 

-- Create new table PRACODAWCA.
-- PRACODAWCA : Table of Pracodawca
-- 	IDPRACODAWCA : IdPracodawca identifies Pracodawca
-- 	NAZWA : Nazwa is of Pracodawca
-- 	DATAROZPDZIAL : DataRozpoczeciaDzialalnosci is of Pracodawca  
create table PRACODAWCA (
	IDPRACODAWCA int not null IDENTITY(1,1),
	NAZWA varchar(64) not null,
	DATAROZPDZIAL DATE not null, constraint PRACODAWCA_PK primary key (IDPRACODAWCA) ); 

-- Create new table OFERTAPRACY.
-- OFERTAPRACY : Table of OfertaPracy
-- 	IDKANDYDAT : IdKandydat identifies OfertaPracy
-- 	DATAOTWARCIA : DataOtwarcia partly identifies OfertaPracy
-- 	DATAZAMKNIECIA : DataZamkniecia is of OfertaPracy  
create table OFERTAPRACY (
	IDKANDYDAT int not null,
	DATAOTWARCIA DATE not null,
	DATAZAMKNIECIA DATE null, constraint OFERTAPRACY_PK primary key (IDKANDYDAT, DATAOTWARCIA) ); 

-- Create new table WYKSZTALCENIE.
-- WYKSZTALCENIE : Table of Wyksztalcenie
-- 	IDKANDYDAT : IdKandydat partly identifies Wyksztalcenie
-- 	IDZAWOD : IdZawod partly identifies Wyksztalcenie
-- 	IDSZKOLA : IdSzkola is of Wyksztalcenie
-- 	STAZPRACY : StazPracy is of Wyksztalcenie  
create table WYKSZTALCENIE (
	IDKANDYDAT int not null,
	IDZAWOD int not null,
	IDSZKOLA int null,
	STAZPRACY varchar(40) null, constraint WYKSZTALCENIE_PK primary key (IDKANDYDAT, IDZAWOD) ); 

-- Create new table SZKOLA.
-- SZKOLA : Table of Szkola
-- 	IDSZKOLA : IdSzkola identifies Szkola
-- 	NAZWA : Nazwa is of Szkola
-- 	TYP : Typ is of Szkola  
create table SZKOLA (
	IDSZKOLA int not null IDENTITY(1,1),
	NAZWA varchar(128) not null,
	TYP varchar(64) not null, constraint SZKOLA_PK primary key (IDSZKOLA) ); 

-- Create new table ZNAJOMOSCJO.
-- ZNAJOMOSCJO : Table of ZnajomoscJO
-- 	IDKANDYDAT : IdKandydat partly identifies ZnajomoscJO
-- 	IDJEZYKOBCY : IdJezykObcy partly identifies ZnajomoscJO
-- 	POZIOM : Poziom is of ZnajomoscJO  
create table ZNAJOMOSCJO (
	IDKANDYDAT int not null,
	IDJEZYKOBCY int not null,
	POZIOM varchar(64) not null, constraint ZNAJOMOSCJO_PK primary key (IDKANDYDAT, IDJEZYKOBCY) ); 

-- Create new table JEZYKOBCY.
-- JEZYKOBCY : Table of JezykObcy
-- 	IDJEZYKOBCY : IdJezykObcy identifies JezykObcy
-- 	JEZYK : Jezyk is of JezykObcy  
create table JEZYKOBCY (
	IDJEZYKOBCY int not null IDENTITY(1,1),
	JEZYK varchar(64) not null, constraint JEZYKOBCY_PK primary key (IDJEZYKOBCY) ); 

-- Create new table KANDYDAT.
-- KANDYDAT : Table of Kandydat
-- 	IDKANDYDAT : IdKandydat identifies Kandydat
-- 	IMIE : Imie is of Kandydat
-- 	NAZWISKO : Nazwisko is of Kandydat
-- 	DATAURODZENIA : DataUrodzenia is of Kandydat
-- 	INNE : Inne is of Kandydat  
create table KANDYDAT (
	IDKANDYDAT int not null IDENTITY(1,1),
	IMIE varchar(64) not null,
	NAZWISKO varchar(64) not null,
	DATAURODZENIA DATE not null,
	INNE varchar(128) null, constraint KANDYDAT_PK primary key (IDKANDYDAT) ); 

-- Create new table MIASTO.
-- MIASTO : Table of Miasto
-- 	IDMIASTO : IdMiasto identifies Miasto
-- 	NAZWA : Nazwa is of Miasto
-- 	KODPOCZTOWY : KodPocztowy is of Miasto
-- 	IDWOJEWODZTWO : IdWojewodztwo partly identifies Miasto  
create table MIASTO (
	IDMIASTO int not null IDENTITY(1,1),
	NAZWA varchar(64) not null,
	KODPOCZTOWY varchar(20) not null,
	IDWOJEWODZTWO int null, constraint MIASTO_PK primary key (IDMIASTO) ); 

-- Create new table WOJEWODZTWO.
-- WOJEWODZTWO : Table of Wojewodztwo
-- 	IDWOJEWODZTWO : IdWojewodztwo identifies Wojewodztwo
-- 	NAZWA : Nazwa is of Wojewodztwo
-- 	IDKRAJ : IdKraj partly identifies Wojewodztwo  
create table WOJEWODZTWO (
	IDWOJEWODZTWO int not null IDENTITY(1,1),
	NAZWA varchar(64) not null,
	IDKRAJ int null, constraint WOJEWODZTWO_PK primary key (IDWOJEWODZTWO) ); 

-- Create new table KRAJ.
-- KRAJ : Table of Kraj
-- 	IDKRAJ : IdKraj identifies Kraj
-- 	NAZWA : Nazwa is of Kraj  
create table KRAJ (
	IDKRAJ int not null IDENTITY(1,1),
	NAZWA varchar(64) not null, constraint KRAJ_PK primary key (IDKRAJ) ); 

-- Add foreign key constraints to table MIEJSCEPRACY.
alter table MIEJSCEPRACY
	add constraint MIASTO_MIEJSCEPRACY_FK1 foreign key (
		IDMIASTO)
	 references MIASTO (
		IDMIASTO); 

alter table MIEJSCEPRACY
	add constraint OGLOSZENIE_MIEJSCEPRACY_FK1 foreign key (
		IDOGLOSZENIA)
	 references OGLOSZENIE (
		IDOGLOSZENIA); 

-- Add foreign key constraints to table WYMAGANEWYKSZT.
alter table WYMAGANEWYKSZT
	add constraint OGLOSZENIE_WYMAGANEWYKSZT_FK1 foreign key (
		IDOGLOSZENIA)
	 references OGLOSZENIE (
		IDOGLOSZENIA); 

alter table WYMAGANEWYKSZT
	add constraint ZAWOD_WYMAGANEWYKSZT_FK1 foreign key (
		IDZAWOD)
	 references ZAWOD (
		IDZAWOD); 

alter table WYMAGANEWYKSZT
	add constraint JEZYKOBCY_WYMAGANEWYKSZT_FK1 foreign key (
		IDJEZYKOBCY)
	 references JEZYKOBCY (
		IDJEZYKOBCY); 

-- Add foreign key constraints to table OGLOSZENIE.
alter table OGLOSZENIE
	add constraint PRACODAWCA_OGLOSZENIE_FK1 foreign key (
		IDPRACODAWCA)
	 references PRACODAWCA (
		IDPRACODAWCA); 

-- Add foreign key constraints to table OFERTAPRACY.
alter table OFERTAPRACY
	add constraint KANDYDAT_OFERTAPRACY_FK1 foreign key (
		IDKANDYDAT)
	 references KANDYDAT (
		IDKANDYDAT); 

-- Add foreign key constraints to table WYKSZTALCENIE.
alter table WYKSZTALCENIE
	add constraint KANDYDAT_WYKSZTALCENIE_FK1 foreign key (
		IDKANDYDAT)
	 references KANDYDAT (
		IDKANDYDAT); 

alter table WYKSZTALCENIE
	add constraint ZAWOD_WYKSZTALCENIE_FK1 foreign key (
		IDZAWOD)
	 references ZAWOD (
		IDZAWOD); 

alter table WYKSZTALCENIE
	add constraint SZKOLA_WYKSZTALCENIE_FK1 foreign key (
		IDSZKOLA)
	 references SZKOLA (
		IDSZKOLA); 

-- Add foreign key constraints to table ZNAJOMOSCJO.
alter table ZNAJOMOSCJO
	add constraint KANDYDAT_ZNAJOMOSCJO_FK1 foreign key (
		IDKANDYDAT)
	 references KANDYDAT (
		IDKANDYDAT); 

alter table ZNAJOMOSCJO
	add constraint JEZYKOBCY_ZNAJOMOSCJO_FK1 foreign key (
		IDJEZYKOBCY)
	 references JEZYKOBCY (
		IDJEZYKOBCY); 

-- Add foreign key constraints to table MIASTO.
alter table MIASTO
	add constraint WOJEWODZTWO_MIASTO_FK1 foreign key (
		IDWOJEWODZTWO)
	 references WOJEWODZTWO (
		IDWOJEWODZTWO); 

-- Add foreign key constraints to table WOJEWODZTWO.
alter table WOJEWODZTWO
	add constraint KRAJ_WOJEWODZTWO_FK1 foreign key (
		IDKRAJ)
	 references KRAJ (
		IDKRAJ); 
