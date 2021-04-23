create table Teacher(
       Teacher_id integer,
       first_name varchar(50),
       last_name varchar(50),
       sex varchar(50),
       subject varchar(50)
);

create table Pupil(
       first_name varchar(50),
       last_name varchar(50),
       sex varchar(50),
       class_room varchar(50)
);

create table ClassRoom(
       classroom_name varchar(50),
       math_teacher_id integer,
       physics_teacher_id integer,
       geography_teacher_id integer,
       chemistry_teacher_id integer,
       english_teacher_id integer,
       history_teacher_id integer
);

insert into Teacher
values (1 , 'Marina' , 'Gatashvili' , 'female' , 'Math');
insert into Teacher
values (2 , 'Tamar' , 'Tarashvili' , 'female' , 'English');
insert into Teacher
values (3 , 'Giorgi' , 'Dzagania' , 'Male' , 'Math');
insert into Teacher
values (4 , 'Nino' , 'Parcvania' , 'female' , 'Chemistry');
insert into Teacher
values (5 , 'Nikoloz' , 'Matchavariani' , 'Male' , 'Physics');
insert into Teacher
values (6 , 'Mikheil' , 'Gabiskiria' , 'Male' , 'Geography');
insert into Teacher
values (7 , 'Sandro' , 'Churadze' , 'Male' , 'History');
insert into Teacher
values (8 , 'Ani' , 'Malidze' , 'female' , 'English');
insert into Teacher
values (9 , 'Mariam' , 'Dadiani' , 'female' , 'Physics');

insert into ClassRoom
values ('8 - 1' , 1 , 5 , 6 , 4 , 2 , 7);
insert into ClassRoom
values ('9 - 1' , 3 , 9 , 6 , 4 , 8 , 7);
insert into ClassRoom
values ('10 - 1' , 1 , 5 , 6 , 4 , 8 , 7);
insert into ClassRoom
values ('9 - 2' , 3 , 5 , 6 , 4 , 8 , 7);

insert into Pupil
values ('Giorgi' , 'Gelashvili' , 'Male' , '8 - 1');
insert into Pupil
values ('Mariam' , 'Khidzanishvili' , 'female' , '8 - 1');
insert into Pupil
values ('Luka' , 'Akhalshenishvili' , 'Male' , '9 - 1');
insert into Pupil
values ('Giorgi' , 'Rosephashvili' , 'Male' , '9 - 1');
insert into Pupil
values ('Rati' , 'Mchedlishvili' , 'Male' , '10 - 1');
insert into Pupil
values ('Ana' , 'Okruashvili' , 'female' , '10 - 1');
insert into Pupil
values ('Sofo' , 'Shonia' , 'female' , '9 - 2');
insert into Pupil
values ('Mirian' , 'Ambroladze' , 'Male' , '9 - 2');

select distinct t.first_name , t.last_name , t.sex , t.subject
from Pupil p
join ClassRoom c
on (p.class_room = c.classroom_name) and (p.first_name = 'Giorgi')
join Teacher t
on (c.math_teacher_id = t.teacher_id) or (c.physics_teacher_id = t.teacher_id) or (c.geography_teacher_id = t.teacher_id) or (c.chemistry_teacher_id = t.teacher_id) or (c.english_teacher_id = t.teacher_id) or (c.history_teacher_id = t.teacher_id); 
