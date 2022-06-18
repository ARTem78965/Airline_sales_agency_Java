create database airlines;

create table airlines.users(
kod_users int auto_increment primary key not null,
fam varchar(255) not null,
nam varchar(255) not null,
otch varchar(255),
pho char(13) not null,
rol varchar(13) not null,
log varchar(25) not null,
pass varchar(255) not null
);

create table airlines.airport(
kod_airport int auto_increment primary key not null,
nazv varchar(255) not null
);

create table airlines.reis(
kod_reis int auto_increment primary key not null,
nomer_reis char(7) not null,
airport_vilet varchar(255) not null,
airport_naznach int not null,
prodolz char(3) not null,
stoimost decimal(10, 2) not null,
foreign key (airport_naznach) references airlines.airport(kod_airport) 
);

create table airlines.airplace(
kod_airplace int auto_increment primary key not null,
tip_airplace varchar(20) not null,
kol_mest char(3) not null,
dal_pol char(6) not null
);

create table airlines.vilet(
kod_vilet int auto_increment primary key not null,
reis int not null,
vremya_vilet datetime not null,
airplace int not null,
commandir_akipad varchar(20) not null,
foreign key (reis) references airlines.reis(kod_reis),
foreign key (airplace) references airlines.airplace(kod_airplace)
);

create table airlines.passager(
kod_pass int auto_increment primary key not null,
vilet int not null,
nomer_mesta char(3) not null,
FIO varchar(255) not null,
passport varchar(11) not null,
foreign key (vilet) references airlines.vilet(kod_vilet)  
);

create view airlines.reis_view as select 
reis.kod_reis, reis.nomer_reis, reis.airport_vilet, 
airport.nazv, reis.prodolz, reis.stoimost 
from airlines.reis inner join airlines.airport  on airport.kod_airport = reis.airport_naznach;  

create view airlines.passager_view as select
passager.kod_pass, vilet.kod_vilet, passager.nomer_mesta,
passager.FIO, passager.passport
from airlines.passager inner join airlines.vilet on vilet.kod_vilet = passager.vilet;

create view airlines.vilet_view as select
vilet.kod_vilet, reis.nomer_reis, vilet.vremya_vilet,
airplace.tip_airplace, vilet.commandir_akipad
from airlines.vilet 
inner join airlines.reis on reis.kod_reis = vilet.reis 
inner join airlines.airplace on airplace.kod_airplace = vilet.airplace;
 
/*Три представления*/
select * from airlines.reis_view;		/*+*/
select * from airlines.passager_view;	/*+*/
select * from airlines.vilet_view;		/*+*/

/*Шесть таблиц*/
select * from airlines.reis;		/*+*/
select * from airlines.airport;		/*+*/
select * from airlines.passager;	/*+*/
select * from airlines.airplace;	/*+*/
select * from airlines.vilet;		/*+*/
select * from airlines.users;		/*+*/

/*Одна запись на шесть таблиц*/
insert into airlines.airport(nazv) value("Домодедово");
insert into airlines.airport(nazv) value("Шерементьево");
insert into airlines.reis(nomer_reis, airport_vilet, airport_naznach, prodolz, stoimost) values(211054, "Аэропорт", 1, 12, 1200);
insert into airlines.reis(nomer_reis, airport_vilet, airport_naznach, prodolz, stoimost) values(201054, "Аэропорт", 1, 8, 1700);
insert into airlines.airplace(tip_airplace, kol_mest, dal_pol) values("ТУ-134", 96, 2800);
insert into airlines.vilet(reis, vremya_vilet, airplace, commandir_akipad) values(2, '23-12-15 13:00', 1, "Орлов ОО");
insert into airlines.passager(vilet, nomer_mesta, FIO, passport) values(1, 10, "Семенов Семен", "4112 567895");