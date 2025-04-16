drop table teachar if exists;

create table teachar (
	ID varchar(10) primary key,
	PASSWORD varchar(30),
	NAME varchar(10),
	SCHOOL_CD char(3)
);

insert into teachar values('admin','password','大原花子','oom');