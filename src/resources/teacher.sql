drop table teacher if exists;

create table teacher (
	ID varchar(10) primary key,
	PASSWORD varchar(30),
	NAME varchar(10),
	SCHOOL_CD char(3)
);

insert into teacher values('admin','password','大原花子','oom');