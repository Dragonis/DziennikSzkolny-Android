-- Nazwa bazy danych: Accounts.db

-- pokaz wszystkie tabele w tej bazie danych
SELECT name FROM sqlite_master WHERE type = "table";

create table account(
  id integer primary key autoincrement,
  username varchar(30),
  password varchar(30),
  name varchar(30),
  surname varchar(30)
);

insert into account(`name`,`surname`,`username`,`password`) values('Jan','Kowalski','admin login1','admin password1');
insert into account(`name`,`surname`,`username`,`password`) values('Johny','Brown','Uzytkownik','Haslo');
insert into account(`name`,`surname`,`username`,`password`) values('Wojciech','Sasiela','root','testABCD');

select * from account;

drop table account;

create table student(
id integer primary key autoincrement,
name varchar(30),
surname varchar(30),
classroom integer,
Id_Polish integer,
Id_English integer,
Id_Math integer,
Id_Biology integer,
Id_Religion integer,
Id_WF integer
);

insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Wojtek", "Sasiela", 1, 1,1,1,1,1,1);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Anna", "Kowalska", 1, 2,2,2,2,2,2);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Izabela", "Tarnowska", 1, 3,3,3,3,3,3);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Blanka", "Szept", 1, 4,4,4,4,4,4);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Pawe³", "Paluch", 1, 5,5,5,5,5,5);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Piotr", "Ma³y", 1, 6,6,6,6,6,6);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Karol", "Kopytko", 1, 7,7,7,7,7,7);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Arkadiusz", "B¹k", 1, 8,8,8,8,8,8);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Teresa", "Wawrzyniak", 1, 9,9,9,9,9,9);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Katarzyna", "Jagie³³o", 1, 10,10,10,10,10,10);

insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Barbara", "Lewandowska", 2 ,11,11,11,11,11,11);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Ewelina", "2elik", 2, 12,12,12,12,12,12);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Diana", "Kosma³a", 2,13,13,13,13,13,13);

insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Karolina", "Ordon", 3,14,14,14,14,14,14);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Joanna", "Pieprzyk", 3,15,15,15,15,15,15);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Stefan", "Batory", 3,16,16,16,16,16,16)
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Bartosz", "Zuch", 3,17,17,17,17,17,17);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Jadwiga", "Konieczko", 3,18,18,18,18,18,18);

insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Amelia", "Koral", 4,19,19,19,19,19,19);

insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Justyna", "Boœ", 5, 20,20,20,20,20,20);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Alicja", "Stêpieñ", 5,21,21,21,21,21,21);

insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Kamila", "Piotrowska", 6,22,22,22,22,22,22);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Roksana", "Fajna", 6,23,23,23,23,23,23);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Beata", "Bezpieczna", 6, 24,24,24,24,24,24);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Maria", "Ciekawska", 6,25,25,25,25,25,25);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Marta", "Okoñ", 6,26,26,26,26,26,26);
insert into student(`name`,`surname`,`classroom`,`Id_Polish`,`Id_English`,`Id_Math`,`Id_Biology`,`Id_Religion`,`Id_WF`) values("Angelika", "Weso³owska", 6, 27,27,27,27,27,27);

select * from student;
drop table student;

create table classroom (
  ID_Classroom INTEGER PRIMARY KEY AUTOINCREMENT,
  Name         VARCHAR(30)
);
insert into classroom(`Name`) values ("Przykladowa nazwa klasy");
select * from classroom;